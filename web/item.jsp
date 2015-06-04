<%-- 
    Document   : index
    Created on : Apr 28, 2015, 1:08:24 PM
    Author     : K G
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/include/header.jsp" />

<jsp:include page="/include/user-navigation.jsp" />

<jsp:include page="/include/site-navigation.jsp" />  


<form  class="PopupPanelItem"  method="post" action="order">
    <fieldset class="log">
        <legend class="log1" > Selected ${product.getCategory()} </legend>
        <table id ="f1_label">
            <tr>
                <td ><img id="itemImage" src="${product.getImageURL()}" alt="bike"></td>
            </tr>
            <tr>
                <td ><b><c:out value="${product.getProductName()}" /></b></td>
            </tr>
            <tr>
                <td ><b>$ <c:out value="${product.getHourlyPrice()}" /> per hour.<b></td>
                            </tr>
                            <br>
                            <tr>
                                <td id="error">${dateError}</td>
                            </tr>
                            <tr>
                                <td >Start Data/Time: <input type="datetime-local" name="startTime"></td>
                            </tr>
                            <tr>
                                <td >End Date/Time: &nbsp;<input type="datetime-local" name="endTime"></td>
                            </tr>
                            <br>
                            <br>
                            <tr>
                                <td > <input type= "submit" value="Rent This"/> 
                                    <input type="hidden" name= "rent" value="${product.getProductCode()}"/></td>
                            </tr>
                            <br>
                            <tr>
                                <td >
                                    <button onclick="location.href = 'index.jsp'">Go Back</button></td>
                            </tr>
                            </table>
                            </fieldset>
                            </form>


                            <jsp:include page="/include/footer.jsp" />