<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>

<%@page import="java.util.List"%>
<%@page import="business.OrderItem"%>
<%@page import="data.OrderItemDB"%>
<%@page import="data.OrdersDB"%>
<%@page import="business.Cart"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="data.UserDB" %>
<%@ page import="business.User" %>
<%@ page import="business.Orders" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigationLogin.jsp" />  

<%

    int num = Integer.parseInt((String) request.getAttribute("orderNumber"));
    Orders o = OrdersDB.getOrderUsingOrderNumber(num);
    session.setAttribute("invoiceOrder", o);
    User u = new User();
    u = UserDB.getUser(o.getUserID());
    request.setAttribute("invoiceUser", u);
    List<OrderItem> invoiceOrderItems = OrderItemDB.getOrderItems(num);
    request.setAttribute("invoiceOrderItems", invoiceOrderItems);
    double subTotal = 0;
    for (OrderItem oi : invoiceOrderItems) {
        subTotal = subTotal + oi.getTotal();
    }
    request.setAttribute("invoiceSubTotal", subTotal);
%>
<div class="PopupPanelInvoice">
    <fieldset class="logLogin">
        <legend class="log1" > Invoice for selected order </legend>
        <h3 id ="f1_label">&nbsp&nbspInvoice</h3>
        <p id ="f1_label">
            &nbsp&nbsp<u>Order Invoice:</u><br>
        &nbsp&nbsp<c:out value="${invoiceUser.getFirstName()}" />&nbsp <c:out value="${invoiceUser.getLastName()}" /> <br>
        &nbsp&nbsp<c:out value="${invoiceUser.getAddressLine1()}" /><br>
        &nbsp&nbsp<c:out value="${invoiceUser.getAddressLine2()}" /><br>
        &nbsp&nbsp<c:out value="${invoiceUser.getCity()}" /><br>
        &nbsp&nbsp<c:out value="${invoiceUser.getPostCode()}" /><br>
        </p>
        <table id="#cartTable">
            <tr id ="f1_label">
                <th>Bike/Accessory</th>
                <th>Price/Hour</th>
                <th>Quantity</th>
                <th>Start Date/Time</th>
                <th>End Date/Time</th>
                <th>Total</th>
            </tr>

            <c:forEach var="orderItem" items="${invoiceOrderItems}"> 
                <tr id ="f1_label">
                    <td><c:out value="${orderItem.getProduct().getProductName()}" /></td>
                    <td><c:out value="${orderItem.getProduct().getHourlyPrice()}" /></td>
                    <td><c:out value="${orderItem.getQuantity()}" /></td> 
                    <td><c:out value="${orderItem.getStartTime()}" /></td>
                    <td><c:out value="${orderItem.getEndTime()}" /></td> 
                    <td>$<c:out value="${orderItem.getTotal()}" /></td>
                </tr>
            </c:forEach> 

            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Subtotal</b></td>
                <td><c:out value="${invoiceSubTotal}" /></td> 
            </tr>
            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Tax</b></td>
                <td><c:out value="${invoiceOrder.getTax(invoiceSubTotal)}" /></td> 
            </tr>

            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Total</b></td>
                <td><c:out value="${invoiceOrder.getTotalCost()}" /></td> 
            </tr>
        </table>
    </fieldset>
</div>
<jsp:include page="/include/footer.jsp" />