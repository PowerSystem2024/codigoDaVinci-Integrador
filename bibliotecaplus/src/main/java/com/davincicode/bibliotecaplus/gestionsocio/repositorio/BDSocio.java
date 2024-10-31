
package com.davincicode.bibliotecaplus.gestionsocio.repositorio;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;
import java.util.ArrayList;
import java.util.List;

public class BDSocio implements SocioRepository{
    List<Socio> listaSocios;// = new ArrayList<>;
    
    public BDSocio(){
        this.listaSocios = new ArrayList<>(); // Lista llena de socios
        inicializarListaSocios();
    }
    
    
    @Override
    public List<Socio> mostrarSocios() {
        return this.listaSocios; // Aca devuelve la lista de Socios
    }

    private void inicializarListaSocios() {
        listaSocios.add(new Socio("Santiago", "Seleme", "correo", "telefono", "Nombre de Usuario", "Contrasenia"));
    }
    
    
    
}
