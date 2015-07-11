<%-- 
    Document   : vistaImagen
    Created on : Jul 10, 2015, 6:11:09 PM
    Author     : Enmanuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="tags" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <tags:IncludeBootstrap file="true"/>
</head>

<body>
    <c:if test="${usuario != null}">
        <tags:Logged/>
    </c:if>
    <c:if test="${usuario == null}">
        <tags:NotLogged/>
    </c:if>
    <div class="cuerpo">
        <div style="position: fixed;background:black;margin: auto;">
            <h1>Titulo imagen</h1>
            <a href="#">
                <img class="img-responsive" src="http://placehold.it/400x300" alt="">
            </a>
        </div>
    </div>
</body>
</html>
