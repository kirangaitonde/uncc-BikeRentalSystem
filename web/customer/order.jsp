<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>

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
    User u = new User();
    u = UserDB.getUser(request.getRemoteUser());
    session.setAttribute("loggedUser", u);
    Cart cart = (Cart) session.getAttribute("theShoppingCart");
    request.setAttribute("cartList", cart.getItems());
    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    Orders order = new Orders(date, u.getUserID(), cart.getSubTotal(), false);
    session.setAttribute("currentOrder", order);
%>
<div class="PopupPanelOrder">
    <fieldset class="logLogin">
        <legend class="log1" > Your order </legend>
        <h3 id ="f1_label">&nbsp&nbspInvoice</h3>
        <p id ="f1_label">&nbsp&nbspDate:<c:out value="${order.getDate()}" /><br>
            &nbsp&nbsp<u>Order details:</u><br>
        &nbsp&nbsp<c:out value="${loggedUser.getFirstName()}" />&nbsp<c:out value="${loggedUser.getLastName()}" /> <br>
        &nbsp&nbsp<c:out value="${loggedUser.getAddressLine1()}" /><br>
        &nbsp&nbsp<c:out value="${loggedUser.getAddressLine2()}" /><br>
        &nbsp&nbsp<c:out value="${loggedUser.getCity()}" /><br>
        &nbsp&nbsp<c:out value="${loggedUser.getPostCode()}" /><br>
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

            <c:forEach var="cartItem" items="${cartList}"> 
                <tr id ="f1_label">
                    <td><c:out value="${cartItem.getProduct().getProductName()}" /></td>
                    <td><c:out value="${cartItem.getProduct().getHourlyPrice()}" /></td>
                    <td><c:out value="${cartItem.getQuantity()}" /></td> 
                    <td><c:out value="${cartItem.getStartTime()}" /></td>
                    <td><c:out value="${cartItem.getEndTime()}" /></td> 
                    <td>$<c:out value="${cartItem.getTotal()}" /></td>
                </tr>
            </c:forEach> 

            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Subtotal</b></td>
                <td><c:out value="${theShoppingCart.getSubTotal()}" /></td> 
            </tr>
            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Tax</b></td>
                <td><c:out value="${currentOrder.getTax(theShoppingCart.getSubTotal())}" /></td> 
            </tr>

            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td><b>Total</b></td>
                <td><c:out value="${currentOrder.getTotal(theShoppingCart.getSubTotal())}" /></td> 
            </tr>

            <tr id ="f1_label">
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td></td>
                <td><button onclick="location.href = 'cart.jsp'">Back To Cart</button></td>                                
            </tr>

            <tr id ="f1_label" >
                <td></td>                
                <td></td>
                <td></td>                
                <td></td>  
                <td></td> 
                <td><button onclick="location.href = '${pageContext.request.contextPath}/customer/payment.jsp'">Pay</button></td>               
            </tr>
        </table>
    </fieldset>
</div>
<jsp:include page="/include/footer.jsp" />