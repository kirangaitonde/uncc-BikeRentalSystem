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


<div class="PopupPanelRegisterSuccess">   
    <fieldset class="logLogin">
        <legend class="log1" > Registration Success!!</legend>
        <h4 id="f1_label">Your details have been saved in the system!!</h4><br>
        <h4 id="f1_label"><button onclick="location.href = 'index.jsp'">Go to Home page</button></h4>
    </fieldset>
    <div>


        <jsp:include page="/include/footer.jsp" />