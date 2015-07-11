<%--
    Document   : errorPage
    Created on : Jul 9, 2015, 12:49:19 PM
    Author     : mrmomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="Vista" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        <Vista:IncludeBoostrap/>
    </head>
    <body class="alter alert-danger">
        <h1>${requestScope['error'].error}</h1
        </h2>${requestScope['error'].reason}</h2>
    </body>
</html>
