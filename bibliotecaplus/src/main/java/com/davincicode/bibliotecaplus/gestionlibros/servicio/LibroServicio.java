package com.davincicode.bibliotecaplus.gestionlibros.servicio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.repositorio.BDLibros;
import java.util.List;

public class LibroServicio {
    private BDLibros datosLibros;

    public LibroServicio( ){
        this.datosLibros = new BDLibros();
    }

    public List<Libro> obtenerTodosLosLibros(){
        return datosLibros.obtenerTodosLosLibros();//Devuelve la lista que retorna el metodo obtenerTodosLosLibros
    }
    
    public void agregarLibroABiblioteca(String titulo, String autor, boolean disponibilidad, int fechaDeDevolicion){
        datosLibros.agregarLibro(titulo, autor, disponibilidad, fechaDeDevolicion);
    }
}
