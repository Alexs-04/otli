package com.korebit.repository;

import com.korebit.model.Laptop;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class LaptopRepository implements PanacheRepository<Laptop> {
    public Optional<Laptop> findByName(String name) {
        return find("name", name).firstResultOptional();
    }
}
