package com.davincicode.bibliotecaplus.interfaz.socio;
import javax.swing.*;

public class MenuSocio {
    public void mostrarMenu() {
        String[] loginRegistro = {"Registrarse" , "Iniciar Sesión"};
        int seleccionIngresoSesion ;


    }

    private void ejecutarOpcionIniciarSesion(int seleccionIngresoSesion){
        switch (seleccionIngresoSesion){
            case 0:

                break;
            case 1:

                break;

            default:
                JOptionPane.showMessageDialog(null, "No es una opción correcta!");
                System.exit(0);
        }
    }

    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Socio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
    }



    private String[] funcionalidadesSocio(){
        String[] funcionalidades = {"Buscar Libros disponibles", "Agregar Libro", "Dejar reseña", "Salir"};
        return  funcionalidades;
    }
    private void ejecutarFuncionSeleccionadaPorSocio(int funcionSeleccionada){
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

    private static String[] armarModaliniciarSesion() {
        // Crea un JPanel para los inputs donde ingresa información el usuario
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreUsuarioLoginField = new JTextField(20);
        JTextField contraseniaUsuarioLoginField = new JTextField(20);


        // Agregar los campos al panel
        panel.add(new JLabel("Ingrese nombre usuario login:"));
        panel.add(nombreUsuarioLoginField);
        panel.add(new JLabel("Ingrese su contraseña:"));
        panel.add(contraseniaUsuarioLoginField);


        // Mostrar el dialogo con el panel
        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);

        // Si el usuario presiona OK, retornar los valores
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                    nombreUsuarioLoginField.getText(),
                    contraseniaUsuarioLoginField.getText(),
            };
        }
        return null; // Retornar null si se cancela
    }

    private void registrarSocio(){
        String[] datosRegistro = armarModalRegistroSocio();
        String nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro;
        nombre = datosRegistro[0];
        apellido = datosRegistro[1];
        correo = datosRegistro[2];
        telefono = datosRegistro[3];
        nombreUsuarioRegistro = datosRegistro[4];
        contraseniaUsuarioRegistro = datosRegistro[5];

        if (validarDatosIngresadosRegistro(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro)){
            ServicioSesion registrarSocio = new ServicioSocio();
            registrarSocio.registrarSocio(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
        }else{
            JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
            
        }

    private boolean validarDatosIngresadosRegistro(String nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro){
        if(!nombre.trim().isEmpty() && !apellido.trim().isEmpty() && !correo.trim().isEmpty() && !telefono.trim().isEmpty() && !nombreUsuarioRegistro.trim().isEmpty() %% !contraseniaUsuarioRegistro.trim().isEmpty(){
            return true;
        }
        return false;
    }

    
    }


