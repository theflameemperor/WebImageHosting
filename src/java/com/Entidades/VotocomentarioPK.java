/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mrmomo
 */
@Embeddable
public class VotocomentarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private long idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMENTARIO")
    private long idcomentario;

    public VotocomentarioPK() {
    }

    public VotocomentarioPK(long idusuario, long idcomentario) {
        this.idusuario = idusuario;
        this.idcomentario = idcomentario;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public long getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(long idcomentario) {
        this.idcomentario = idcomentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idusuario;
        hash += (int) idcomentario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VotocomentarioPK)) {
            return false;
        }
        VotocomentarioPK other = (VotocomentarioPK) object;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (this.idcomentario != other.idcomentario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entidades.VotocomentarioPK[ idusuario=" + idusuario + ", idcomentario=" + idcomentario + " ]";
    }
    
}
