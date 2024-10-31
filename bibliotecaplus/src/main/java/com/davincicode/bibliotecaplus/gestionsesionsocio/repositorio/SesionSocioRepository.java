package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

public interface SesionSocioRepository {
  void aniadirRegistroSocio (String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro);

  boolean permitirLoginSocio(String nombreUsuarioLoginIngresado, String contraseniaLoginIngresada);
}
