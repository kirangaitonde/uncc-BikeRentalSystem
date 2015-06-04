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

<form class="PopupPanelPaymentSuccess" name="payment" method="post" action="order">
    <fieldset class="logLogin">
        <legend class="log1" > Payment Success!!</legend>
        <h4 id="f1_label">Selected items have been booked for you. A confirmation mail has been sent to the email id provided.</h4><br>
        <h4 id="f1_label">Thank you for choosing G11 Bike Rentals!</h4>
    </fieldset>
</form> 


<jsp:include page="/include/footer.jsp" />