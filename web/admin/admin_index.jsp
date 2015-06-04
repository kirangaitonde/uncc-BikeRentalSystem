<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@ page import="data.ProductDB" %>
<%@ page import="business.Product" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigationLogin.jsp" />  

<%
    List<Product> prodList = ProductDB.getAllProducts();
    request.setAttribute("prodList", prodList);
%>


<div class="PopupPanelAdmin">
    <fieldset class="log">
        <legend class="log1" > Admin Console </legend>
        <form  name="updatePrice" method="post" action="../admin">
            <table id ="f1_label">
                <tr>
                    <th>Change Price of Bike/Accessory </th>
                    <th></th>
                    <th id="success">${successMsgPrice}</th>
                </tr>
                <tr>
                    <td><select id="selectedProductForPrice" name="selectedProductForPrice" >
                            <option value=" "> </option>
                            <c:forEach var="prod" items="${prodList}">
                                <option value="${prod.getProductCode()}">${prod.getProductName()}</option>
                            </c:forEach>
                        </select> </td>
                    <td><input type="number" step="any" name="productPrice"></td>
                    <td><input type="hidden" name= "updatePrice" value="updatePrice"/>
                        <input type= "submit" value="Update Price"/></td>
                </tr>
            </table>
        </form> 

        <br>
        <br>
        <br>
        <br>

        <form  name="addDiscount" method="post" action="../admin">
            <table id ="f1_label">
                <tr>
                    <th>Add Discount to Bike/Accessory </th>
                    <th></th>
                    <th id="success">${successMsgDiscount}</th>
                </tr>
                <tr>
                    <td><select id="selectedProductForDiscount" name="selectedProductForDiscount" >
                            <option value=" "> </option>
                            <c:forEach var="prod" items="${prodList}">
                                <option value="${prod.getProductCode()}">${prod.getProductName()}</option>
                            </c:forEach>
                        </select> </td>
                    <td><input type="number" step="any" name="discountValue"></td>
                    <td><input type="hidden" name= "addDiscount" value="addDiscount"/>
                        <input type= "submit" value="Add Discount"/></td>
                </tr>
            </table>
        </form>

    </fieldset>
</div>



<jsp:include page="/include/footer.jsp" />