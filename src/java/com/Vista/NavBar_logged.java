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
public class NavBar_logged extends SimpleTagSupport {
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
            out.println("<button style=\"border:none;background:none;\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><img with=\"32\" height=\"32\"src=\"img/option.png\" alt=\"\"/> </button>");
            out.println("<ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu1\">");
            out.println("<li><a role=\"button\" id=\"button_userprofile\">User Profile</a></li>");
            out.println("<li><a role=\"button\" id=\"button_logout\">logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</nav>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Navbar tag", ex);
        }
    }
}
