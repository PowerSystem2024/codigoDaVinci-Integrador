package com.davincicode.bibliotecaplus.gestionlibros.modelo;

public class Libro {
    // Atributos de la clase
    private int idLibro; // Atributo id que tendrá cada objeto creado
    private String titulo;
    private String autor;
    private boolean disponibilidad;
    private int fechaDeDevolucion;

    // Constructor
    public Libro(int idLibro, String titulo, String autor, boolean disponibilidad, int fechaDeDevolucion) {
        this.idLibro = idLibro; // Se asigna el idLibro desde fuera
        this.titulo = titulo;
        this.autor = autor;
        this.disponibilidad = disponibilidad;
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    // Método para obtener el idLibro
    public int getIdLibro() {
        return idLibro;
    }

    // Métodos getter y setter para los atributos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(int fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }
}

