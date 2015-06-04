/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import business.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K G
 */
public class UserDB {

    //private ArrayList<User> users = new ArrayList<User>();
    public UserDB() {

    }

    public static void addUser(String firstName, String lastName, String email, String address1, String address2, String city, String state, String postCode, String country, String password, String userName, String roleName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmailID(email);
            user.setAddressLine1(address1);
            user.setAddressLine2(address2);
            user.setCity(city);
            user.setState(state);
            user.setPostCode(postCode);
            user.setPostCode(country);
            user.setPostCode(password);
            user.setPostCode(userName);
            user.setPostCode(roleName);
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void addUser(User user) {

        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<User>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u ";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        try {

            allUsers = q.getResultList();
            return allUsers;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }

    }

    public static User getUser(int userID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.userID = :userID";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("userID", userID);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static User getUser(String emailID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u "
                + "WHERE u.emailID = :emailID";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("emailID", emailID);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    // update and delete methods work in progress
    /*public static int updateUser(User user) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
     EntityTransaction trans = em.getTransaction();
     trans.begin();       
     try {
     em.merge(user);
     trans.commit();
     } catch (Exception e) {
     System.out.println(e);
     trans.rollback();
     } finally {
     em.close();
     }
     }

     public static int delete(User user) {
     EntityManager em = DBUtil.getEmFactory().createEntityManager();
     EntityTransaction trans = em.getTransaction();
     trans.begin();        
     try {
     em.remove(em.merge(user));
     trans.commit();
     } catch (Exception e) {
     System.out.println(e);
     trans.rollback();
     } finally {
     em.close();
     }     
     }*/
    //Assignment2 methods
    /*
     public User getUserUsingEmail(String email) {
     for (User u : users) {
     if (u.getEmailID().equals(email)) {
     return u;
     }
     }
     return null;
     }

     public ArrayList<User> getUsers() {
     return users;
     }*/
}
