package com.Entidades;

import com.Entidades.Imagen;
import com.Entidades.Usuario;
import com.Entidades.Votocomentario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T15:19:37")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile ListAttribute<Comentario, Votocomentario> votocomentarioList;
    public static volatile SingularAttribute<Comentario, Imagen> idimagen;
    public static volatile SingularAttribute<Comentario, Long> idcomentario;
    public static volatile SingularAttribute<Comentario, String> comentario;
    public static volatile SingularAttribute<Comentario, Usuario> idusuario;

}