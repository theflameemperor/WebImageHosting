<%--
    Document   : index
    Created on : Jul 7, 2015, 3:08:10 PM
    Author     : mrmomo
--%>
<a href="WEB-INF/tlds/VistaDeLaPagina.tld"></a>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="Vista" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <Vista:IncludeBoostrap/>
        <title>Pagina Principal</title>
    </head>
    <body>
        <%
            //de ejemplo
            String user = (String)request.getSession().getAttribute("user_login");
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
