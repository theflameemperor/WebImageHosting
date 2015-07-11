package com.Entidades;

import com.Entidades.Comentario;
import com.Entidades.Imagen;
import com.Entidades.Tipousuario;
import com.Entidades.Votocomentario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T15:19:37")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombreusuario;
    public static volatile SingularAttribute<Usuario, Tipousuario> tipousuario;
    public static volatile ListAttribute<Usuario, Imagen> imagenList;
    public static volatile ListAttribute<Usuario, Comentario> comentarioList;
    public static volatile ListAttribute<Usuario, Votocomentario> votocomentarioList;
    public static volatile SingularAttribute<Usuario, String> contrasena;
    public static volatile SingularAttribute<Usuario, Long> idusuario;

}