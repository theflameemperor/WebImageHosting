package com.Entidades;

import com.Entidades.Comentario;
import com.Entidades.Usuario;
import com.Entidades.VotocomentarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T15:19:37")
@StaticMetamodel(Votocomentario.class)
public class Votocomentario_ { 

    public static volatile SingularAttribute<Votocomentario, VotocomentarioPK> votocomentarioPK;
    public static volatile SingularAttribute<Votocomentario, Integer> voto;
    public static volatile SingularAttribute<Votocomentario, Usuario> usuario;
    public static volatile SingularAttribute<Votocomentario, Comentario> comentario;

}