/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Orders;
import business.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author K G
 */
public class OrdersDB {

    public OrdersDB() {

    }

    public static void addOrders(Orders order) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Orders> getAllOrders() {
        List<Orders> allOrders = new ArrayList<Orders>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Orders u ";
        TypedQuery<Orders> q = em.createQuery(qString, Orders.class);
        try {

            allOrders = q.getResultList();
            return allOrders;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static List<Orders> getOrders(int userID) {
        List<Orders> orders = new ArrayList<Orders>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Orders u "
                + "WHERE u.userID = :userID";
        TypedQuery<Orders> q = em.createQuery(qString, Orders.class);
        q.setParameter("userID", userID);
        try {
            orders = q.getResultList();
            return orders;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Orders getOrderUsingOrderNumber(int orderNumber) {
        Orders o = new Orders();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM Orders u "
                + "WHERE u.orderNumber = :orderNumber";
        TypedQuery<Orders> q = em.createQuery(qString, Orders.class);
        q.setParameter("orderNumber", orderNumber);
        try {
            o = q.getSingleResult();
            return o;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static int getCurrentOrderNumber() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT MAX(u.orderNumber) from Orders u";
        try {
            return (Integer) em.createQuery(qString).getSingleResult();
        } catch (NoResultException e) {
            return 0;
        } finally {
            em.close();
        }
    }

}
