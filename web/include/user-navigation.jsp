<%-- 
    Document   : user-navigation
    Created on : Feb 28, 2015, 12:13:32 AM
    Author     : K G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div class="HorizLinks">     
    <ul class="container table even">
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Admin">Home</a></li>
        <li class="info"><a href="${pageContext.request.contextPath}/index.jsp" title="About">About</a></li> 
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Bikes">Bikes</a></li>
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Accessories">Bike Accessories</a></li>
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="FAQ">FAQ</a></li>
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Attractions">Attractions</a></li> 
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Maps">Maps</a></li>
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Photos">Photos</a></li>
        <li class="siteNavig"><a  href="${pageContext.request.contextPath}/index.jsp" title="Contact Us">Contact Us</a></li>
        <li class="siteNavig"><a  href="admin/admin_index.jsp" title="Admin">Admin</a></li>
        
    </ul>   
</div>
<marquee behavior="scroll" direction="left">
    <img src="${pageContext.request.contextPath}/images/marq1.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq2.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq3.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq4.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq5.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq6.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq7.jpg" id="image2"/>
    <img src="${pageContext.request.contextPath}/images/marq8.jpg" id="image2"/>
</marquee>



