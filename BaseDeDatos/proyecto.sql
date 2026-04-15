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
    titulo varchar2(35),
    ubicacion varchar2(50),
    descripcion varchar2(240),
    constraint pk_eventos primary key(id_even)
);
create table galerias(
    id_gal int,
    titulo varchar2(35),
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
insert into eventos values(6,'01-01-2026','oviedo-español','estadio municipal carlos tartiere, oviedo','un partido de liga entre el oviedo y el español');
insert into eventos values(7,'12-01-2026','espectaculo drones','playa de San Lorenzo, gijon','Un evento que llenará nuestros días de asombro y emoción. Durante estos días inolvidables, nuestro cielo se convertirá en el escenario de un espectáculo impresionante, con actividades para toda la familia.');
insert into eventos values(8,'24-01-2026','monoloco fest','pabellón de la Magdalena, aviles','Un festival de musica urbana que se celebra en diferentes ciudades de españa');
insert into eventos values(9,'25-06-2026','exposicion silvia cruz','Aviles','Nueva y originales canciones para compartir, con sonidos familiares y nuevos horizontes');
insert into eventos values(10,'21-07-2026','exposicion alvarez duarte','Gijon','Un recorrido a través de la obras del imaginero y escultor andaluz');
insert into eventos values(11,'20-09-2026','fraude','Gijón','Pelicula de 1973 sobre un falsificador de arte temido y admirado por museos');
insert into eventos values(12,'15-08-2026','exposicion cristobal aviles','Gijón','Una exposición dedicada al creador Cristóbal Aviles a traves de obras realizadas con hierro, piedra y cerámica');

insert into galerias values(1,'imagenes teatro Jovellanos',1);
insert into galerias values(2,'imagenes teatro Jovellanos',2);
insert into galerias values(3,'imagenes teatro Jovellanos',3);
insert into galerias values(4,'imagenes desfile Avilés',4);
insert into galerias values(5,'imagenes teatro Jovellanos',5);
insert into galerias values(6,'imagenes Tartiere',6);
insert into galerias values(7,'imagenes playa San Lorenzo',7);
insert into galerias values(8,'imagenes pabellon de la Magdalena',8);

insert into imagenes values(1,'foto1',11111111,1);
insert into imagenes values(2,'foto2',11111112,2);
insert into imagenes values(3,'foto3',11111113,3);
insert into imagenes values(4,'foto4',11111114,4);
insert into imagenes values(5,'foto5',11111115,5);
insert into imagenes values(6,'foto6',11111116,6);
insert into imagenes values(7,'foto7',11111117,7);
insert into imagenes values(8,'foto8',11111118,8);

insert into favoritos values(1,1);
insert into favoritos values(2,2);
insert into favoritos values(3,3);
insert into favoritos values(4,4);






create view galerias_antiguas as
select galerias.id_gal, galerias.titulo
from galerias
join eventos on id_even = id_gal
where fecha < ('28-02-2026');

select * from galerias_antiguas;

create view evento_favorito as
select eventos.titulo
from eventos
join favoritos on id_even = id_evento
where id_usuario = 1;

create view devolver_imagen as
select imagenes.titulo
from imagenes 
join galerias on id_galeria = id_gal
join eventos on id_gal= id_even
where fecha = ('12-01-2026');

create view eventos_favoritos as
select *
from eventos
join favoritos on id_even = id_evento
where id_usuario = 2
and fecha > ('28-02-2026');





















