package com.davincicode.bibliotecaplus.gestionusuarios.modelo;


import com.davincicode.bibliotecaplus.comunusuarios.modelo.Usuario;

public class Socio extends Usuario {

    private static int idSocio = 0;/*generamos un atributo de la clase y no de los objetos / idSocio lo incrementamos en 1 cada vez que se crea un objeto de tipo Socio*/

    public Socio() {
        idSocio = Socio.idSocio++; //para acceder al idSocio (atributo de clase) primero llamamos a la clase y luego al atributo, acá incrementamos en 1 en el constructor de la clase para aumentar en 1 el valor de idSocio cuando se instancia la clase
    }
}
