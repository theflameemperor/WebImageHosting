/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servicio;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//Entidades de base de datos
import com.Entidades.Usuarios;
import com.Entidades.Tipousuarios;

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
            System.out.println("hello: "+es.getNombreusuario());
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
    //Insersion de datos
    public boolean RegistrarUsuario(String nombre,String contrasena){
        EntityManager em = emf.createEntityManager();
        boolean Success = false;
        try {
            em.getTransaction().begin();
            Tipousuarios tUsuario = em.find(Tipousuarios.class,2);
            System.out.println("tipousuario:" + tUsuario.getTipo());
            Usuarios es = new Usuarios(nombre,contrasena,tUsuario);
            em.persist(es);
            Success=true;
            em.flush();
            em.getTransaction().commit();
        }
        catch (Exception e) {
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
