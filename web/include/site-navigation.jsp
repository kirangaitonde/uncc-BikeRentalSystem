<%-- 
    Document   : site-navigation
    Created on : Feb 28, 2015, 12:13:46 AM
    Author     : K G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
    <c:when test="${pageContext.request.getRemoteUser()!= null}">
        <form method="post" action="login">
            <fieldset class="log">
                <legend class="log1" > Welcome Back!! </legend>
                <table >
                    <tr>
                        <td id="f1_label">Logged user: </td>
                    </tr>
                    <tr>
                        <td id="f1_label">${pageContext.request.getRemoteUser()}</td>
                    </tr>
                    <tr>
                        <td id="f1_label">How are you doing today??</td>
                    </tr>
                    <br>
                    <tr>
                        <td id="f1_label"> <a href="${pageContext.request.contextPath}/customer/rentalList.jsp">Click here to check you rental history</a></td>
                    </tr>
                    <br>
                    <tr><td>
                            <input type="hidden" name= "logout" value="logout"/>
                            <input type= "submit" value="Logout" id="loginButton"/></td>
                    </tr>
                </table>
            </fieldset>
        </form> 
    </c:when>
    <c:otherwise>
        <form method="post" action="login">
            <fieldset class="log">
                <legend class="log1" > LOGIN </legend>
                <table >
                    <tr>
                        <td ></td><td id="error">${error}
                        </td>
                    </tr>
                    <tr>
                        <td id="f1_label">User Name :</td><td ><input type="text" name="username" value="" id ="login" />
                        </td>
                    </tr>
                    <tr>
                        <td id="f1_label">Password  :</td><td ><input type="password" name="password" id ="login"  />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" name= "loginMain" value="loginMain"/>
                            <input type= "submit" value="Login" id="loginButton"/>
                        </td>
                        <td><a href="register_main.jsp">Sign Up?</a></td>
                    </tr>
                </table>
            </fieldset>
        </form> 
    </c:otherwise>
</c:choose>



<br>   
<form  method="post" action="">
    <fieldset class="log">
        <legend class="log1"> Weather Forecast </legend>
        <a href="http://www.accuweather.com/en/us/charlotte-nc/28202/weather-forecast/349818" class="aw-widget-legal">

        </a><div id="awcc1426521081394" class="aw-widget-current"  data-locationkey="349818" data-unit="f" data-language="en-us" data-useip="false" data-uid="awcc1426521081394"></div><script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>

    </fieldset>
</form> 
<br>


<form  method="post" action="">
    <fieldset class="log">
        <legend class="log1"> Videos </legend>
        <object id="video" data="http://www.youtube.com/v/-SheFO9_YD4">
        </object>
    </fieldset>
</form> 