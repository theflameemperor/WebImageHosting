/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Controlador;

import com.DatoSession.ErrorDePagina;
import com.DatoSession.SessionUsuario;
import com.Servicio.BaseDeDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mrmomo
 */
@WebServlet(name = "SubidaDeImagen", urlPatterns = {"/SubidaDeImagen"})
@MultipartConfig
public class SubidaDeImagen extends HttpServlet {

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
        BaseDeDatos Data =  new BaseDeDatos();
        RequestDispatcher dispatcher = request.getRequestDispatcher("./errorPage.jsp");
        // Create path components to save the file
        final String path = "/home/mrmomo/image hosting/";
        final String nombreUsuario;
        final Part filePart = request.getPart("file");
        SessionUsuario session =  (SessionUsuario)request.getSession().getAttribute("usuario");
        if (session == null) {
            nombreUsuario = "anon";
        }
        else{
            nombreUsuario = session.getNombre();
        }
        long idval = Data.getUltimaImagenDelUsuario(nombreUsuario);

        File SaveDir = new File(path + "/"+nombreUsuario);
        if (!SaveDir.exists()) {
            SaveDir.mkdir();
        }
        if (idval == -1) {
            request.setAttribute("error", new ErrorDePagina("error interno","id de imagen no se puede"+SaveDir.getAbsolutePath()+"/" +idval+getExtension(filePart.getSubmittedFileName())));
            dispatcher.forward(request, response);
        }
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(SaveDir.getAbsolutePath()+"/" +idval+getExtension(filePart.getSubmittedFileName())));
            writer.println("<p>1</p>");
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

        }
        catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are  trying to upload a file to a protected or nonexisten location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

        }
        finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
        //response.sendRedirect("index.jsp");
    }
    protected String getExtension(String archivo){
        return "*"+archivo.replaceAll(".*\\.","");
    };
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
