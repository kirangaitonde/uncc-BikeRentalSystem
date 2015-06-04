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
<%@page import="data.OrdersDB"%>
<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigationLogin.jsp" />  

<%
    User u = new User();
    u = UserDB.getUser(request.getRemoteUser());
    session.setAttribute("loggedUser", u);
    List<Orders> orderList = OrdersDB.getOrders(u.getUserID());
    request.setAttribute("orderList", orderList);
    request.setAttribute("user", u);
%>
<div class="PopupPanelRentList">
    <fieldset class="logLogin">
        <legend class="log1" > Rental History </legend>

        <table id="#cartTable">
            <tr id="f1_label">
                <th>Order Number</th>
                <th>Customer Name</th>
                <th>Order Date</th>
                <th>Total</th>
            </tr>
            <tr id="f1_label">
                <td>------------</td>
                <td>------------</td>
                <td>------------</td>
                <td>------------</td>                
            </tr>
            <c:forEach var="ord" items="${orderList}"> 
                <tr id="f1_label">
                    <<td><a href="../order?orderNumber=${ord.getOrderNumber()}"><c:out value="${ord.getOrderNumber()}" /></a></td>
                    <td><c:out value="${user.getFirstName()}" />&nbsp<c:out value="${user.getLastName()}" /></td>
                    <td><c:out value="${ord.getOrderDate()}" /></td>
                    <td><c:out value="${ord.getTotalCost()}" /></td> 
                </tr>
            </c:forEach>  
        </table>
    </fieldset>
</div>

<jsp:include page="/include/footer.jsp" />