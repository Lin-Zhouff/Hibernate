import DAO.*;
import Model.*;
import Util.HibernateUtil;

import java.util.List;


public class main {
    public static void main(String args[]){
        ProductsDAO products = ProductsDAOImpl.getInstance();
        CartsDAO cart2 = CartsDAOImpl.getInstance();

        List<Products> productsList;

        Carts newcart = new Carts( "Linfeng");
        cart2.saveCart(newcart);

        Products newprod = new Products("iphone 12 pro", "999");
        products.saveProduct(newprod);

        productsList = products.findAllProducts();
        System.out.println("Add a new product:");
        for (Products product : productsList) {
            System.out.println(product.toString());
        }


        cart2.addProdToCart(1,1);


//        List<Products> productsList = products.findAllProducts();
//        for (Products product : productsList) {
//            System.out.println(product.toString());
//        }
//        Products newprod = new Products("iphone 12 pro", "999");
//        products.saveProduct(newprod);
//
//        productsList = products.findAllProducts();
//        System.out.println("Add a new product:");
//        for (Products product : productsList) {
//            System.out.println(product.toString());
//        }
//
//        products.deleteProduct(newprod.getId());
//        productsList = products.findAllProducts();
//        System.out.println("Delete the new product:");
//        for (Products product : productsList) {
//            System.out.println(product.toString());
//        }
//
//
//
//        System.out.println("\n");
//
//        List<Carts> cartsList = carts.findAllCarts();
//        for (Carts cart : cartsList) {
//            System.out.println(cart.toString());
//        }
//
//        Carts newcart = new Carts("Beibin Yang");
//        carts.saveCart(newcart);
//        cartsList = carts.findAllCarts();
//        System.out.println("Add a new cart:");
//        for (Carts cart : cartsList) {
//            System.out.println(cart.toString());
//        }
//
//        carts.deleteCart(newcart.getId());
//        cartsList = carts.findAllCarts();
//        System.out.println("Delete the new cart:");
//        for (Carts cart : cartsList) {
//            System.out.println(cart.toString());
//        }

    }
}
