package com.davincicode.bibliotecaplus.gestionsesionsocio.servicio;

import com.davincicode.bibliotecaplus.gestionsesionsocio.repositorio.BDSesionSocio;

public class ServicioSesion {
    private BDSesionSocio bdSesionSocio;

    public ServicioSesion(){
        this.bdSesionSocio = new BDSesionSocio();
    }

    public boolean permitirLogin(String nombreUsuarioLogin, String contraseniaLogin){
        return bdSesionSocio.permitirLoginSocio(nombreUsuarioLogin,contraseniaLogin );
}
