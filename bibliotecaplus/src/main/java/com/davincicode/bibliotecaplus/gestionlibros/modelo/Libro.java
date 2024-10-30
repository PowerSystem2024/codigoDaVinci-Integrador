package com.davincicode.bibliotecaplus.gestionlibros.modelo;

public class Libro {
    /**Escribir atributos y comportamientos que necesitamos*/

    private static int id = 0; /*generamos un atributo de clase y no de objeto que funciona como contador cada vez que se instancia un objeto*/

    private int idLibro; /*atributo id que va a tener cada objeto creado*/

    public Libro(){
        idLibro = Libro.id++; /*el id del socio le ponemos el valor del contador*/
    }

    public static int getId() {
        return id;
    }

}
