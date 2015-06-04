<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>
<%@ page import="data.ProductDB" %>
<%@ page import="business.Product" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigation.jsp" />  
<%
    List<Product> productListBike = ProductDB.getProducts("bike");
    List<Product> productListAccessory = ProductDB.getProducts("accessory");
    request.setAttribute("productListBike", productListBike);
    request.setAttribute("productListAccessory", productListAccessory);
%>

<form  class="PopupPanel"  method="get" action="catalog">
    <table class="log">
        <tr>
            <c:forEach var="product" items="${productListBike}"> 
                <td><img src="${product.getImageURL()}" alt="bike" id = "image" /></td>

            </c:forEach>
        </tr>    
        <tr>
            <c:forEach var="product" items="${productListBike}"> 
                <td>
                    <a href="catalog?productCode=${product.getProductCode()}">${product.getProductName()}</a>
                </td> 
            </c:forEach>
        </tr> 
        <tr>
            <c:forEach var="product" items="${productListAccessory}"> 
                <td><img src="${product.getImageURL()}" alt="bike" id = "image" /></td>

            </c:forEach>
        </tr>    
        <tr>
            <c:forEach var="product" items="${productListAccessory}"> 
                <td>
                    <a href="catalog?productCode=${product.getProductCode()}">${product.getProductName()}</a>
                </td> 
            </c:forEach>
        </tr> 
    </table>  
</form>


<jsp:include page="/include/footer.jsp" />