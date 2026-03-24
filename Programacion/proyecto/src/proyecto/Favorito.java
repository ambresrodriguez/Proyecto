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
public class Favorito {

    private String correo_usuario;
    private int id_evento;

    public Favorito(String correo_usuario, int id_evento) {
        this.correo_usuario = correo_usuario;
        this.id_evento = id_evento;
    }
    //getter

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public int getId_evento() {
        return id_evento;
    }
    //setter

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    @Override
    public String toString() {
        return "favorito [correo" + correo_usuario + ", id_evento" + id_evento + "]";
    }
}
