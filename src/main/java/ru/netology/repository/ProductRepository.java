package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save () {}

    public Product[] findAll(){
        return items;
    }

    public void removeById(int id) {}
}
