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
public class Galeria {

    private int id;
    private String titulo;
    private int id_evento;

    public Galeria(int id, String titulo, int id_evento) {
        this.id = id;
        this.titulo = titulo;
        this.id_evento = id_evento;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId_evento() {
        return id_evento;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    @Override
    public String toString() {
        return "galeria [id=" + id + ", titulo" + titulo + ", id_evento" + id_evento + "]";
    }
}
