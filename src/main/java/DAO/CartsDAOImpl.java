package DAO;

import Model.Carts;
import Model.Products;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CartsDAOImpl implements CartsDAO{

    private static CartsDAOImpl cartsDAOImpl = null;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addProdToCart(int prodid, int cartid) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Products product = session.get(Products.class, prodid);
        Carts cart = session.get(Carts.class, cartid);
        cart.addProd(product);
        session.save(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public int saveCart(Carts cart) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(cart);
        transaction.commit();
        session.close();

        return id;
    }

    @Override
    public void updateCart(Carts cart) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCart(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Carts carts = session.get(Carts.class, id);
        session.delete(carts);
        transaction.commit();
        session.close();
    }

    @Override
    public Carts findCartById(int id) {
        Session session = this.sessionFactory.openSession();
        Carts carts = session.get(Carts.class, id);
        session.close();

        return carts;
    }

    @Override
    public List<Carts> findAllCarts() {
        Session session = this.sessionFactory.openSession();
        List<Carts> cartList = session.createQuery("from Carts", Carts.class).list();
        session.close();

        return cartList;
    }



    @Override
    public void removeProdFromCart(Products product, Carts cart) {

    }


    public static CartsDAO getInstance() {
        if(cartsDAOImpl == null)
            cartsDAOImpl = new CartsDAOImpl();

        return cartsDAOImpl;
    }
}
