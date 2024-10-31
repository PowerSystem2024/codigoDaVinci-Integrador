package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{
    private List<Socio> registroSocios;

    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
    }

private void inicializarListaSocio(){
    registroSocios.add(new Socio(1L,"login", "123"));
}

@override
public void aniadirRegistroSocio(String nombre, String apellido, String correo, String telefono, String nomberUsuarioRegistro, String contraseniaUsuarioRegistro){
    Socio nuevoSocio = new Socio(ROL_SOCIO, nombre, apellio, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
    registroSocios.add(nuevoSocio);
    JOptionPane.showMessageDialog(null, "El socio fue registrado con éxito!");
}
    
}
