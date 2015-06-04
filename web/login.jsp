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

<form class="PopupPanelLogin" name="login" method="post" action="j_security_check">
    <fieldset class="logLogin">
        <legend class="log1" > LOGIN </legend>
        <table >
            <tr>
                <td id="f1_label">User Name :</td><td ><input type="text" name="j_username" id ="login" />
                </td>
            </tr>
            <tr>
                <td id="f1_label">Password  :</td><td ><input type="password" name="j_password" id ="login"  />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name= "login" value="login"/>
                    <input type= "submit" value="Login"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form> 


<jsp:include page="/include/footer.jsp" />