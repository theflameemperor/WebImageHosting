/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Enmanuel
 */
public class NavBar_logged extends SimpleTagSupport{
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("<nav class=\"navbar navbar-default navbar-fixed-top\">\n" +
"	<div class=container> \n" +
"       <div class=\"navbar-header\"> \n" +
"			<span class=\"navbar-brand\">Parcial 2. ImageHosting</span> \n" +
"			<div>\n" +
"				<a class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">Subir imágenes</a> \n" +
"			</div>\n" +
"		</div>\n" +
"		<div class=\"collapse navbar-collapse\">\n" +
"		<ul class=\"nav navbar-nav navbar-right\">\n" +
"			<li>\n" +
"				<a href=\"#portfolio\">Inicio</a>\n" +
"			</li>\n" +
"			<li>\n" +
"				<a href=\"#portfolio\">Fotos</a>\n" +
"			</li>\n" +
"			<li>\n" +
"				<a href=\"CerrarSesionUsuario\">Cerrar sesión</a>\n" +
"			</li>\n" +
"		</ul>\n" +
"	</div>\n" +
"	</div>\n" +
"</nav>\n" +
"<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\n" +
"  <div class=\"modal-dialog\">\n" +
"    <!-- Modal content-->\n" +
"    <div class=\"modal-content\">\n" +
"      <div class=\"modal-header\">\n" +
"        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
"        <h4 class=\"modal-title\">Modal Header</h4>\n" +
"      </div>\n" +
"      <div class=\"modal-body\">\n" +
"        <form enctype=\"multipart/form-data\" method=\"post\" action=\"SubidaDeImagen\">\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"Titulo\">Titulo</label>\n" +
"                <input name=\"titulo\" class=\"form-control\" type=\"text\" pattern=\".{1,50}\" required />\n" +
"\n" +
"            </div>\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"Descripcion\">Descripcion </label>\n" +
"                <input name=\"description\" class=\"form-control\" type=\"text\" pattern=\".{1,50}\" required />\n" +
"            </div>\n" +
"\n" +
"            <div class=\"form-group\">\n" +
"                <label for=\"Etiquetas\">Etiquetas </label>\n" +
"                <input name=\"etiqueta\" class=\"form-control\" type=\"text\" pattern=\".{1,50}\" placeholder=\"separado por;\" pattern=\".+;\"/>\n" +
"            </div>\n" +
"\n" +
"            <div class=\"form-group\">\n" +
"                <input id=\"file-0b\" class=\"file\" name=\"file\" type=\"file\" multiple data-preview-file-type=\"any\" data-upload-url=\"#\" data-preview-file-icon=\"\">\n" +
"            </div>\n" +
"            <button type=\"submit\" class=\"btn btn-primary active\">Submit</button>\n"+
"        </form>"+
"      </div>\n" +
"      <div class=\"modal-footer\">\n" +
"        <button  type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n" +
"      </div>\n" +
"    </div>\n" +
"  </div>\n" +
"</div>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Navbar tag", ex);
        }
    }
}