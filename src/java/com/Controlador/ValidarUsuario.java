/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Controlador;

import com.DatoSession.SessionUsuario;
import com.Entidades.Usuarios;
import com.Servicio.BaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DatoSession.ErrorDePagina;
/**
 *
 * @author mrmomo
 */
@WebServlet(name = "ValidarUsuario", urlPatterns = {"/ValidarUsuario"})
public class ValidarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getSession().getAttribute("usuario") != null) {
            //send home
        }
        BaseDeDatos Data =  new BaseDeDatos();
        String nombre = request.getParameter("nombre");
        String contrasena = request.getParameter("contrasena");
        RequestDispatcher dispatcher = request.getRequestDispatcher("./errorPage.jsp");
        System.out.println("nombre: " +nombre+" contrasena:" +contrasena);
        if (nombre==null || contrasena == null) {
            //send error page [missing parameters]
            request.setAttribute("error", new ErrorDePagina("Datos Incompletos","falto poner su nombre de usario o contrasena "));
            System.out.println("faltan cosas");
            dispatcher.forward(request, response);
        }
        Usuarios tmp =  Data.getUsuario(nombre);
        if (tmp != null) {
            if (tmp.getNombreusuario().equals(nombre) && tmp.getContrasena().equals(contrasena)) {
                request.getSession().setAttribute("usuario",new SessionUsuario(nombre));
                response.sendRedirect("index.jsp");
            }
            else{
                //send error page [login failed]
                System.out.println("!Datos invalidos");
                request.setAttribute("error", new ErrorDePagina("Error al iniciar ","El de usuario  o la conrasena es invalida"));
                System.out.println("Datos invalidos");

                dispatcher.forward(request, response);
            }
        }
        else{
            //send error page[user does not exist]
            request.setAttribute("error", new ErrorDePagina("No Existe","Este usuario no exite"));
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
