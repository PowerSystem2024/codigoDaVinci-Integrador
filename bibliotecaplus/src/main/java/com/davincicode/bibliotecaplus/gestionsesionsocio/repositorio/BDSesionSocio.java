package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{
    private List<Socio> registroSocios;

    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
    }

@Override
public boolean permitirLoginSocio(String nombreUsuarioLoginIngresado, String contraseniaLoginIngresada) {
    if(!nombreUsuarioLoginIngresado.trim().isEmpty() && !contraseniaLoginIngresada.trim().isEmpty() ){
        for(int i = 0; i < registroSocios.size(); i++){ 
            //valido que nombre suario y contraseña coincidan con algún elemento de la lista
            if(nombreUsuarioLoginIngresado.equalsIgnoreCase(registroSocios.get(i).getNombreUsuarioLogin())
                    && contraseniaLoginIngresada.equalsIgnoreCase(registroSocios.get(i).getContraseniaLogin())) {
                return true;
            }
        }
    }
    return false; /*por defecto no va a permitir el login*/

}
