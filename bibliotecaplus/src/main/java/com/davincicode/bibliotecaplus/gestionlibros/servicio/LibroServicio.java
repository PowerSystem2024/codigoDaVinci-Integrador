package com.davincicode.bibliotecaplus.gestionlibros.servicio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.repositorio.BDLibros;
import java.util.List;
import javax.swing.JOptionPane;

public class LibroServicio {
    private BDLibros datosLibros;

    public LibroServicio() {
        this.datosLibros = new BDLibros();
    }

    public List<Libro> obtenerTodosLosLibros() {
        return datosLibros.obtenerTodosLosLibros(); // Devuelve la lista de todos los libros
    }

    public void agregarResenia(Resenia resenia) {
        datosLibros.agregarReseniaLibro(resenia); // Agregar una reseña
    }

    public List<Resenia> mostrarResenias() {
        return datosLibros.mostrarResenias(); // Mostrar reseñas
    }

    public void agregarLibroABiblioteca(String titulo, String autor, boolean disponibilidad) {
        datosLibros.agregarLibro(titulo, autor, disponibilidad); // Agregar un libro a la biblioteca
    }

    // Función para cambiar la fecha de devolución
    public void cambiarFechaDeDevolucion(int idLibro, int nuevaFechaDeDevolucion) {
        // Buscar el libro por ID
        Libro libro = buscarLibroPorId(idLibro);

        if (libro != null) {
            if (libro.isDisponibilidad()) { // Si el libro está disponible
                // El libro no debería tener fecha de devolución
                libro.setFechaDeDevolucion(0); // Borramos la fecha de devolución (0 representa sin fecha)
                JOptionPane.showMessageDialog(null, "El libro está disponible y no tiene fecha de devolución.");
            } else {
                // Si el libro está prestado, se puede asignar una nueva fecha de devolución
                libro.setFechaDeDevolucion(nuevaFechaDeDevolucion);
                JOptionPane.showMessageDialog(null, "La fecha de devolución se ha actualizado correctamente.");
            }
        } else {
            // Si no se encuentra el libro con el ID dado
            JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado.");
        }
    }

    // Método para buscar un libro por su ID
    public Libro buscarLibroPorId(int idLibro) {
        for (Libro libro : datosLibros.obtenerTodosLosLibros()) {
            if (libro.getIdLibro() == idLibro) {
                return libro;
            }
        }
        return null; // Si no se encuentra el libro, retorna null
    }
}
