/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author ALUMNOS-FP
 */
import java.util.ArrayList;

public class Eventos {

    public int id;
    private String fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Galeria> coleccion_galerias;

    public Eventos(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.coleccion_galerias = new ArrayList<>();
    }

    //getter
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Galeria> getColeccion_galerias() {
        return coleccion_galerias;
    }
    //setter

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setColeccion_galerias(ArrayList<Galeria> coleccion_galerias) {
        this.coleccion_galerias = coleccion_galerias;
    }

    @Override
    public String toString() {
        return "evento [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", galerias=" + coleccion_galerias.size() + "]";
    }

}
