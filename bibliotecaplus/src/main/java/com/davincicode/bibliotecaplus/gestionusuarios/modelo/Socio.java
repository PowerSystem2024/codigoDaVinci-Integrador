package com.davincicode.bibliotecaplus.gestionusuarios.modelo;


import com.davincicode.bibliotecaplus.comunusuarios.modelo.Usuario;

public class Socio extends Usuario {
    /**Escribir atributos y comportamientos que necesitamos*/

    private static int id = 1; /*generamos un atributo de clase y no de objeto que funciona como contador cada vez que se instancia un objeto*/
    private int idSocio; /*atributo id que va a tener cada objeto creado*/
    private String apellido;
    private String telefono;
    private String nombreUsuarioRegistro;
    private String contraseniaUsuarioRegistro;
    private String nombreUsuarioLogin;
    private String contraseniaLogin;

    public Socio(){
        idSocio = Socio.id++; /*el id del socio le ponemos el valor del contador*/
    }

    public Socio(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        super("Socio",nombre,correo);
        this.apellido = apellido;
        this.telefono = telefono;
        this.nombreUsuarioLogin = nombreUsuarioRegistro;
        this.contraseniaLogin = contraseniaUsuarioRegistro;
        idSocio = Socio.id++; /*el id del socio le ponemos el valor del contador*/
    }

    public int getIdSocio() {
        return idSocio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreUsuarioRegistro() {
        return nombreUsuarioRegistro;
    }

    public void setNombreUsuarioRegistro(String nombreUsuarioRegistro) {
        this.nombreUsuarioRegistro = nombreUsuarioRegistro;
    }

    public String getContraseniaUsuarioRegistro() {
        return contraseniaUsuarioRegistro;
    }

    public void setContraseniaUsuarioRegistro(String contraseniaUsuarioRegistro) {
        this.contraseniaUsuarioRegistro = contraseniaUsuarioRegistro;
    }

    public String getNombreUsuarioLogin() {
        return nombreUsuarioLogin;
    }

    public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
        this.nombreUsuarioLogin = nombreUsuarioLogin;
    }

    public String getContraseniaLogin() {
        return contraseniaLogin;
    }

    public void setContraseniaLogin(String contraseniaLogin) {
        this.contraseniaLogin = contraseniaLogin;
    }
}
