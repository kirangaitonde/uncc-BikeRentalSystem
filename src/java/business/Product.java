/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author K G
 */
@Entity
public class Product implements Serializable {

    @Id
    private String productCode;
    private String productName;
    private String productCategory;
    private String description;
    private double hourlyPrice;
    private String imageUrl;
    private double discount;

    public Product() {
        productCode = "";
        productName = "";
        productCategory = "";
        description = null;
        hourlyPrice = 0;
        imageUrl = null;
        discount = 0.0;
    }

    public Product(String productCode, String productName, String productCategory, String description, double hourlyPrice, String imageUrl) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.description = description;
        this.hourlyPrice = hourlyPrice;
        this.imageUrl = imageUrl;
    }

    public Product(String productCode, String productName, String productCategory, String description, double hourlyPrice, String imageUrl, double discount) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.description = description;
        this.hourlyPrice = hourlyPrice;
        this.imageUrl = imageUrl;
        this.discount = discount;
    }

    public String getImageURL() {
        return "images/" + productCode + ".jpg";
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return productCategory;
    }

    public void setCategory(String category) {
        this.productCategory = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }

    public void setHourlyPrice(double price) {
        this.hourlyPrice = hourlyPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double price) {
        this.discount = discount;
    }

}
