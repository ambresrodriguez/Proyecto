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
                    anadir_usuario(teclado, map_usuarios);
                    break;
                case 2:
                    eliminar_usuario(teclado, map_usuarios);
                    break;
                case 3:
                    mostrarUsuarios(map_usuarios);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
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

    public static void anadir_usuario(Scanner teclado, HashMap<String, Usuarios> map_usuarios) {
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
    }

    public static void eliminar_usuario(Scanner teclado, HashMap<String, Usuarios> map_usuarios) {
        String correo;

        System.out.println("Introduzca el correo del usuario que se desea eliminar:");
        correo = teclado.nextLine();

        if (!map_usuarios.containsKey(correo)) {
            System.out.println("El usuario no existe");
        } else {
            map_usuarios.remove(correo);
            System.out.println("Usuario eliminado correctamente");
        }
    }

    public static void mostrarUsuarios(HashMap<String, Usuarios> usuarios) {
        for (Map.Entry<String, Usuarios> usuario : usuarios.entrySet()) {
            System.out.println(usuario.getKey() + ": " + usuario.getValue().getNombre());
        }
    }


}
