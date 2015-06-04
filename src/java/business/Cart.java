/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author K G
 */
public class Cart implements Serializable {

    private ArrayList<OrderItem> orderItems;

    public Cart() {
        orderItems = new ArrayList<OrderItem>();
    }

    public Cart(ArrayList<OrderItem> items) {
        this.addItems(items);
    }

    public String addItem(Product product, int quantity, String start, String end) {
        int m = 0;
        /*if(orderItems == null){
         System.out.println("reached addItem1");    
         OrderItem oItem = new OrderItem(product,quantity);
         orderItems.add(oItem); 
         return "product added";        
         }*/
        if (orderItems != null) {
            for (OrderItem o : orderItems) {
                //System.out.println("reached addItem2");
                //System.out.println(o.getProduct().getProductCode());
                //System.out.println(product.getProductCode());
                if (o.getProduct().getProductCode().equals(product.getProductCode())) {
                    System.out.println("reached addItem2a");
                    o.setQuantity(o.getQuantity() + 1);
                    m = 1;
                    return "product quantity updated";
                }
            }
        }
        if (m == 0) {
            System.out.println("reached addItem3");
            OrderItem orderItem = new OrderItem(product.getProductCode(), quantity, start, end);
            orderItems.add(orderItem);
        }
        return "product added";
    }

    public String updateItem(Product product, int quantity) {

        if (orderItems != null) {
            for (OrderItem o : orderItems) {
                if (o.getProduct().getProductCode().equals(product.getProductCode())) {
                    System.out.println("reached addItem2a");
                    o.setQuantity(quantity);

                    return "product quantity updated";
                }
            }
        }
        return "product updated";
    }

    public double getSubTotal() {
        double total = 0;
        for (OrderItem o : orderItems) {
            total = total + o.getTotal();
        }
        return total;
    }

    public void addItems(ArrayList<OrderItem> items) {
        for (OrderItem o : items) {
            orderItems.add(o);
        }
    }

    public void removeItem(Product product) {
        for (int i = 0; i < orderItems.size(); i++) {
            if (orderItems.get(i).getProduct().getProductCode().equals(product.getProductCode())) {
                orderItems.remove(i);
                break;
            }
        }
    }

    public ArrayList<OrderItem> getItems() {
        return orderItems;
    }

    public void emptyCart() {
        orderItems.clear();
    }
}
