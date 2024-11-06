package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDLibros implements LibroRepository {

    private List<Resenia> resenias;
    private List<Libro> libros;
    private int contadorId; // Para asignar ID único a los libros

    public BDLibros() {
        this.resenias = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.contadorId = 1; // Empezar el contador desde 1

        // Agregar 10 libros por defecto
        agregarLibro("El Aleph", "Jorge Luis Borges", true, 0); // Disponible
        agregarLibro("Cien años de soledad", "Gabriel García Márquez", false, 101224); // Prestado
        agregarLibro("Rayuela", "Julio Cortázar", true, 0); // Disponible
        agregarLibro("Don Quijote de la Mancha", "Miguel de Cervantes", true, 0); // Disponible
        agregarLibro("Fervor de Buenos Aires", "Jorge Luis Borges", false, 111224); // Prestado
        agregarLibro("Los detectives salvajes", "Roberto Bolaño", true, 0); // Disponible
        agregarLibro("La invención de Morel", "Adolfo Bioy Casares", false, 121224); // Prestado
        agregarLibro("La sombra del viento", "Carlos Ruiz Zafón", true, 0); // Disponible
        agregarLibro("El túnel", "Ernesto Sabato", true, 0); // Disponible
        agregarLibro("Fortunata y Jacinta", "Benito Pérez Galdós", false, 131224); // Prestado
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
    public void agregarLibro(String titulo, String autor, boolean disponibilidad, int fechaDeDevolucion) {
        // Asignar un ID único al nuevo libro
        Libro nuevoLibro = new Libro(contadorId++, titulo, autor, disponibilidad, fechaDeDevolucion);
        libros.add(nuevoLibro);
    }
}
