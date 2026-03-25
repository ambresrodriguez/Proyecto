create table usuarios(
    id_usua int,
    nombre varchar2(25),
    email varchar2(30)UNIQUE,
    password varchar2(30),
    constraint pk_ususarios primary key(id_usua)
);
create table eventos(
    id_even int,
    fecha date,
    titulo varchar2(20),
    ubicacion varchar2(30),
    descripcion varchar2(120),
    constraint pk_eventos primary key(id_even)
);
create table galerias(
    id_gal int,
    titulo varchar2(20),
    id_evento int,
    constraint pk_galerias primary key(id_gal),
    constraint fk_galerias foreign key(id_evento) references eventos(id_even)
);
create table imagenes(
    id_img int,
    titulo varchar2(20),
    imagen number(8),
    id_galeria int,
    constraint pk_imagenes primary key(id_img),
    constraint fk_img_galerias foreign key(id_galeria) references galerias(id_gal)
);
create table favoritos(
    id_usuario int,
    id_evento int,
    constraint pk_favoritos primary key(id_usuario, id_evento),
    constraint fk_favoritos_us foreign key(id_usuario) references usuarios(id_usua),
    constraint fk_favoritos_ev foreign key(id_evento) references eventos(id_even)
);

insert into usuarios values(1,'usuario1','usuario1@gmail.com','usuario1');
insert into usuarios values(2,'usuario2','usuario2@gmail.com','usuario2');
insert into usuarios values(3,'usuario3','usuario3@gmail.com','usuario3');
insert into usuarios values(4,'usuario4','usuario4@gmail.com','usuario4');

insert into eventos values(1,'15-06-2026','constelaciones','gijón','Una obra de teatro contemporánea que explora la relacion entre una fìsica cuántica y un apicultor');
insert into eventos values(2,'05-06-2026','mujeres en la musica','gijón','Exposicion que reúne imágenes y materiales de artistas como Rocio Jurado o Aitana');
insert into eventos values(3,'02-10-2026','the silence','gijón','Para su obra autoficticoa el dramaturgo y director Flak Richter se centra en su propia historia familiar');
insert into eventos values(4,'06-04-2026','fiesta del bollo','avilés','celebración primaveral con desfiles, comida en la calle y ambiente festivo que cierra la Semana Santa.');
insert into eventos values(5,'24-03-2026','mamma mia','teatro jovellanos, gijón','comedia romántica con canciones de ABBA sobre una boda y un misterio familiar.');
insert into eventos values(6,'01-01-2026','partido oviedo-español','estadio municipal carlos tartiere, oviedo','un partido de liga entre el oviedo y el español');
insert into eventos values(7,'12-01-2026','espectaculo de drones','playa de san lorenzo, gijon','Un evento que llenará nuestros días de asombro y emoción. Durante estos días inolvidables, nuestro cielo se convertirá en el escenario de un espectáculo impresionante, con actividades para toda la familia.');
insert into eventos values(8,'24-01-2026','monoloco fest','aviles','Un festival de musica urbana que se celebra en diferentes ciudades de españa');
insert into eventos values(9,'25-06-2026','exposicion silvia cruz','aviles','Nueva y originales canciones para compartir, con sonidos familiares y nuevos horizontes');

insert into galerias values(1,'',1);
insert into galerias values(2,'',2);
insert into galerias values(3,'',3);
insert into galerias values(4,'',4);
insert into galerias values(5,'',5);



create view galerias_antiguas as
select galerias.id, galerias.titulo
from galerias
join eventos on id_eventos = id_gal
where fecha < ('28-02-2026');

create view evento_favorito as
select eventos.titulos
from eventos
join favoritos on id_even = id_eventos
where id_usuario = 1;

create view devolver_imagenes as
select *
from imagenes 
join galerias on id_galeria = id
join eventos on id_evento = id
where fecha = ('12-01-2026');

create view eventos_favoritos as
select *
from eventos
join favoritos on id = id_evento
where id_usuario = 2
and fecha > ('28-02-2026');





















