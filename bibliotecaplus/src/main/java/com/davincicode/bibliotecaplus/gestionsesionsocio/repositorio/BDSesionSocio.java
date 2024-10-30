package com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;

import java.util.ArrayList;
import java.util.List;

public class BDSesionSocio implements SesionSocioRepository{
    private List<Socio> registroSocios;

    public BDSesionSocio(){
        this.registroSocios = new ArrayList<>();
    }


}
