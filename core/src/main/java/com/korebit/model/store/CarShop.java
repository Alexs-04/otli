package com.korebit.model.store;

import java.util.List;

public class CarShop {
    private List<Product> products;

    public CarShop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return products
                .stream()
                .reduce(0.0, (total, product) -> total + product.getPrice(), Double::sum);
    }
}
