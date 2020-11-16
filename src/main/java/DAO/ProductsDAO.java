package DAO;

import Model.Products;

import java.util.List;

public interface ProductsDAO {

    int saveProduct(Products products);

    void updateProduct(Products products);

    void deleteProduct(int id);

    Products findProductById(int id);

    List<Products> findAllProducts();
}