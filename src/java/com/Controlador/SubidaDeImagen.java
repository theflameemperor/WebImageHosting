/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Controlador;

import com.DatoSesion.SesionUsuario;
import com.Servicio.BaseDeDatos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
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

        final String pathReymond = "/home/mrmomo/image hosting";
        final String pathEmnanuel = "C:\\Users\\Enmanuel\\Documents\\ImagenesSubidas";
        final String path = pathEmnanuel;
        final String nombreUsuario;
        final Part filePart = request.getPart("file");
        SesionUsuario session =  (SesionUsuario)request.getSession().getAttribute("usuario");
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
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        try {
            String ruta = path+"/"+nombreUsuario+"/" +(idval++)+getExtension(filePart.getSubmittedFileName());
            out = new FileOutputStream(new File(ruta));
            writer.println("<p>"+filePart.getSubmittedFileName()+"</p>");
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            String titulo = request.getParameter("titulo");
            String description = request.getParameter("description");
            String etiquetas = request.getParameter("etiqueta");
            if (Data.InsertarImagen(ruta, titulo, description, filePart.getSubmittedFileName(), new BigInteger(String.valueOf(new File(ruta).length())),nombreUsuario)) {
                 response.sendRedirect("index.jsp");
            }
            else{
                writer.println("<br/> ERROR: " + filePart.getSubmittedFileName());
            }


        }
        catch (Exception fne) {
            writer.println("<br/> ERROR: " + filePart.getSubmittedFileName());

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
        return "."+archivo.replaceAll(".*\\.","");
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
