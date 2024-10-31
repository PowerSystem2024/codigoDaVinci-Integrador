package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import java.util.List;

public interface LibroRepository {
   
    List<Libro> obtenerTodosLosLibros ();
    void agregarLibro(String titulo, String autor, boolean disponibilidad, int fechaDeDevolucion);
}