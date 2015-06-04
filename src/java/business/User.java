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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String firstName;
    private String lastName;
    private String emailID;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String password;
    private String userName;
    private String roleName;

    public User() {
        userID = 0;
        firstName = "";
        lastName = "";
        emailID = "";
        addressLine1 = "";
        addressLine2 = "";
        city = "";
        state = "";
        postCode = "";
        country = "";
        password = "";
        userName = "";
        roleName = "";
    }

    public User(String firstName, String lastName, String email, String add1, String add2, String city, String state, String postCode, String country, String password, String userName, String roleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = email;
        this.addressLine1 = add1;
        this.addressLine2 = add2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.password = password;
        this.userName = userName;
        this.roleName = roleName;
    }

    public User(int userID, String firstName, String lastName, String email, String add1, String add2, String city, String state, String postCode, String country, String password, String userName, String roleName) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = email;
        this.addressLine1 = add1;
        this.addressLine2 = add2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
        this.password = password;
        this.userName = userName;
        this.roleName = roleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String email) {
        this.emailID = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String add1) {
        this.addressLine1 = add1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String add2) {
        this.addressLine2 = add2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
