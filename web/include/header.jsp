<%-- 
    Document   : header
    Created on : Feb 28, 2015, 12:13:15 AM
    Author     : K G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bike Rental System</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
    </head>

    <body>
        <div id="containerlogintop">
            <div class="HorizLinkstop">
                <center>G11 BIKE RENTALS</center>
            </div>
        </div> 
        <div id="searchdiv">
            <center>
                <form class="search" name="formSearch" method="get" action="index.jsp">
                    <input name="q" type="text" id="headerSearch" placeholder=" S E A R C H" />
                    <input type="submit" class="search-button" value="GO" />
                </form>       
        </div> 