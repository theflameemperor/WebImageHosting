/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrmomo
 */
@Entity
@Table(name = "VOTOCOMENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votocomentario.findAll", query = "SELECT v FROM Votocomentario v"),
    @NamedQuery(name = "Votocomentario.findByIdusuario", query = "SELECT v FROM Votocomentario v WHERE v.votocomentarioPK.idusuario = :idusuario"),
    @NamedQuery(name = "Votocomentario.findByIdcomentario", query = "SELECT v FROM Votocomentario v WHERE v.votocomentarioPK.idcomentario = :idcomentario"),
    @NamedQuery(name = "Votocomentario.findByVoto", query = "SELECT v FROM Votocomentario v WHERE v.voto = :voto")})
public class Votocomentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VotocomentarioPK votocomentarioPK;
    @Column(name = "VOTO")
    private Integer voto;
    @JoinColumn(name = "IDCOMENTARIO", referencedColumnName = "IDCOMENTARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Comentarios comentarios;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Votocomentario() {
    }

    public Votocomentario(VotocomentarioPK votocomentarioPK) {
        this.votocomentarioPK = votocomentarioPK;
    }

    public Votocomentario(long idusuario, long idcomentario) {
        this.votocomentarioPK = new VotocomentarioPK(idusuario, idcomentario);
    }

    public VotocomentarioPK getVotocomentarioPK() {
        return votocomentarioPK;
    }

    public void setVotocomentarioPK(VotocomentarioPK votocomentarioPK) {
        this.votocomentarioPK = votocomentarioPK;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(Comentarios comentarios) {
        this.comentarios = comentarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (votocomentarioPK != null ? votocomentarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votocomentario)) {
            return false;
        }
        Votocomentario other = (Votocomentario) object;
        if ((this.votocomentarioPK == null && other.votocomentarioPK != null) || (this.votocomentarioPK != null && !this.votocomentarioPK.equals(other.votocomentarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entidades.Votocomentario[ votocomentarioPK=" + votocomentarioPK + " ]";
    }
    
}
