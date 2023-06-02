<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.foodexpress.model.dao.UsuarioDAO" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="name" value="${param.name}"/>
        <c:set var="email" value="${param.email}"/>
        <c:set var="password" value="${param.password}"/>
        <c:set var="phone" value="${param.phone}"/>
        <c:choose>
            <c:when test="${param.opcao.toString() == 'comprar'}">
                <c:set var="opcaoEscolhida" value="1"/>
            </c:when>
            <c:when test="${param.opcao.toString() == 'vender'}">
                <c:set var="opcaoEscolhida" value="2"/>
            </c:when>
            <c:otherwise>
                <c:set var="opcaoEscolhida" value=""/>
            </c:otherwise>
        </c:choose>
   



    </body>
</html>
