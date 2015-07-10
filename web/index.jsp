<%--
    Document   : index
    Created on : Jul 7, 2015, 3:08:10 PM
    Author     : mrmomo
--%>
<a href="WEB-INF/tlds/VistaDeLaPagina.tld"></a>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="Vista" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<%@page import="com.DatoSession.SessionUsuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <Vista:IncludeBoostrap/>
        <title>Pagina Principal</title>
    </head>
    <body>
        <%
            SessionUsuario user = (SessionUsuario)request.getSession().getAttribute("usuario");
            if (user == null) {
                %>
                    <Vista:NotLogged/>
                <%
            }
            else{
                %>
                    <Vista:Logged/>
                <%
            }
        %>



    </body>
</html>
