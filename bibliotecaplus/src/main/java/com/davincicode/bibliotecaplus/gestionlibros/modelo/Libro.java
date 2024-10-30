package com.davincicode.bibliotecaplus.gestionlibros.modelo;

public class Libro {

    private static int idLibro = 0; /*generamos un atributo de la clase y no de los objetos / idSocio lo incrementamos en 1 cada vez que se crea un objeto de tipo Socio*/

    public Libro(){
        idLibro = Libro.idLibro++; //para acceder al idLibro (atributo de clase) primero llamamos a la clase y luego al atributo, acá incrementamos en 1 en el constructor de la clase para aumentar en 1 el valor de idLibro cuando se instancia la clase
    }
   /**Escribir atributos y comportamientos que necesitamos*/
}
