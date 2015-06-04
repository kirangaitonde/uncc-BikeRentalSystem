/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Product;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author K G
 *
 * Reference : Murach's Java Servlets and JSP (2nd Edition)
 */
public class ProductDB {

    //private ArrayList<Product> products =new ArrayList<Product>();
    public ProductDB() {

    }

    public static void addProduct(String productCode, String productName, int categoryCode, String catalogCategory, String description, float price, String imageUrl) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            Product product = new Product();
            product.setProductCode(productCode);
            product.setProductName(productName);
            product.setCategory(catalogCategory);
            product.setDescription(description);
            product.setHourlyPrice(price);
            product.setImageUrl(imageUrl);
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void addProduct(Product product) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {

            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }

    }

    public static List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<Product>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p ";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        try {

            allProducts = q.getResultList();
            return allProducts;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static List<Product> getProducts(String category) {

        List<Product> products = new ArrayList<Product>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p "
                + "WHERE p.productCategory = :category";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("category", category);
        try {

            products = q.getResultList();
            return products;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

    }

    public static Product getProduct(String productCode) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p "
                + "WHERE p.productCode = :productCode";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("productCode", productCode);
        try {
            Product product = q.getSingleResult();
            return product;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static int updateHourlyPrice(String productCode, double price) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        String qString = "UPDATE Product p SET p.hourlyPrice = price "
                + "WHERE p.productCode = productCode";
        Query q = em.createQuery(qString);
        //q.setParameter("productCode", productCode);
        int count = 0;
        try {
            trans.begin();
            count = q.executeUpdate();
            trans.commit();
            return count;
        } catch (Exception e) {
            trans.rollback();
            return 0;
        } finally {
            em.close();
        }
    }

    public static int addDiscount(String productCode, double discount) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        String qString = "UPDATE Product p SET p.discount = discount "
                + "WHERE p.productCode = :productCode";
        Query q = em.createQuery(qString);
        q.setParameter("productCode", productCode);
        int count = 0;
        try {
            trans.begin();
            count = q.executeUpdate();
            trans.commit();
            return count;
        } catch (Exception e) {
            trans.rollback();
            return 0;
        } finally {
            em.close();
        }
    }

    // update and delete method work in progress
    /*public static int updateProduct(Product product) {
     ConnectionPool pool = ConnectionPool.getInstance();
     Connection connection = pool.getConnection();
     PreparedStatement ps = null;

     String query = "UPDATE Assignment3DB.Product SET "
     + "productCode = ?, "
     + "productName = ?, "
     .
     .
     .
    
     + "WHERE EmailAddress = ?";
     try {
     ps = connection.prepareStatement(query);
     ps.setString(1, user.getFirstName());
     ps.setString(2, user.getLastName());
     ps.setString(3, user.getEmailID());

     return ps.executeUpdate();
     } catch (SQLException e) {
     e.printStackTrace();
     return 0;
     } finally {
     DBUtil.closePreparedStatement(ps);
     pool.freeConnection(connection);
     }
     }
    
     public static int delete(User user) {
     ConnectionPool pool = ConnectionPool.getInstance();
     Connection connection = pool.getConnection();
     PreparedStatement ps = null;

     String query = "DELETE FROM User "
    
     .
     .
     .
     .
     + "WHERE EmailAddress = ?";
     try {
     ps = connection.prepareStatement(query);
     ps.setString(1, user.getEmailID());

     return ps.executeUpdate();
     } catch (SQLException e) {
     e.printStackTrace();
     return 0;
     } finally {
     DBUtil.closePreparedStatement(ps);
     pool.freeConnection(connection);
     }
     }*/
    // Assignment2 methods
    /*public void addProducts(Product product){
     products.add(product);
     }
            
     public ArrayList<Product> getProducts(){
     return products;
     }
    
     public ArrayList<Product> getProducts(String category){
     ArrayList <Product> categoryProducts = new ArrayList<Product>();
     for(Product p :products){
     if(p.getCategory().equals(category)) {
     categoryProducts.add(p);
     }
     }
     return categoryProducts;
     }   
    
     public static void main(String [] args){
     ProductDB pDB = new ProductDB();
     ArrayList<Product> allProductList = pDB.getProducts();
     System.out.println(allProductList.get(2).getProductName());
     }*/
}
