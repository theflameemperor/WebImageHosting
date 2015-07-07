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
public class IncludeBoostrap extends SimpleTagSupport {
    boolean file= false;
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            out.println("<script src=\"js/jquery-2.1.4.js\" type=\"text/javascript\"></script>");
            out.println("<script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            if (file) {
                out.println("<script src=\"js/fileinput.min.js\" type=\"text/javascript\"></script>");
                out.println("<link href=\"css/fileinput.min.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Navbar tag", ex);
        }
    }
    public void setFile(boolean file){
        this.file = file;
    }

}