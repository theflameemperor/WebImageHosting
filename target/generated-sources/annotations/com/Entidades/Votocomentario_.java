package com.Entidades;

import com.Entidades.Comentarios;
import com.Entidades.Usuarios;
import com.Entidades.VotocomentarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-11T17:59:39")
@StaticMetamodel(Votocomentario.class)
public class Votocomentario_ { 

    public static volatile SingularAttribute<Votocomentario, VotocomentarioPK> votocomentarioPK;
    public static volatile SingularAttribute<Votocomentario, Integer> voto;
    public static volatile SingularAttribute<Votocomentario, Usuarios> usuarios;
    public static volatile SingularAttribute<Votocomentario, Comentarios> comentarios;

}