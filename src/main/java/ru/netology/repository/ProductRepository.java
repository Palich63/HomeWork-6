package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product item) {
        Product[] tmpProd = new Product[products.length + 1];
        System.arraycopy(products, 0, tmpProd, 0, products.length);
        tmpProd[tmpProd.length - 1] = item;
        products = tmpProd;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        Product[] tmpProd = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmpProd[index] = product;
                index++;
            }
        }
        products = tmpProd;
    }
}
