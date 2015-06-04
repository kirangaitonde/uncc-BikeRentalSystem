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


<div class="PopupPanelCart">
    <fieldset class="log">
        <legend class="log1" > Items selected </legend>
        <h4 id="f1_label">You can update the quantity using updateCart.To remove an item change quantity to zero.</h4>
        <form name="upadteCart" method="post" action="order" >
            <table  id="cartTable">
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
                        <td><input type="text" name="${cartItem.getProduct().getProductCode()}" value="<c:out value="${cartItem.getQuantity()}" />"/></td> 
                        <td><c:out value="${cartItem.getStartTime()}" /></td>
                        <td><c:out value="${cartItem.getEndTime()}" /></td> 
                        <td>$<c:out value="${cartItem.getTotal()}" /></td>
                    </tr>
                </c:forEach>
            </table>  
            <table>
                <tr id ="f1_label">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="hidden" name= "upadteCart" value="upadteCart"/>
                        <input type= "submit" value="Update Cart"/> </td>
                </tr>
            </table>
        </form>
        <form name="checkOut" method="post" action="order" > 
            <table>
                <tr id ="f1_label">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="hidden" name= "checkOut" value="checkOut"/>
                        <input type= "submit" value="Check Out"/> </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>


<jsp:include page="/include/footer.jsp" />