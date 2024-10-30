package com.davincicode.bibliotecaplus.gestionsesionsocio.servicio;

import com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio.BDSesionSocio;

public class ServicioSesion {
    private BDSesionSocio bdSesionSocio;

    public ServicioSesion(){
        this.bdSesionSocio = new BDSesionSocio();
    }
}
