
package com.davincicode.bibliotecaplus.gestionsocio.servicio;

import com.davincicode.bibliotecaplus.gestionsocio.repositorio.BDSocio;
import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;
import java.util.ArrayList;
import java.util.List;

public class ServicioSocio {
    private BDSocio baseDatosSocios;
    
    public ServicioSocio(){ // Cada objeto de ServicioSocio genera una BDSocio
        baseDatosSocios = new BDSocio();
    }
    
    public List<Socio> obtenerSocios(){
        List<Socio> sociosFiltrados = new ArrayList<>();
        return baseDatosSocios.mostrarSocios();
    }
}
