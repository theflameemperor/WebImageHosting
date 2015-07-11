/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enmanuel
 */
@Entity
@Table(name = "TIPOUSUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipousuarios.findAll", query = "SELECT t FROM Tipousuarios t"),
    @NamedQuery(name = "Tipousuarios.findByIdtipo", query = "SELECT t FROM Tipousuarios t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tipousuarios.findByTipo", query = "SELECT t FROM Tipousuarios t WHERE t.tipo = :tipo")})
public class Tipousuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPO")
    private Long idtipo;
    @Size(max = 2147483647)
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "tipousuario")
    private List<Usuarios> usuariosList;

    public Tipousuarios() {
    }

    public Tipousuarios(Long idtipo) {
        this.idtipo = idtipo;
    }

    public Long getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Long idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuarios)) {
            return false;
        }
        Tipousuarios other = (Tipousuarios) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Controlador.Tipousuarios[ idtipo=" + idtipo + " ]";
    }
    
}
