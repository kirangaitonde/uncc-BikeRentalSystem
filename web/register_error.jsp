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

<form class="PopupPanelRegister" name="register" method="post" action="user">
    <fieldset class="log">
        <legend class="log1" > REGISTER </legend>
        <table id ="f1_label">
            <tr>
                <td id="error"> Try again!!</td>
                <td id="error">${error}</td>
            </tr>
            <tr>
                <td>Email ID </td>
                <td><input type="email" name="emailID" /></td>
            </tr>
            <tr>
                <td>Password </td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Confirm Password </td>
                <td><input type="password" name="confPassword" /></td>
            </tr>
            <tr>
                <td>First Name </td>
                <td><input type="text" name="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name </td>
                <td><input type="text" name="lastName" /></td>
            </tr>
            <tr>
                <td>Address Line1 </td>
                <td><input type="text" name="addressLine1" /></td>
            </tr>
            <tr>
                <td>Address Line 2</td>
                <td><input type="text" name="addressLine2" /></td>
            </tr>
            <tr>
                <td>City </td>
                <td><input type="text" name="city" /></td>
            </tr>
            <tr>
                <td>State </td>
                <td><input type="text" name="state" /></td>
            </tr>
            <tr>
                <td>Postal Code </td>
                <td><input type="text" name="postCode" /></td>
            </tr>
            <tr>
                <td>Country </td>
                <td><input type="text" name="country" /></td>
            </tr>
            <br>
            <tr>
                <td> </td>
                <td><input type="hidden" name= "registerUser" value="registerUser"/>
                    <input type= "submit" value="Register"/> </td>
            </tr>
        </table>
    </fieldset>
</form> 


<jsp:include page="/include/footer.jsp" />