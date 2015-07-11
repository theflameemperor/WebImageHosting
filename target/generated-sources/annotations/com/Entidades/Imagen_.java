package com.Entidades;

import com.Entidades.Comentario;
import com.Entidades.Etiqueta;
import com.Entidades.Usuario;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T15:19:37")
@StaticMetamodel(Imagen.class)
public class Imagen_ { 

    public static volatile SingularAttribute<Imagen, String> descripcion;
    public static volatile SingularAttribute<Imagen, String> nombreimagen;
    public static volatile SingularAttribute<Imagen, String> direccionimagen;
    public static volatile ListAttribute<Imagen, Etiqueta> etiquetaList;
    public static volatile ListAttribute<Imagen, Comentario> comentarioList;
    public static volatile SingularAttribute<Imagen, BigInteger> cantidadvisitas;
    public static volatile SingularAttribute<Imagen, String> titulo;
    public static volatile SingularAttribute<Imagen, Usuario> usuario;
    public static volatile SingularAttribute<Imagen, Long> idimagen;
    public static volatile SingularAttribute<Imagen, BigInteger> tamano;

}