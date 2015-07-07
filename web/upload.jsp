<%--
    Document   : upload
    Created on : Jul 7, 2015, 7:35:21 PM
    Author     : mrmomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="Vista" uri="WEB-INF/tlds/VistaDeLaPagina.tld"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <Vista:IncludeBoostrap file="true"/>
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
        <form enctype="multipart/form-data">
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
        </form>

    </body>
</html>
