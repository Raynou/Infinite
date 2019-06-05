package com.example.infinite.Clases_Recycler;

public class ListaPeliculas {

    private String Nombre_de_la_pelicula;
    private String Duracion;
    private String Url_de_imagen;



    public ListaPeliculas(String nombre_de_la_pelicula, String duracion, String url_de_imagen) {
        Nombre_de_la_pelicula = nombre_de_la_pelicula;
        Duracion = duracion;
        this.Url_de_imagen = url_de_imagen;
    }

    public String getNombre_de_la_pelicula() {
        return Nombre_de_la_pelicula;
    }

    public void setNombre_de_la_pelicula(String nombre_de_la_pelicula) {
        Nombre_de_la_pelicula = nombre_de_la_pelicula;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getUrl_de_imagen() {
        return Url_de_imagen;
    }

    public void setUrl_de_imagen(String url_de_imagen) {
        Url_de_imagen = url_de_imagen;
    }
}
