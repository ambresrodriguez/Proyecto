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
import java.util.HashMap;

public class Eventos {

    public int id;
    private String fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private HashMap<Integer, Galeria> map_galerias = new HashMap<>();

    public Eventos(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.map_galerias = new HashMap<Integer, Galeria>();
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

    public HashMap<Integer, Galeria> getMap_galerias() {
        return map_galerias;
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

    public void setMap_galerias(HashMap<Integer, Galeria> map_galerias) {
        this.map_galerias = map_galerias;
    }

    @Override
    public String toString() {
        return "evento [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", galerias=" + map_galerias.size() + "]";
    }

}
