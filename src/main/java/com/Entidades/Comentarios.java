/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COMENTARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
    @NamedQuery(name = "Comentarios.findByIdcomentario", query = "SELECT c FROM Comentarios c WHERE c.idcomentario = :idcomentario"),
    @NamedQuery(name = "Comentarios.findByComentario", query = "SELECT c FROM Comentarios c WHERE c.comentario = :comentario")})
public class Comentarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMENTARIO")
    private Long idcomentario;
    @Size(max = 2147483647)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "IDIMAGEN", referencedColumnName = "IDIMAGEN")
    @ManyToOne
    private Imagenes idimagen;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuarios idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comentarios")
    private List<Votocomentario> votocomentarioList;

    public Comentarios() {
    }

    public Comentarios(Long idcomentario) {
        this.idcomentario = idcomentario;
    }

    public Long getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(Long idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Imagenes getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Imagenes idimagen) {
        this.idimagen = idimagen;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Votocomentario> getVotocomentarioList() {
        return votocomentarioList;
    }

    public void setVotocomentarioList(List<Votocomentario> votocomentarioList) {
        this.votocomentarioList = votocomentarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomentario != null ? idcomentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.idcomentario == null && other.idcomentario != null) || (this.idcomentario != null && !this.idcomentario.equals(other.idcomentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Controlador.Comentarios[ idcomentario=" + idcomentario + " ]";
    }
    
}
