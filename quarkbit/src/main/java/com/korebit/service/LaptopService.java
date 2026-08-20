package com.korebit.service;

import com.korebit.dto.LaptopAddRequest;
import com.korebit.exception.LaptopNotFundException;
import com.korebit.model.Laptop;
import com.korebit.repository.LaptopRepository;
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
                .build();

        laptopRepository.persist(laptop);

        return Response.ok().build();
    }

    public Laptop getLaptop(Long laptopId) {
        return laptopRepository.findByIdOptional(laptopId)
                .orElseThrow(() -> new LaptopNotFundException("Laptop whit id " + laptopId + " not found"));
    }

    public void deleteLaptop(Long laptopId) {
        var laptop = laptopRepository.findByIdOptional(laptopId)
                .orElseThrow(() -> new LaptopNotFundException("Laptop whit id " + laptopId + " not found"));

        laptopRepository.delete(laptop);
    }

    public List<Laptop> getLaptops() {
        return laptopRepository.listAll();
    }
}
