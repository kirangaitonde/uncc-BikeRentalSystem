<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigationLogin.jsp" />  

<form class="PopupPanelPayment" name="payment" method="post" action="../order">
    <fieldset class="logLogin">
        <legend class="log1" > Payment </legend>
        <table id ="f1_label">
            <tr>
                <td>Credit Card Type </td>
                <td><select id="cardType" name="cardType" >            
                        <option value="visa" >VISA</option>
                        <option value="masterCard" >Master Card</option>
                        <option value="amex">AMEX</option>
                    </select></td>
            </tr>
            <tr>
                <td>Card Number </td>
                <td><input type="text" name="cardNumber" /></td>
            </tr>
            <tr>
                <td>Expiration Date</td>
                <td><input type="month" name="expMonth" /></td>
            </tr>
            <tr>
                <td>CVV(3-digit) </td>
                <td><input type="text" name="cvv" /></td>
            </tr>
        </table>
        <h5 id="f1_label">You will be charged a total of :<c:out value="${currentOrder.getTotal(theShoppingCart.getSubTotal())}" /></h5>
        <table id = "registerTable">
            <tr>
                <td> </td>
                <td><input type="hidden" name= "confPayment" value="confPayment"/>
                    <input type= "submit" value="Confirm Payment"/> </td>
            </tr>
        </table>
    </fieldset>
</form> 


<jsp:include page="/include/footer.jsp" />