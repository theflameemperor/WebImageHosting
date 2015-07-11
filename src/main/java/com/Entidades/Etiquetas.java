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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Enmanuel
 */
@Entity
@Table(name = "ETIQUETAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiquetas.findAll", query = "SELECT e FROM Etiquetas e"),
    @NamedQuery(name = "Etiquetas.findByIdetiqueta", query = "SELECT e FROM Etiquetas e WHERE e.idetiqueta = :idetiqueta"),
    @NamedQuery(name = "Etiquetas.findByEtiqueta", query = "SELECT e FROM Etiquetas e WHERE e.etiqueta = :etiqueta")})
public class Etiquetas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDETIQUETA")
    private Long idetiqueta;
    @Size(max = 2147483647)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @JoinTable(name = "ETIQUETAIMAGENES", joinColumns = {
        @JoinColumn(name = "IDETIQUETA", referencedColumnName = "IDETIQUETA")}, inverseJoinColumns = {
        @JoinColumn(name = "IDIMAGEN", referencedColumnName = "IDIMAGEN")})
    @ManyToMany
    private List<Imagenes> imagenesList;

    public Etiquetas() {
    }

    public Etiquetas(Long idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public Long getIdetiqueta() {
        return idetiqueta;
    }

    public void setIdetiqueta(Long idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @XmlTransient
    public List<Imagenes> getImagenesList() {
        return imagenesList;
    }

    public void setImagenesList(List<Imagenes> imagenesList) {
        this.imagenesList = imagenesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetiqueta != null ? idetiqueta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiquetas)) {
            return false;
        }
        Etiquetas other = (Etiquetas) object;
        if ((this.idetiqueta == null && other.idetiqueta != null) || (this.idetiqueta != null && !this.idetiqueta.equals(other.idetiqueta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Controlador.Etiquetas[ idetiqueta=" + idetiqueta + " ]";
    }
    
}
