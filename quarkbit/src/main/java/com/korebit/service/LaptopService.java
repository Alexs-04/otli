package com.korebit.service;

import com.korebit.dto.LaptopAddRequest;
import com.korebit.exception.LaptopNotFundException;
import com.korebit.model.Laptop;
import com.korebit.repository.LaptopRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Inject
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public Response saveLaptop(LaptopAddRequest request) {
        var existingLaptop = laptopRepository.findByName(request.name());
        if (existingLaptop.isPresent()) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        var laptop = Laptop.builder()
                .name(request.name())
                .trademark(request.trademark())
                .model(request.model())
                .cpu(request.cpu())
                .isTouchScreen(request.isTouchScreen())
                .price(request.price())
                .build();

        laptopRepository.persist(laptop);

        return Response.status(Response.Status.CREATED).entity(request).build();
    }

    public Laptop getLaptop(Long laptopId) {
        return laptopRepository.findByIdOptional(laptopId)
                .orElseThrow(() -> new LaptopNotFundException("Laptop whit id " + laptopId + " not found"));
    }

    public Response deleteLaptop(Long laptopId) {
        var laptop = laptopRepository.findByIdOptional(laptopId)
                .orElseThrow(() -> new LaptopNotFundException("Laptop whit id " + laptopId + " not found"));

        laptopRepository.delete(laptop);
        return Response.status(Response.Status.OK).build();
    }

    public PanacheQuery<Laptop> getLaptops(int pageNumber, int pageSize) {
        Page page = Page.of(pageNumber, pageSize);
        return laptopRepository
                .findAll(Sort.by("price").ascending().and("name").ascending())
                .page(page);
    }

    public List<Laptop> getLenovoLaptops() {
        return laptopRepository.list("trademark", "Lenovo");
    }

    public List<Laptop> getLaptopsByDescriptionOrModel(String description) {
        String filter = "%" + description + "%";
        return laptopRepository.list("model like ?1 or name like ?1", filter);
    }

    public List<Laptop> getLaptopsByProcessorAndTrademark(String processor, String trademark) {
        return laptopRepository.list("cpu = ?1 and trademark = ?2", processor, trademark);
    }

    //TODO: Fix this method to use the new filter API instead of the deprecated one
    @SuppressWarnings("deprecation")
    public List<Laptop> getLaptopsIfIsTouchScreen(Boolean isTouchScreen) {
        return laptopRepository.findAll()
                .filter("laptopFilter", io.quarkus.panache.common.Parameters.with("isTouchScreen", isTouchScreen))
                .list();
    }
}
