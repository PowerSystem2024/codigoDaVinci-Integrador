package com.davincicode.bibliotecaplus.gestionusuarios.modelo;


import com.davincicode.bibliotecaplus.comunusuarios.modelo.Usuario;

public class Socio extends Usuario {
    private Long idSocio;
    private String telefono;
    private String nombreUsuarioLogin;
    private String contraseniaLogin;

    private static int id = 1; /*generamos un atributo de clase y no de objeto que funciona como contador cada vez que se instancia un objeto*/
    private int idSocio; /*atributo id que va a tener cada objeto creado*/

    public Socio() {
        idSocio = Socio.id++; /*el id del socio le ponemos el valor del contador*/
    }

    public Socio(String rol, String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        super(rol, nombre, apellido, correo);
        this.telefono = telefono;
        this.nombreUsuarioLogin = nombreUsuarioRegistro;
        this.contraseniaUsuarioLogin = contraseniaUsuarioRegistro
}
