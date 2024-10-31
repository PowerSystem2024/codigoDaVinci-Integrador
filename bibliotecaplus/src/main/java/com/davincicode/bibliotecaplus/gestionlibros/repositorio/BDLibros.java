package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class BDLibros implements LibroRepository {
    private List<Libro> libros;
    
    public BDLibros(){
        this.libros = new ArrayList<>();
    
    }
    
    
    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }
     
}
