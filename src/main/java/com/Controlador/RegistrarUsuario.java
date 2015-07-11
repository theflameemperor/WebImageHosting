/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Controlador;

import com.Entidades.Usuario;
import com.Servicio.BaseDeDatos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DatoSesion.ErrorDePagina;
import com.DatoSesion.SesionUsuario;
/**
 *
 * @author mrmomo
 */
@WebServlet(name = "RegistrarUsuario", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuario extends HttpServlet {

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
        Usuario tmp =  Data.getUsuario(nombre);
        if (tmp == null) {
            if (Data.RegistrarUsuario(nombre,contrasena)) {
                request.getSession().setAttribute("usuario",new SesionUsuario(nombre));
                response.sendRedirect("index.jsp");
            }
            else{
                request.setAttribute("error", new ErrorDePagina("Error Interno","Lab base de datos se nego a registrar el usuario"));
                dispatcher.forward(request, response);
            }
        }
        else{
            request.setAttribute("error", new ErrorDePagina("Ya Existe","Este usuario ya exite no puede crearlo"));
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
