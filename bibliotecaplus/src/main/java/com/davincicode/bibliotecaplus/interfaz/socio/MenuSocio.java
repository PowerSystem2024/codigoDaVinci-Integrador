package com.davincicode.bibliotecaplus.interfaz.socio;
import javax.swing.*;

public class MenuSocio {
    public void mostrarMenu() {
        JOptionPane.showMessageDialog(null, "Bienvenido, Socio. Aún no se ha implementado esta funcionalidad.", "Socio", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Bienvenidos ☺!", "Socio", JOptionPane.INFORMATION_MESSAGE);
        String[] funcionalidades = {"Buscar Libros disponibles", "Agregar Libro", "Dejar reseña", "Salir"};

        int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);
        switch (funcionSeleccionada){
            case -1:
                System.exit(0);
                //     break;
            case 0:
                //TODO: llamamos a la función que posibilita buscar libros disponibles
                break;
            case 1:
                //TODO: llamar método para Agregar libros
                break;
            case 2:
                //TODO: Llamar método para añadir reseña
                break;
            case 3:
                /*si selecciona la opción de la posición 3 "salir" lo sacamos del sistema*/
                System.exit(0);
                break;
        }
    }

    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Socio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
    }

    }

