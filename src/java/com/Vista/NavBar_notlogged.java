/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vista;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author mrmomo
 */
//Barra de Navegacion
public class NavBar_notlogged extends SimpleTagSupport {
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("<nav class=\"navbar navbar-default\">");
            out.println("<div class=\"dropdown\">");
            out.println("<button class=\"btn btn-default navbar-btn\"class=\"dropdown-toggle\" data-toggle=\"dropdown\">Log in</button>");
            out.println("<ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu1\">");
            out.println("<li>");
            out.println("<form class=\"form\">");
            out.println("<div class=\"form-group\">");
            out.println("<label>Nombre : </label><input class=\"form-control\" type=\"text\" name=\"nombre\" title=\"Ponga su Nombre\" pattern=\"[A-Za-z].{0,29}\" placeholder=\"Nombre de su usuario\"required/>");
            out.println("<label>Contrasena : </label><input class=\"form-control\" type=\"text\" name=\"contrasena\" title=\"Ponga su Pass\" pattern=\".{4,30}\" placeholder=\"Su Contrasena\" required/>");
            out.println("</div>");
            out.println("<button class=\"btn btn-default\" type=\"submit\" name=\"button\" value=\"login\">Login</button>");
            out.println("<button class=\"btn btn-default\" type=\"submit\" name=\"button\" value=\"Registrar\">Register</button>");
            out.println("</form>");
            out.println("</li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</nav>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Navbar tag", ex);
        }
    }


}
