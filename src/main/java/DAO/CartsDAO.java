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

    void addProdToCart(int prodid, int cartid);

    void removeProdFromCart(Products product, Carts cart);
}
