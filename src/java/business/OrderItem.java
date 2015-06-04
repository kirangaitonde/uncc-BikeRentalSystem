/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.ProductDB;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Order Item represents a line from a cart/invoice
 *
 * @author K G
 */
@Entity
public class OrderItem implements Serializable {

    private int orderNumber;
    @Id
    private String productCode;
    @Id
    private int quantity;
    private String startTime;
    private String endTime;

    public OrderItem() {
        orderNumber = 0;
        productCode = "";
        quantity = 0;
        startTime = "";
        endTime = "";
    }

    public OrderItem(String productCode, int quantity, String startTime, String endTime) {
        this.orderNumber = 0;
        this.productCode = productCode;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public double getTotal() {
        double price = ProductDB.getProduct(productCode).getHourlyPrice();
        double discount = ProductDB.getProduct(productCode).getDiscount();
        double discountedPrice = price - (price * (discount / 100));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse(startTime);
            endDate = format.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double duration = endDate.getTime() - startDate.getTime();
        double diffInMinutes = TimeUnit.MILLISECONDS.toMinutes((long) duration);
        //System.out.println(diffInMinutes);
        int hours = this.round(diffInMinutes / 60.0);
        //System.out.println(hours);
        //System.out.println(price * quantity * hours);
        return discountedPrice * quantity * hours;
    }

    public int round(double d) {
        double abs = Math.abs(d);
        int i = (int) abs;
        double result = abs - (double) i;
        if (result < 0.5) {
            return d < 0 ? -i : i;
        } else {
            return d < 0 ? -(i + 1) : i + 1;
        }
    }

    public Product getOrderItemProductCode() {
        return ProductDB.getProduct(productCode);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return ProductDB.getProduct(productCode);
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
