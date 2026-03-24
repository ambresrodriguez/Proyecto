create table usuarios(
    id int(10),
    nombre varchar2(25),
    email varchar2(30),
    password varchar2(30)
);
create table eventos(
    id int(10),
    fecha date,
    titulo varchar2(20),
    ubicacion varchar2(30),
    descripcion varchar2(120)
);
create table galerias(
    id int(10);
    titulo varchar2(20),
    id_evento int(10)
);
create table imagenes(
    id int(10),
    titulo varchar2(20)
    imagen no se,
    id_galeria varchar(10);
);