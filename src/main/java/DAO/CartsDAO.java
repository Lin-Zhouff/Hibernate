package DAO;

import Model.Carts;
import Model.Products;

import java.util.List;

public interface CartsDAO {

    int saveCart(Carts cart);

    void updateCart(Carts cart);

    void deleteCart(int id);

    Carts findCartById(int id);

    List<Carts> findAllCarts();

    void addProdToCart(Products product, Carts cart);

    void removeProdFromCart(Products product, Carts cart);
}
