package com.davincicode.bibliotecaplus.gestionusuarios.modelo;


import com.davincicode.bibliotecaplus.comunusuarios.modelo.Usuario;

public class Socio extends Usuario {
    /**Escribir atributos y comportamientos que necesitamos*/

    private static int id = 1; /*generamos un atributo de clase y no de objeto que funciona como contador cada vez que se instancia un objeto*/
    private int idSocio; /*atributo id que va a tener cada objeto creado*/

    public Socio() {
        idSocio = Socio.id++; /*el id del socio le ponemos el valor del contador*/
    }
}
