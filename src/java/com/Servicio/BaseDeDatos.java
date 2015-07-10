/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Servicio;

import com.Entidades.Usuarios;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    public  BaseDeDatos(){}
    //Insersion de datos
    //Eliminacion de datos
    //Modificacion de datos

}
