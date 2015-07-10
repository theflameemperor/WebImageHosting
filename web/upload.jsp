<%--
    Document   : upload
    Created on : Jul 7, 2015, 7:35:21 PM
    Author     : mrmomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="Vista" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<%@page import="com.DatoSession.SessionUsuario"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <Vista:IncludeBoostrap file="true"/>
    </head>
    <body>
        <%
            //de ejemplo
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-1">
                    <p></p>
                </div>

                <div class="col-sm-6">
                    <form enctype="multipart/form-data" action="SubidaDeImagen" method="post">
                        <div class="form-group">
                            <label for="Titulo">Titulo</label>
                            <input class="form-control" type="text" pattern=".{1,50}" required />

                        </div>
                        <div class="form-group">
                            <label for="Descripcion">Descripcion </label>
                            <input class="form-control" type="text" pattern=".{1,50}" required />
                        </div>

                        <div class="form-group">
                            <label for="Etiquetas">Etiquetas </label>
                            <input class="form-control" type="text" pattern=".{1,50}" placeholder="separado por;" pattern=".+;" required />
                        </div>

                        <div class="form-group" height="500">
                            <input id="file-0b" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="#" data-preview-file-icon="">
                        </div>
                        <button class="btn btn-primary primary" type="submit">Submit</button>
                    </form>
                </div>

                <div class="col-sm-5">
                    <!--posible side bar-->
                </div>
            </div>
        </div>
    </body>
</html>
