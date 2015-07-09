/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
 * @author mrmomo
 */
@Entity
@Table(name = "IMAGENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i"),
    @NamedQuery(name = "Imagenes.findByIdimagen", query = "SELECT i FROM Imagenes i WHERE i.idimagen = :idimagen"),
    @NamedQuery(name = "Imagenes.findByDireccionimagen", query = "SELECT i FROM Imagenes i WHERE i.direccionimagen = :direccionimagen"),
    @NamedQuery(name = "Imagenes.findByTitulo", query = "SELECT i FROM Imagenes i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "Imagenes.findByDescripcion", query = "SELECT i FROM Imagenes i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Imagenes.findByNombreimagen", query = "SELECT i FROM Imagenes i WHERE i.nombreimagen = :nombreimagen"),
    @NamedQuery(name = "Imagenes.findByTamano", query = "SELECT i FROM Imagenes i WHERE i.tamano = :tamano"),
    @NamedQuery(name = "Imagenes.findByCantidadvisitas", query = "SELECT i FROM Imagenes i WHERE i.cantidadvisitas = :cantidadvisitas")})
public class Imagenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDIMAGEN")
    private Long idimagen;
    @Size(max = 300)
    @Column(name = "DIRECCIONIMAGEN")
    private String direccionimagen;
    @Size(max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 3000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 250)
    @Column(name = "NOMBREIMAGEN")
    private String nombreimagen;
    @Column(name = "TAMANO")
    private BigInteger tamano;
    @Column(name = "CANTIDADVISITAS")
    private BigInteger cantidadvisitas;
    @ManyToMany(mappedBy = "imagenesList")
    private List<Etiquetas> etiquetasList;
    @OneToMany(mappedBy = "idimagen")
    private List<Comentarios> comentariosList;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuarios usuario;

    public Imagenes() {
    }

    public Imagenes(Long idimagen) {
        this.idimagen = idimagen;
    }

    public Long getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Long idimagen) {
        this.idimagen = idimagen;
    }

    public String getDireccionimagen() {
        return direccionimagen;
    }

    public void setDireccionimagen(String direccionimagen) {
        this.direccionimagen = direccionimagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreimagen() {
        return nombreimagen;
    }

    public void setNombreimagen(String nombreimagen) {
        this.nombreimagen = nombreimagen;
    }

    public BigInteger getTamano() {
        return tamano;
    }

    public void setTamano(BigInteger tamano) {
        this.tamano = tamano;
    }

    public BigInteger getCantidadvisitas() {
        return cantidadvisitas;
    }

    public void setCantidadvisitas(BigInteger cantidadvisitas) {
        this.cantidadvisitas = cantidadvisitas;
    }

    @XmlTransient
    public List<Etiquetas> getEtiquetasList() {
        return etiquetasList;
    }

    public void setEtiquetasList(List<Etiquetas> etiquetasList) {
        this.etiquetasList = etiquetasList;
    }

    @XmlTransient
    public List<Comentarios> getComentariosList() {
        return comentariosList;
    }

    public void setComentariosList(List<Comentarios> comentariosList) {
        this.comentariosList = comentariosList;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimagen != null ? idimagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.idimagen == null && other.idimagen != null) || (this.idimagen != null && !this.idimagen.equals(other.idimagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entidades.Imagenes[ idimagen=" + idimagen + " ]";
    }
    
}
