package DAO;

import Model.Products;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductsDAOImpl implements ProductsDAO{

    private static ProductsDAOImpl productsDAOImpl = null;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public int saveProduct(Products products) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(products);
        transaction.commit();
        session.close();

        return id;
    }

    @Override
    public void updateProduct(Products products) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(products);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProduct(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Products product = session.get(Products.class, id);
        session.delete(product);
        transaction.commit();
        session.close();
    }

    @Override
    public Products findProductById(int id) {
        Session session = this.sessionFactory.openSession();
        Products product = session.get(Products.class, id);
        session.close();

        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Products> findAllProducts() {
        Session session = this.sessionFactory.openSession();
        List<Products> productList = session.createQuery("from Products", Products.class).list();
        session.close();

        return productList;
    }

    public static ProductsDAO getInstance() {
        if(productsDAOImpl == null)
            productsDAOImpl = new ProductsDAOImpl();

        return productsDAOImpl;
    }
}
