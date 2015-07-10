create table tipoUsuarios(
    idTipo identity primary key,
    tipo varchar(50)
);
create table usuarios(
    idUsuario identity primary key,
    nombreUsuario varchar(30) unique,
    contrasena varchar(30),
    tipoUsuario bigint references tipoUsuarios(idTipo)
);
create table imagenes(
    idImagen identity primary key,
    direccionImagen varchar(300),
    titulo varchar(50),
    descripcion varchar(3000),
    nombreImagen varchar(250),
    tamano bigint,
    cantidadVisitas bigint,
    usuario bigint references usuarios(idUsuario),
);
create table etiquetas(
    idEtiqueta identity primary key,
    etiqueta varchar(30)
);
create table etiquetaImagenes(
    idEtiqueta bigint references etiquetas(idEtiqueta),
    idImagen bigint references imagenes(idImagen),
    primary key(idEtiqueta,idImagen)
);
create table comentarios (
    idComentario identity primary key,
    idUsuario bigint references usuarios(idUsuario),
    idImagen bigint references imagenes(idImagen),
    comentario varchar(1000),
);
create table votoComentario(
    idUsuario bigint references usuarios(idUsuario),
    idComentario bigint references comentarios(idComentario),
    voto int,
    primary key(idUsuario,idComentario)
);
-- insertar datos iniciales
-- tipos posibles
insert into tipoUsuarios (tipo) values('Admin');
insert into tipoUsuarios (tipo) values('Usuario Comun');
insert into tipoUsuarios (tipo) values('DBA');
-- el Admin
insert into usuarios (nombreUsuario,contrasena,tipoUsuario) values ('admin','1234',1);
insert into usuarios (nombreUsuario,contrasena,tipoUsuario) values ('anon','',2);
-- sql para probar
select
    usuarios.idUsuario,
    usuarios.nombreUsuario,
    usuarios.contrasena,
    tipoUsuarios.tipo
from
    usuarios,
    tipoUsuarios
where
    usuarios.tipoUsuario = tipoUsuarios.idTipo;

-- borra todo
drop all objects
