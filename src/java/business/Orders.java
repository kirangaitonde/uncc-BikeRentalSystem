/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.UserDB;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author K G
 */
@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderNumber;
    private String orderDate;
    private int userID;
    private double taxRate = 10.0;
    private double totalCost;
    private boolean paid;

    public Orders() {
        orderNumber = 0;
        orderDate = "";
        userID = 0;
        taxRate = 10.0;
        totalCost = 0.0;
        paid = false;
    }

    public Orders(String orderDate, int userID, double subTotal, boolean paid) {
        this.orderDate = orderDate;
        this.userID = userID;
        this.taxRate = 10.0;
        this.totalCost = getTotal(subTotal);
        this.paid = paid;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {

        return UserDB.getUser(userID);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTax(double subTotal) {
        double tax = (subTotal * taxRate) / 100;
        return tax;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTotal(double subTotal) {
        double tax = getTax(subTotal);
        return subTotal + tax;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setOrderItems(boolean paid) {
        this.paid = paid;
    }

}
