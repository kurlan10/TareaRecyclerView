package com.example.coursera.tarearecyclerview.pojo;

/**
 * Created by Quality on 05/06/2016.
 */
public class Mascota {
    private int id;
    private int foto;
    private String nombre;
    private int voto;

    public Mascota(int id ,int foto, String nombre, int voto) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.voto = voto;
    }

    public Mascota(){}

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
