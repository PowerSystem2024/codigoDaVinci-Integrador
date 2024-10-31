package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{

    private List<Socio> registroSocios;

    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
    }

private void inicializarListaSocio(){
    registroSocios.add(new Socio("Pepe", "pele", "Sel@gmail.com", "2222", "login", "123"));
}


    @Override
    public void aniadirRegistroSocio(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
            Socio nuevoSocio = new Socio( nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
            registroSocios.add(nuevoSocio);
            JOptionPane.showMessageDialog(null, "El socio fue registrado con éxito!");
    }
}
