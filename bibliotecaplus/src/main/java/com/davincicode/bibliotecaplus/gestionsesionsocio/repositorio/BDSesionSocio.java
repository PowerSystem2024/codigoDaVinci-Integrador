package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{

    private List<Socio> registroSocios;

    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
        inicializarListaSocio();
    }

private void inicializarListaSocio(){
    registroSocios.add(new Socio("Pepe", "pele", "Sel@gmail.com", "2222", "login", "123"));
}
@Override
public boolean permitirLoginSocio(String nombreUsuarioLoginIngresado, String contraseniaLoginIngresada) {
        //valido que nombre suario y contraseña coincidan con algún elemento de la lista
        if (!nombreUsuarioLoginIngresado.trim().isEmpty() && !contraseniaLoginIngresada.trim().isEmpty()) {
        for (int i = 0; i < this.registroSocios.size(); i++) {

            if (nombreUsuarioLoginIngresado.equalsIgnoreCase(registroSocios.get(i).getNombreUsuarioLogin())
                    && contraseniaLoginIngresada.equalsIgnoreCase(registroSocios.get(i).getContraseniaLogin())) {
                return true;
            }
        }
    }
    return false; /*por defecto no va a permitir el login*/
}

    @Override
    public void aniadirRegistroSocio(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro){
        Socio nuevoSocio = new Socio(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
        registroSocios.add(nuevoSocio);
        JOptionPane.showMessageDialog(null, "El socio fue registrado con éxito!");
    }


}
