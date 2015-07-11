/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servicio;

import com.Entidades.Imagenes;
import com.Entidades.Tipousuarios;
import com.Entidades.Usuarios;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//Entidades de base de datos

public class BaseDeDatos {
    //TODO
    //add name
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HostingDeImagenesPU");
    //Busqueda de datos
    public Usuarios getUsuario(String nombre){
        EntityManager em = emf.createEntityManager();
        Usuarios es = null;
        try {
            em.getTransaction().begin();
            es = (Usuarios) em.createNamedQuery("Usuarios.findByNombreusuario").setParameter("nombreusuario",nombre).getSingleResult();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return es;
    }
    public long getUltimaImagenDelUsuario(String nombre){
        EntityManager em = emf.createEntityManager();
        long indice = 0;
        try {
            em.getTransaction().begin();
            Usuarios temp = (Usuarios) em.createNamedQuery("Usuarios.findByNombreusuario").setParameter("nombreusuario",nombre).getSingleResult();
            indice = temp.getImagenesList().get(temp.getImagenesList().size()-1).getIdimagen();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return indice;
    }
    //Insersion de datos
    public boolean RegistrarUsuario(String nombre,String contrasena){
        EntityManager em = emf.createEntityManager();
        boolean Success = false;
        try {
            em.getTransaction().begin();
            //Fuck you java
            //incorrect
            //Tipousuarios tUsuario = em.find(Tipousuarios.class,2);
            //correct
            //Tipousuarios tUsuario = em.find(Tipousuarios.class,(long)2);
            Tipousuarios tUsuario = em.find(Tipousuarios.class,(long)2);
            System.out.println("tipousuario:" + tUsuario.getTipo());
            Usuarios es = new Usuarios(nombre,contrasena,tUsuario);
            em.persist(es);
            Success=true;
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println("Mensaje de excepetion " + e);
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return Success;
    }
    public boolean InsertarImagen(String direccion,String titulo,String descripcion,String nombreimagen,BigInteger tamano,String nombreusuario){
        EntityManager em = emf.createEntityManager();
        boolean Success = false;
        try {
            em.getTransaction().begin();
            Usuarios User = this.getUsuario(nombreusuario);
            Imagenes imagen  = new Imagenes(direccion,titulo,nombreimagen,tamano,new BigInteger("0"),User,descripcion);
            em.persist(imagen);
            Success=true;
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println("Mensaje de excepetion " + e);
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return Success;
    }
    //Eliminacion de datos
    //Modificacion de datos

}
