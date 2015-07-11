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
 * @author Enmanuel
 */
@Entity
@Table(name = "IMAGENES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i"),
    @NamedQuery(name = "Imagen.findByIdimagen", query = "SELECT i FROM Imagen i WHERE i.idimagen = :idimagen"),
    @NamedQuery(name = "Imagen.findByCantidadvisitas", query = "SELECT i FROM Imagen i WHERE i.cantidadvisitas = :cantidadvisitas"),
    @NamedQuery(name = "Imagen.findByDescripcion", query = "SELECT i FROM Imagen i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Imagen.findByDireccionimagen", query = "SELECT i FROM Imagen i WHERE i.direccionimagen = :direccionimagen"),
    @NamedQuery(name = "Imagen.findByNombreimagen", query = "SELECT i FROM Imagen i WHERE i.nombreimagen = :nombreimagen"),
    @NamedQuery(name = "Imagen.findByTamano", query = "SELECT i FROM Imagen i WHERE i.tamano = :tamano"),
    @NamedQuery(name = "Imagen.findByTitulo", query = "SELECT i FROM Imagen i WHERE i.titulo = :titulo")})
public class Imagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDIMAGEN")
    private Long idimagen;
    @Column(name = "CANTIDADVISITAS")
    private BigInteger cantidadvisitas;
    @Size(max = 2147483647)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "DIRECCIONIMAGEN")
    private String direccionimagen;
    @Size(max = 2147483647)
    @Column(name = "NOMBREIMAGEN")
    private String nombreimagen;
    @Column(name = "TAMANO")
    private BigInteger tamano;
    @Size(max = 2147483647)
    @Column(name = "TITULO")
    private String titulo;
    @ManyToMany(mappedBy = "imagenList")
    private List<Etiqueta> etiquetaList;
    @OneToMany(mappedBy = "idimagen")
    private List<Comentario> comentarioList;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario usuario;

    public Imagen() {
    }

    public Imagen(Long idimagen) {
        this.idimagen = idimagen;
    }
    public Imagen(String direccionimagen,String titulo,String nombreimagen,BigInteger tamano,BigInteger cantidadvisitas,Usuario usuario,String descripcion){
        this.direccionimagen=direccionimagen;
        this.titulo = titulo;
        this.nombreimagen=nombreimagen;
        this.tamano = tamano;
        this.cantidadvisitas =cantidadvisitas;
        this.usuario = usuario;
        this.descripcion =descripcion;
    }

    public Long getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(Long idimagen) {
        this.idimagen = idimagen;
    }

    public BigInteger getCantidadvisitas() {
        return cantidadvisitas;
    }

    public void setCantidadvisitas(BigInteger cantidadvisitas) {
        this.cantidadvisitas = cantidadvisitas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccionimagen() {
        return direccionimagen;
    }

    public void setDireccionimagen(String direccionimagen) {
        this.direccionimagen = direccionimagen;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public List<Etiqueta> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<Etiqueta> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
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
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.idimagen == null && other.idimagen != null) || (this.idimagen != null && !this.idimagen.equals(other.idimagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entidades.Imagen[ idimagen=" + idimagen + " ]";
    }
    
}
