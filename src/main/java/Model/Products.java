package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Products {

    protected int id;

    protected String name;

    protected String price;

    private Set<Carts> carts = new HashSet<Carts>();

    public Set<Carts> getCarts() {
        return carts;
    }

    public void setCarts(Set<Carts> carts) {
        this.carts = carts;
    }

    public Products() {
    }

    public Products(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Products(String name, String price) {
        this.name = name;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
