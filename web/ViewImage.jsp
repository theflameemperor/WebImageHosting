<%--
    Document   : View Image
    Created on : Jul 11, 2015, 9:28:31 AM
    Author     : mrmomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="tags" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <tags:IncludeBootstrap file="true"/>
    </head>
    <body>
        <tags:NotLogged/>
        <div class="cuerpo ">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3 col-md-offset-4">
                        <h2>Aqui va El titulo</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 col-md-offset-4">
                        <img src="./0.jpg" style="width:500px;height:500px;"></img>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5 col-md-offset-4">
                        <h2>Aqui va el bloque de comentario</h2>
                        <div  class="col-md-4 col-md-offset-2">
                            <span>nombre usuariodsfsdfsdfsdf sdfsdf sdf s dfsd fsd f</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
