/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author ALUMNOS-FP
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int resp;

        //ArrayList
        ArrayList<Favorito> list_favorito = new ArrayList<>();

        //hashmap
        HashMap<String, Usuarios> map_usuarios = new HashMap<>();
        HashMap<Integer, Eventos> map_eventos = new HashMap<>();

        do {
            System.out.println("Escoja una de las siguientes opciones:");
            System.out.println("1.Añadir usuario");
            System.out.println("2.Eliminar usuario");
            System.out.println("3.Añadir evento");
            System.out.println("4.Eliminar evento");
            System.out.println("5.Añadir galeria");
            System.out.println("6.Eliminar galeria");
            System.out.println("7.Añadir favorito");
            System.out.println("8.Eliminar favorito");
            System.out.println("9.Salir");
            System.out.println("Ingrese la opción elegida: ");
            resp = teclado.nextInt();
            comprobar(resp);
            teclado.nextLine();

            switch (resp) {
                case 1:
                    map_usuarios = anadir_usuario(teclado, map_usuarios);
                    break;
                case 2:
                    map_usuarios = eliminar_usuario(teclado, map_usuarios);
                    break;
                case 3:
                    map_eventos = anadir_evento(teclado, map_eventos);
                    break;
                case 4:
                    map_eventos = eliminar_evento(teclado, map_eventos);
                    break;
                case 5:
                    map_eventos = anadir_galeria(teclado, map_eventos);
                    break;
                case 6:
                    map_eventos = eliminar_galeria(teclado, map_eventos);
                    break;
                case 7:
                    list_favorito = anadir_favorito(teclado, map_eventos, map_usuarios, list_favorito);
                    break;
                case 8:
                    list_favorito = eliminar_favorito(teclado, map_eventos, map_usuarios, list_favorito);
                    break;
                case 9:
                    System.out.println("Fin del programa.");
            }
        } while (resp != 9);
    }

    public static void comprobar(int resp) {
        if (resp > 9 || resp < 1) {
            System.out.println("Numero incorrecto escoja una de las opciones.");
        }
    }

    public static HashMap<String, Usuarios> anadir_usuario(Scanner teclado, HashMap<String, Usuarios> map_usuarios) {
        String correo, nombre, contrasena;

        System.out.println("--Introduzca los siguientes datos--");
        System.out.println("\n-Nombre: ");
        nombre = teclado.nextLine();
        System.out.println("\n-Email: ");
        correo = teclado.nextLine();
        System.out.println("\n-Contraseña: ");
        contrasena = teclado.nextLine();

        if (map_usuarios.containsKey(correo)) {
            System.out.println("\nEl usuario ya existe");
            System.out.println("-----------");
        } else {
            Usuarios usuario = new Usuarios(nombre, correo, contrasena);
            map_usuarios.put(correo, usuario);
            System.out.println("\nUsuario creado correctamente");
            System.out.println("-----------");
        }
        return map_usuarios;
    }

    public static HashMap<String, Usuarios> eliminar_usuario(Scanner teclado, HashMap<String, Usuarios> map_usuarios) {
        String correo;

        System.out.println("Introduzca el correo del usuario que se desea eliminar:");
        correo = teclado.nextLine();

        if (!map_usuarios.containsKey(correo)) {
            System.out.println("El usuario no existe");
            System.out.println("-----------");

        } else {
            map_usuarios.remove(correo);
            System.out.println("Usuario eliminado correctamente");
            System.out.println("-----------");

        }
        return map_usuarios;
    }

    public static HashMap<Integer, Eventos> anadir_evento(Scanner teclado, HashMap<Integer, Eventos> map_eventos) {
        String fecha, titulo, ubicacion, descripcion;
        int contador_evento = 0;

        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("-Fecha: ");
        fecha = teclado.nextLine();
        System.out.println("-Titulo: ");
        titulo = teclado.nextLine();
        System.out.println("-Ubicacion: ");
        ubicacion = teclado.nextLine();
        System.out.println("-Descripcion");
        descripcion = teclado.nextLine();

        map_eventos.put(contador_evento, new Eventos(contador_evento, fecha, titulo, ubicacion, descripcion));
        contador_evento++;
        System.out.println("Evento creado correctamente");

        return map_eventos;
    }

    public static HashMap<Integer, Eventos> eliminar_evento(Scanner teclado, HashMap<Integer, Eventos> map_eventos) {
        int id_evento, id_evento_borrar;
        String titulo_evento;

        for (Eventos evento : map_eventos.values()) {
            id_evento = evento.getId();
            titulo_evento = evento.getTitulo();
            System.out.println("--Listado de eventos--");
            System.out.printf("\n-id: %d", id_evento);
            System.out.printf("\n-titulo: %s", titulo_evento);
            System.out.println("\n-----------------");

        }
        System.out.println("Introduzca el id del evento que se desea eliminar: ");
        id_evento_borrar = teclado.nextInt();

        if (!map_eventos.containsKey(id_evento_borrar)) {
            System.out.println("El evento no existe");
        } else {
            map_eventos.remove(id_evento_borrar);
            System.out.println("Evento eliminado correctamente");
        }

        return map_eventos;
    }

    public static HashMap<Integer, Eventos> anadir_galeria(Scanner teclado, HashMap<Integer, Eventos> map_eventos) {
        int id_evento, contador_galeria = 0;
        String titulo_evento, titulo;

        for (Eventos evento : map_eventos.values()) {
            id_evento = evento.getId();
            titulo_evento = evento.getTitulo();
            System.out.println("--Listado de eventos--");
            System.out.printf("\n-Id: %d", id_evento);
            System.out.printf("\n-Titulo: %s\n", titulo_evento);
            System.out.println("\n----------");

        }

        System.out.println("\nintroduzca el id del evento donde se va a añadir la galeria:");
        id_evento = teclado.nextInt();
        teclado.nextLine();

        Eventos evento_elegido = null;
        for (Eventos evento : map_eventos.values()) {
            if (evento.getId() == id_evento) {
                evento_elegido = evento;
            }
        }

        if (evento_elegido == null) {
            System.out.println("El evento no existe");
            return null;
        }

        System.out.println("Introduzca el titulo de la galeria:");
        titulo = teclado.nextLine();

        evento_elegido.getMap_galerias().put(contador_galeria, new Galeria(contador_galeria, titulo, id_evento));
        contador_galeria++;
        System.out.println("Galeria creada correctamente");
        return map_eventos;
    }

    public static HashMap<Integer, Eventos> eliminar_galeria(Scanner teclado, HashMap<Integer, Eventos> map_eventos) {
        for (Eventos evento : map_eventos.values()) {
            int id_evento = evento.getId();
            String titulo_evento = evento.getTitulo();
            System.out.println("--istado de eventos--");
            System.out.printf("\n-id: %d", id_evento);
            System.out.printf("\n-titulo: %s", titulo_evento);
            System.out.println("\n---------");
        }

        System.out.println("\n introduzca el id del evento donde se va a eliminar:");
        int id_evento = teclado.nextInt();
        teclado.nextLine();

        Eventos evento_elegido = null;
        for (Eventos evento : map_eventos.values()) {
            if (evento.getId() == id_evento) {
                evento_elegido = evento;
            }
        }

        if (evento_elegido == null) {
            System.out.println("El evento no existe");
            return map_eventos;
        }

        for (Galeria galeria : evento_elegido.getMap_galerias().values()) {
            int id_galeria = galeria.getId();
            String titulo_galeria = galeria.getTitulo();
            System.out.printf("\n-id: %d", id_galeria);
            System.out.printf("\n-titulo: %s", titulo_galeria);
            System.out.println("---------");
        }

        System.out.println("\nIntroduzca el id de la galeria a eliminar: ");
        int id_galeria = teclado.nextInt();
        teclado.nextLine();

        if (!evento_elegido.getMap_galerias().containsKey(id_galeria)) {
            System.out.println("La galeria no existe");
        } else {
            evento_elegido.getMap_galerias().remove(id_galeria);
            System.out.println("Galeria eliminada correctamente");
        }
        return map_eventos;
    }

    public static ArrayList<Favorito> anadir_favorito(Scanner teclado, HashMap<Integer, Eventos> map_eventos, HashMap<String, Usuarios> map_usuarios, ArrayList<Favorito> list_favorito) {
        for (Eventos evento : map_eventos.values()) {
            int id_mostrar = evento.getId();
            String titulo_evento = evento.getTitulo();
            System.out.println("\n--Eventos--");
            System.out.println("\nid: " + id_mostrar);
            System.out.println("\ntitulo: " + titulo_evento);
            System.out.println("\n--------------------");
        }

        for (Usuarios usuario : map_usuarios.values()) {
            String correo_usuario = usuario.getEmail();
            String nombre_usuario = usuario.getNombre();
            System.out.println("\n--Usuarios--");
            System.out.println("\nCorreo: " + correo_usuario);
            System.out.println("\nNombre: " + nombre_usuario);
            System.out.println("------------------");
        }

        System.out.println("\nIntroduzca el id del evento: ");
        int id_evento_favorito = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nIntroduzca el correo del usuario: ");
        String correo = teclado.nextLine();

        boolean evento_existe = false;
        for (Eventos evento : map_eventos.values()) {
            if (evento.getId() == id_evento_favorito) {
                evento_existe = true;
            }
        }

        boolean usuario_existe = false;
        for (Usuarios usuario : map_usuarios.values()) {
            String correo_usuario = usuario.getEmail();
            if (correo_usuario.equals(correo)) {
                usuario_existe = true;
            }
        }

        if (!evento_existe) {
            System.out.println("El evento no existe");
        } else if (!usuario_existe) {
            System.out.println("El usuario no existe");
        } else {
            Favorito favorito_anadido = new Favorito(correo, id_evento_favorito);
            list_favorito.add(favorito_anadido);
            System.out.println("Favorito creado correctamente");
        }
        return list_favorito;
    }

    public static ArrayList<Favorito> eliminar_favorito(Scanner teclado, HashMap<Integer, Eventos> map_eventos, HashMap<String, Usuarios> map_usuarios, ArrayList<Favorito> list_favorito) {
        int id_evento_favorito;
        String correo;

        for (Favorito favorito : list_favorito) {
            String correo_usuario_favorito;
            int mostrar_id;

            correo_usuario_favorito = favorito.getCorreo_usuario();
            mostrar_id = favorito.getId_evento();
            System.out.println("\n--Favoritos--");
            System.out.printf("\nCorreo: %s", correo_usuario_favorito);
            System.out.printf("\nId del evento: %s", mostrar_id);
            System.out.println("\n-------------------");
        }

        System.out.println("\nIntroduzca el id del evento: ");
        id_evento_favorito = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nIntroduzca el correo: ");
        correo = teclado.nextLine();

        Favorito eliminar_favorito = null;
        for (Favorito favorito : list_favorito) {
            int id_favorito = favorito.getId_evento();
            String correo_favorito = favorito.getCorreo_usuario();
            if (id_favorito == id_evento_favorito && correo_favorito.equals(correo)) {
                eliminar_favorito = favorito;
            }
        }

        if (eliminar_favorito == null) {
            System.out.println("\nEl favorito no existe.");
            System.out.println("\n------------------");
        } else {
            list_favorito.remove(eliminar_favorito);
            System.out.println("\nFavorito eliminado correctamente.");
            System.out.println("\n---------------");
        }
        return list_favorito;
    }
}
