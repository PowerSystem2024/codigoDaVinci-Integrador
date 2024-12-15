package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDLibros implements LibroRepository {

    private List<Resenia> resenias;
    private List<Libro> libros;
    public BDLibros() {
        this.resenias = new ArrayList<>();
        this.libros = new ArrayList<>();
        inicializarListaDeLibro();

    }
    private void inicializarListaDeLibro(){
        libros.add(new Libro("El Aleph", "Jorge Luis Borges", true, 0));
        libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", false, 101224));
        libros.add(new Libro("Rayuela", "Julio Cortázar", true, 0));
    }

    @Override
    public void agregarReseniaLibro(Resenia resenia) {
        if (resenia == null) {
            JOptionPane.showMessageDialog(null, "El usuario no envió los datos del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir si la reseña es nula
        }
        resenias.add(resenia);
        JOptionPane.showMessageDialog(null, "La reseña se agregó correctamente, gracias por su contribución!");
    }

    @Override
    public List<Resenia> mostrarResenias() {
        return new ArrayList<>(resenias); // Retorna una nueva lista para evitar modificaciones externas
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(libros); // Retorna una nueva lista para evitar modificaciones externas
    }

    @Override
    public void agregarLibro(String titulo, String autor, boolean disponibilidad) {
        // Asignar un ID único al nuevo libro
        Libro nuevoLibro = new Libro(titulo, autor, disponibilidad);
        libros.add(nuevoLibro);
    }
}
