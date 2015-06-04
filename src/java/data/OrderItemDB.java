/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.OrderItem;
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
public class OrderItemDB {

    public OrderItemDB() {

    }

    public static void addOrderItems(List<OrderItem> orderItems, int orderNumber) {

        for (OrderItem o : orderItems) {
            o.setOrderNumber(orderNumber);
            EntityManager em = DBUtil.getEmFactory().createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            try {
                em.persist(o);
                trans.commit();
            } catch (Exception e) {
                System.out.println(e);
                trans.rollback();
            } finally {
                em.close();
            }
        }

    }

    public static List<OrderItem> getAllOrderItems() {
        List<OrderItem> allOrdersItems = new ArrayList<OrderItem>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM OrderItem u ";
        TypedQuery<OrderItem> q = em.createQuery(qString, OrderItem.class);
        try {

            allOrdersItems = q.getResultList();
            return allOrdersItems;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static List<OrderItem> getOrderItems(int orderNumber) {
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM OrderItem u "
                + "WHERE u.orderNumber = :orderNumber";
        TypedQuery<OrderItem> q = em.createQuery(qString, OrderItem.class);
        q.setParameter("orderNumber", orderNumber);
        try {
            orderItems = q.getResultList();
            return orderItems;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}
