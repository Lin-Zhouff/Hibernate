package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Carts {

    protected int id;

    protected String name;

    private Set<Products> products = new HashSet<Products>();

    public void addProd(Products prod) {
        this.products.add(prod);
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public Carts() {
    }

    public Carts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Carts(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Carts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
