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

<div class="PopupPanelCheckout"> 
    <fieldset class="logLogin">
        <legend class="log1" > Login/Register </legend>
        <table >
            <tr>
                <td id="f1_label"><h4>You need to login or register to continue.</h4>
                </td>
            </tr>
            <tr>
                <td id="f1_label"><button onclick="location.href = 'register.jsp'">Register as New User</button>
                </td>
            </tr>
            <tr>
                <td id="f1_label"><button onclick="location.href = 'customer/order.jsp'">Login as Existing User</button>
                </td>
            </tr>
        </table>
    </fieldset>

    <div>

