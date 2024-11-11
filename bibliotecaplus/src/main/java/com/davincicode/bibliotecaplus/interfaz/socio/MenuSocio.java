//package com.davincicode.bibliotecaplus.interfaz.socio;
//import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
//import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
//import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
//import com.davincicode.bibliotecaplus.gestionsesionsocio.servicio.ServicioSesion;
//
//import javax.swing.*;
//import java.util.List;
//
//public class MenuSocio {
//    public void mostrarMenu() {
//
//        String[] loginRegistro = {"Registrarse" , "Iniciar Sesión"};
//
//        int seleccionIngresoSesion =  mostrarMsjeRegistroOLoginSocio(loginRegistro);
//        ejecutarOpcionIniciarSesion(seleccionIngresoSesion);
//
//    }
//
//    private void ejecutarOpcionIniciarSesion(int seleccionIngresoSesion){
//        switch (seleccionIngresoSesion){
//            case 0:
//                registrarSocio();
//                break;
//            case 1:
//                realizarLoginAplicacionSocio();
//                break;
//            default:
//                JOptionPane.showMessageDialog(null, "No es una opción correcta!");
//                System.exit(0);
//        }
//    }
//
//    private void registrarSocio(){
//        String [] datosRegistro = armarModalRegistroSocio();
//        String nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro;
//        nombre = datosRegistro[0];
//        apellido = datosRegistro[1];
//        correo = datosRegistro[2];
//        telefono = datosRegistro[3];
//        nombreUsuarioRegistro = datosRegistro[4];
//        contraseniaUsuarioRegistro = datosRegistro[5];
//
//        if(validarDatosIngresadosRegistro(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro)){
//            ServicioSesion registrarSocio = new ServicioSesion();
//            registrarSocio.registrarSocio(nombre, apellido, correo, telefono,nombreUsuarioRegistro, contraseniaUsuarioRegistro);
//        }else{
//            JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//
//    private boolean validarDatosIngresadosRegistro(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
//        /*validamos que los datos que ingresa el usuario no estén vacíos / Si no están vacíos retornamos true   */
//        if(!nombre.trim().isEmpty() && !apellido.trim().isEmpty() &&
//                !correo.trim().isEmpty() && !telefono.trim().isEmpty() &&
//                !nombreUsuarioRegistro.trim().isEmpty() && !contraseniaUsuarioRegistro.trim().isEmpty()){
//            return  true;
//        }
//        return false; //retornamos false por defecto
//    }
//
//    private boolean realizarLoginAplicacionSocio( ) {
//        String[] inputsIniciarSesion =  armarModaliniciarSesion();
//        if(permitirLoguearse(inputsIniciarSesion)){
//            String[] funcionalidades = funcionalidadesSocio();
//            int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);
//            ejecutarFuncionSeleccionadaPorSocio(funcionSeleccionada);
//            return true;
//        }
//        return false;
//    }
//
//    private boolean permitirLoguearse(String[] inputsLogearse ){
//        String nombreUsuarioLogin = inputsLogearse[0];
//        String contraseniaUsuarioLogin = inputsLogearse[1];
//
//        ServicioSesion servicioSesion = new ServicioSesion();
//        boolean permiteLogin = servicioSesion.permitirLogin(nombreUsuarioLogin, contraseniaUsuarioLogin);
//        return permiteLogin;
//
//    }
//
//    private void agregarResenia(){
//        String[] inputs = armarModalParaIngresarDatosResenia();
//        //posicion 0= nombre del libro, 1= nombre persona , 2 = calificacioón , 3= comentario
//        capturarDatosResenia(inputs);
//
//    }
//
//    private  void capturarDatosResenia(String[] inputs){
//        String nombreLibro = inputs[0];
//        String nombreSocio = inputs[1];
//        int calificacionLibro = Integer.parseInt(inputs[2]);
//        String textoResenia = inputs[3];
//
//        Resenia resenia = new Resenia(nombreLibro,nombreSocio, calificacionLibro,textoResenia );
//        agregarResenia(resenia);
//    }
//
//    private void agregarResenia(Resenia resenia){
//        LibroServicio biblioteca = new LibroServicio();
//        biblioteca.agregarResenia(resenia);
//    }
//
//    private List<Libro> obtenerTodosLosLibros(){
//        LibroServicio accesoLibros = new LibroServicio();
//        return accesoLibros.obtenerTodosLosLibros();
//    }
//
//    public void mostrarTodosLosLibros(){
//        List<Libro> listaLibros = obtenerTodosLosLibros();
//        StringBuilder listaDeLibros = new StringBuilder("Libros encontrados:\n");
//
//        for(Libro libro: listaLibros){
//            listaDeLibros.append("Nombre: ").append(libro.getTitulo())
//                    .append(", Autor: ").append(libro.getAutor())
//                    .append(", Fecha de Devolucion: ").append(libro.getFechaDeDevolucion()).append("\n");
//        }
//        JOptionPane.showMessageDialog(null,listaDeLibros.toString(),"Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE );
//
//
//    }
//
//    private static String[] armarModalRegistroSocio() {
//        // Crea un JPanel para los inputs donde ingresa información el usuario
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        JTextField nombreSocio = new JTextField(20);
//        JTextField apellidoSocio = new JTextField(20);
//        JTextField correoSocio = new JTextField(20);
//        JTextField celularSocio = new JTextField(20);
//        JTextField nombreUsuarioRegistro = new JTextField(20);
//        JTextField contraseniaUsuarioRegistro = new JTextField(20);
//
//
//        // Agregar los campos al panel
//        panel.add(new JLabel("Ingrese su nombre:"));
//        panel.add(nombreSocio);
//        panel.add(new JLabel("Ingrese su apellido:"));
//        panel.add(apellidoSocio);
//        panel.add(new JLabel("Ingrese su correo:"));
//        panel.add(correoSocio);
//        panel.add(new JLabel("Ingrese su número de teléfono:"));
//        panel.add(celularSocio);
//
//        panel.add(new JLabel("Ingrese un nombre usuario para su registro:"));
//        panel.add(nombreUsuarioRegistro);
//        panel.add(new JLabel("Ingrese su contraseña:"));
//        panel.add(contraseniaUsuarioRegistro);
//
//
//        // Mostrar el dialogo con el panel
//        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario presiona OK, retornar los valores
//        if (option == JOptionPane.OK_OPTION) {
//            return new String[]{
//                    nombreSocio.getText(),
//                    apellidoSocio.getText(),
//                    correoSocio.getText(),
//                    celularSocio.getText(),
//                    nombreUsuarioRegistro.getText(),
//                    contraseniaUsuarioRegistro.getText(),
//            };
//        }
//        return null; // Retornar null si se cancela
//    }
//
//    private static String[] armarModaliniciarSesion() {
//        // Crea un JPanel para los inputs donde ingresa información el usuario
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JTextField nombreUsuarioLoginField = new JTextField(20);
//        JTextField contraseniaUsuarioLoginField = new JTextField(20);
//
//
//        // Agregar los campos al panel
//        panel.add(new JLabel("Ingrese nombre usuario login:"));
//        panel.add(nombreUsuarioLoginField);
//        panel.add(new JLabel("Ingrese su contraseña:"));
//        panel.add(contraseniaUsuarioLoginField);
//
//
//        // Mostrar el dialogo con el panel
//        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario presiona OK, retornar los valores
//        if (option == JOptionPane.OK_OPTION) {
//            return new String[]{
//                    nombreUsuarioLoginField.getText(),
//                    contraseniaUsuarioLoginField.getText(),
//            };
//        }
//        return null; // Retornar null si se cancela
//    }
//
//    private static String[] armarModalParaIngresarDatosResenia() {
//        // Crea un JPanel para los inputs donde ingresa información el usuario
//        JPanel panel = new JPanel();
//        JTextField libroField = new JTextField(20);
//        JTextField usuarioField = new JTextField(20);
//        JTextField calificacionField = new JTextField(5);
//        JTextArea reseniaArea = new JTextArea(5, 20);
//        reseniaArea.setLineWrap(true);
//        reseniaArea.setWrapStyleWord(true);
//
//        // Agregar los campos al panel
//        panel.add(new JLabel("Ingrese el nombre del libro:"));
//        panel.add(libroField);
//        panel.add(new JLabel("Ingrese su nombre:"));
//        panel.add(usuarioField);
//        panel.add(new JLabel("Ingrese la calificación (1-5):"));
//        panel.add(calificacionField);
//        panel.add(new JLabel("Ingrese una reseña:"));
//        panel.add(new JScrollPane(reseniaArea));
//
//        // Mostrar el dialogo con el panel
//        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar Libro y Reseña", JOptionPane.OK_CANCEL_OPTION);
//
//        // Si el usuario presiona OK, retornar los valores
//        if (option == JOptionPane.OK_OPTION) {
//            return new String[]{
//                    libroField.getText(),
//                    usuarioField.getText(),
//                    calificacionField.getText(),
//                    reseniaArea.getText()
//            };
//        }
//        return null; // Retornar null si se cancela
//    }
//
//    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
//        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Socio",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
//    }
//
//    private int mostrarMsjeRegistroOLoginSocio(String[] loginRegistro){
//        return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Ingreso",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, loginRegistro, loginRegistro[0]);
//    }
//
//    private String[] funcionalidadesSocio(){
//        String[] funcionalidades = {"Buscar Libros disponibles", "Dejar reseña", "Salir"};
//        return  funcionalidades;
//    }
//    private void ejecutarFuncionSeleccionadaPorSocio(int funcionSeleccionada){
//        switch (funcionSeleccionada){
//            case -1:
//                System.exit(0);
//                //     break;
//            case 0:
//                mostrarTodosLosLibros();
//                break;
//            case 1:
//                agregarResenia();
//                break;
//            case 2:
//                /*si selecciona la opción de la posición 3 "salir" lo sacamos del sistema*/
//                System.exit(0);
//                break;
//        }
//    }
//
//}
//package com.davincicode.bibliotecaplus.interfaz.socio;
//
//import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
//import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
//import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
//import com.davincicode.bibliotecaplus.gestionsesionsocio.servicio.ServicioSesion;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class MenuSocio {
//    private JFrame frame;
//
//    public void mostrarMenu() {
//        frame = new JFrame("Menú del Socio");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 500);
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//
//        // Cargar la imagen
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/th.jpeg");
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(600, 320, Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
//        frame.add(imageLabel);
//
//        JLabel titleLabel = new JLabel("Seleccione una opción:", SwingConstants.CENTER);
//        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        frame.add(titleLabel);
//
//        JButton registrarseButton = new JButton("Registrarse");
//        registrarseButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        registrarseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                registrarSocio();
//            }
//        });
//        frame.add(registrarseButton);
//
//        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
//        iniciarSesionButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        iniciarSesionButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                realizarLoginAplicacionSocio();
//            }
//        });
//        frame.add(iniciarSesionButton);
//
//        JButton salirButton = new JButton("Salir");
//        salirButton.setFont(new Font("Arial", Font.PLAIN, 16));
//        salirButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//            }
//        });
//        frame.add(salirButton);
//
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    private void registrarSocio() {
//        String[] datosRegistro = armarModalRegistroSocio();
//
//        if (datosRegistro != null) {
//            String nombre = datosRegistro[0];
//            String apellido = datosRegistro[1];
//            String correo = datosRegistro[2];
//            String telefono = datosRegistro[3];
//            String nombreUsuarioRegistro = datosRegistro[4];
//            String contraseniaUsuarioRegistro = datosRegistro[5];
//
//            if (validarDatosIngresadosRegistro(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro)) {
//                ServicioSesion registrarSocio = new ServicioSesion();
//                registrarSocio.registrarSocio(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
//            } else {
//                JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    private boolean validarDatosIngresadosRegistro(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
//        return !nombre.trim().isEmpty() && !apellido.trim().isEmpty()
//                && !correo.trim().isEmpty() && !telefono.trim().isEmpty()
//                && !nombreUsuarioRegistro.trim().isEmpty() && !contraseniaUsuarioRegistro.trim().isEmpty();
//    }
//
//    private boolean realizarLoginAplicacionSocio() {
//        String[] inputsIniciarSesion = armarModalIniciarSesion();
//        
//        if (inputsIniciarSesion != null && permitirLoguearse(inputsIniciarSesion)) {
//            String[] funcionalidades = funcionalidadesSocio();
//            mostrarPanelSocio();
//            int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);
//            ejecutarFuncionSeleccionadaPorSocio(funcionSeleccionada);
//            return true;
//        }
//        
//        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
//        return false;
//    }
//
//    private boolean permitirLoguearse(String[] inputsLogearse) {
//        String nombreUsuarioLogin = inputsLogearse[0];
//        String contraseniaUsuarioLogin = inputsLogearse[1];
//
//        ServicioSesion servicioSesion = new ServicioSesion();
//        return servicioSesion.permitirLogin(nombreUsuarioLogin, contraseniaUsuarioLogin);
//    }
//    
//    private void mostrarPanelSocio() {
//        JFrame panelFrame = new JFrame("Bienvenido Socio!!!");
//        panelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        panelFrame.setSize(600, 400);
//        panelFrame.setLayout(new BoxLayout(panelFrame.getContentPane(), BoxLayout.Y_AXIS));
//
//        // Cargar la imagen
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/monali.jpg"); // Asegúrate de que la ruta de la imagen es correcta
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(600, 320, Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
//        panelFrame.add(imageLabel);
//
//        JLabel welcomeLabel = new JLabel("Bienvenido, Socio!", SwingConstants.CENTER);
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        panelFrame.add(welcomeLabel);
//
//        panelFrame.setLocationRelativeTo(null);
//        panelFrame.setVisible(true);
//    }
//
//    private static String[] armarModalRegistroSocio() {
//        JFrame frame = new JFrame("Registrar Socio");
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(500, 500);
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/ladyofpearl.jpeg");
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(500, 220, Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
//        frame.add(imageLabel);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JTextField nombreField = new JTextField(20);
//        JTextField apellidoField = new JTextField(20);
//        JTextField correoField = new JTextField(20);
//        JTextField telefonoField = new JTextField(20);
//        JTextField usuarioField = new JTextField(20);
//        JTextField contrasenaField = new JTextField(20);
//
//        panel.add(new JLabel("Ingrese su nombre:"));
//        panel.add(nombreField);
//        panel.add(new JLabel("Ingrese su apellido:"));
//        panel.add(apellidoField);
//        panel.add(new JLabel("Ingrese su correo:"));
//        panel.add(correoField);
//        panel.add(new JLabel("Ingrese su teléfono:"));
//        panel.add(telefonoField);
//        panel.add(new JLabel("Ingrese nombre de usuario:"));
//        panel.add(usuarioField);
//        panel.add(new JLabel("Ingrese su contraseña:"));
//        panel.add(contrasenaField);
//
//        frame.add(panel);
//
//        JButton submitButton = new JButton("Registrar");
//        submitButton.addActionListener(e -> {
//            String[] datos = {
//                nombreField.getText(),
//                apellidoField.getText(),
//                correoField.getText(),
//                telefonoField.getText(),
//                usuarioField.getText(),
//                contrasenaField.getText()
//            };
//            frame.dispose();
//        });
//
//        frame.add(submitButton);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//
//        return null;
//    }
//
//    private static String[] armarModalIniciarSesion() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JTextField nombreUsuarioLoginField = new JTextField(20);
//        JTextField contraseniaUsuarioLoginField = new JTextField(20);
//
//        panel.add(new JLabel("Ingrese nombre usuario login:"));
//        panel.add(nombreUsuarioLoginField);
//        panel.add(new JLabel("Ingrese su contraseña:"));
//        panel.add(contraseniaUsuarioLoginField);
//
//        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);
//
//        if (option == JOptionPane.OK_OPTION) {
//            return new String[]{
//                nombreUsuarioLoginField.getText(),
//                contraseniaUsuarioLoginField.getText(),
//            };
//        }
//        return null;
//    }
//
//    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades) {
//        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Socio",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
//    }
//
//       private int mostrarMsjeRegistroOLoginSocio(String[] loginRegistro) {
//        return JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Ingreso",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, loginRegistro, loginRegistro[0]);
//    }
//
//    private String[] funcionalidadesSocio() {
//        return new String[]{"Buscar Libros disponibles", "Dejar reseña", "Salir"};
//    }
//
//    private void agregarResenia() {
//        String[] inputs = armarModalParaIngresarDatosResenia();
//        capturarDatosResenia(inputs);
//    }
//
//    private void capturarDatosResenia(String[] inputs) {
//        if (inputs != null) {
//            String nombreLibro = inputs[0];
//            String nombreSocio = inputs[1];
//            int calificacionLibro = Integer.parseInt(inputs[2]);
//            String textoResenia = inputs[3];
//
//            Resenia resenia = new Resenia(nombreLibro, nombreSocio, calificacionLibro, textoResenia);
//            agregarResenia(resenia);
//        }
//    }
//
//    private void agregarResenia(Resenia resenia) {
//        LibroServicio biblioteca = new LibroServicio();
//        biblioteca.agregarResenia(resenia);
//    }
//
//    private List<Libro> obtenerTodosLosLibros() {
//        LibroServicio accesoLibros = new LibroServicio();
//        return accesoLibros.obtenerTodosLosLibros();
//    }
//
//    public void mostrarTodosLosLibros() {
//        List<Libro> listaLibros = obtenerTodosLosLibros();
//        StringBuilder listaDeLibros = new StringBuilder("Libros encontrados:\n");
//
//        for (Libro libro : listaLibros) {
//            listaDeLibros.append("Nombre: ").append(libro.getTitulo())
//                    .append(", Autor: ").append(libro.getAutor())
//                    .append(", Fecha de Devolucion: ").append(libro.getFechaDeDevolucion()).append("\n");
//        }
//        JOptionPane.showMessageDialog(null, listaDeLibros.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private static String[] armarModalParaIngresarDatosResenia() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JTextField libroField = new JTextField(20);
//        JTextField usuarioField = new JTextField(20);
//        JTextField calificacionField = new JTextField(5);
//        JTextArea reseniaArea = new JTextArea(5, 20);
//        reseniaArea.setLineWrap(true);
//        reseniaArea.setWrapStyleWord(true);
//
//        panel.add(new JLabel("Ingrese el nombre del libro:"));
//        panel.add(libroField);
//        panel.add(new JLabel("Ingrese su nombre:"));
//        panel.add(usuarioField);
//        panel.add(new JLabel("Ingrese la calificación (1-5):"));
//        panel.add(calificacionField);
//        panel.add(new JLabel("Ingrese una reseña:"));
//        panel.add(new JScrollPane(reseniaArea));
//
//        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar Libro y Reseña", JOptionPane.OK_CANCEL_OPTION);
//
//        if (option == JOptionPane.OK_OPTION) {
//            return new String[]{
//                libroField.getText(),
//                usuarioField.getText(),
//                calificacionField.getText(),
//                reseniaArea.getText()
//            };
//        }
//        return null;
//    }
//
//    private void ejecutarFuncionSeleccionadaPorSocio(int funcionSeleccionada) {
//        switch (funcionSeleccionada) {
//            case -1:
//                System.exit(0);
//            case 0:
//                mostrarTodosLosLibros();
//                break;
//            case 1:
//                agregarResenia();
//                break;
//            case 2:
//                System.exit(0);
//                break;
//        }
//    }
//}
package com.davincicode.bibliotecaplus.interfaz.socio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Resenia;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
import com.davincicode.bibliotecaplus.gestionsesionsocio.servicio.ServicioSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuSocio {
    private JFrame frame;

    public void mostrarMenu() {
        frame = new JFrame("Menú del Socio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Cargar la imagen
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/th.jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(600, 320, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
        frame.add(imageLabel);

        JLabel titleLabel = new JLabel("Seleccione una opción:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(titleLabel);

        JButton registrarseButton = new JButton("Registrarse");
        registrarseButton.setFont(new Font("Arial", Font.PLAIN, 16));
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarSocio();
            }
        });
        frame.add(registrarseButton);

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        iniciarSesionButton.setFont(new Font("Arial", Font.PLAIN, 16));
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLoginAplicacionSocio();
            }
        });
        frame.add(iniciarSesionButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setFont(new Font("Arial", Font.PLAIN, 16));
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(salirButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void registrarSocio() {
        String[] datosRegistro = armarModalRegistroSocio();

        if (datosRegistro != null) {
            String nombre = datosRegistro[0];
            String apellido = datosRegistro[1];
            String correo = datosRegistro[2];
            String telefono = datosRegistro[3];
            String nombreUsuarioRegistro = datosRegistro[4];
            String contraseniaUsuarioRegistro = datosRegistro[5];

            if (validarDatosIngresadosRegistro(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro)) {
                ServicioSesion registrarSocio = new ServicioSesion();
                registrarSocio.registrarSocio(nombre, apellido, correo, telefono, nombreUsuarioRegistro, contraseniaUsuarioRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Todos los datos son necesarios para el registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validarDatosIngresadosRegistro(String nombre, String apellido, String correo, String telefono, String nombreUsuarioRegistro, String contraseniaUsuarioRegistro) {
        return !nombre.trim().isEmpty() && !apellido.trim().isEmpty()
                && !correo.trim().isEmpty() && !telefono.trim().isEmpty()
                && !nombreUsuarioRegistro.trim().isEmpty() && !contraseniaUsuarioRegistro.trim().isEmpty();
    }

    private boolean realizarLoginAplicacionSocio() {
        String[] inputsIniciarSesion = armarModalIniciarSesion();
        
        if (inputsIniciarSesion != null && permitirLoguearse(inputsIniciarSesion)) {
            while (true) {
                mostrarPanelSocio();
                String[] funcionalidades = funcionalidadesSocio();
                int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);
                if (funcionSeleccionada == 2 || funcionSeleccionada == JOptionPane.CLOSED_OPTION) {
                    break; // Salir del bucle si se selecciona "Salir" o se cierra el JOptionPane
                }
                ejecutarFuncionSeleccionadaPorSocio(funcionSeleccionada);
            }
            return true;
        }
        
        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private boolean permitirLoguearse(String[] inputsLogearse) {
        String nombreUsuarioLogin = inputsLogearse[0];
        String contraseniaUsuarioLogin = inputsLogearse[1];

        ServicioSesion servicioSesion = new ServicioSesion();
        return servicioSesion.permitirLogin(nombreUsuarioLogin, contraseniaUsuarioLogin);
    }
    
    private void mostrarPanelSocio() {
        JFrame panelFrame = new JFrame("Bienvenido Socio!!!");
        panelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelFrame.setSize(600, 400);
        panelFrame.setLayout(new BoxLayout(panelFrame.getContentPane(), BoxLayout.Y_AXIS));

        // Cargar la imagen
        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/monali.jpg"); // Asegúrate de que la ruta de la imagen es correcta
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(600, 320, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
        panelFrame.add(imageLabel);

        JLabel welcomeLabel = new JLabel("Bienvenido, Socio!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panelFrame.add(welcomeLabel);

        panelFrame.setLocationRelativeTo(null);
        panelFrame.setVisible(true);
    }

    private static String[] armarModalRegistroSocio() {
        JFrame frame = new JFrame("Registrar Socio");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/ladyofpearl.jpeg");
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(500, 320, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
        frame.add(imageLabel);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreField = new JTextField(20);
        JTextField apellidoField = new JTextField(20);
        JTextField correoField = new JTextField(20);
        JTextField telefonoField = new JTextField(20);
        JTextField usuarioField = new JTextField(20);
        JTextField contrasenaField = new JTextField(20);

        panel.add(new JLabel("Ingrese su nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Ingrese su apellido:"));
        panel.add(apellidoField);
        panel.add(new JLabel("Ingrese su correo:"));
        panel.add(correoField);
        panel.add(new JLabel("Ingrese su teléfono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("Ingrese nombre de usuario:"));
        panel.add(usuarioField);
        panel.add(new JLabel("Ingrese su contraseña:"));
        panel.add(contrasenaField);

        frame.add(panel);

        JButton submitButton = new JButton("Registrar");
        submitButton.addActionListener(e -> {
            String[] datos = {
                nombreField.getText(),
                apellidoField.getText(),
                correoField.getText(),
                telefonoField.getText(),
                usuarioField.getText(),
                contrasenaField.getText()
            };
            frame.dispose();
        });

        frame.add(submitButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return null;
    }

    private static String[] armarModalIniciarSesion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nombreUsuarioLoginField = new JTextField(20);
        JTextField contraseniaUsuarioLoginField = new JTextField(20);

        panel.add(new JLabel("Ingrese nombre usuario login:"));
        panel.add(nombreUsuarioLoginField);
        panel.add(new JLabel("Ingrese su contraseña:"));
        panel.add(contraseniaUsuarioLoginField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar usuario y contraseña", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                nombreUsuarioLoginField.getText(),
                contraseniaUsuarioLoginField.getText(),
            };
        }
        return null;
    }

       private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades) {
        // Crear un JPanel para agregar la imagen y las opciones del menú
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        // Añadir la imagen al panel
//        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/monali.jpg"); // Asegúrate de que la ruta de la imagen es correcta
//        Image image = imageIcon.getImage();
//        Image newImage = image.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
//        imageIcon = new ImageIcon(newImage);
//        JLabel imageLabel = new JLabel(imageIcon);
//        panel.add(imageLabel);
//
//        // Añadir las opciones del menú al panel
//        panel.add(new JLabel("Seleccione una funcionalidad:", SwingConstants.CENTER));
//        for (String funcionalidad : funcionalidades) {
//            panel.add(new JButton(funcionalidad));
//        }

        return JOptionPane.showOptionDialog(null, panel, "Funciones Socio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
    }

    private String[] funcionalidadesSocio() {
        return new String[]{"Buscar Libros disponibles", "Dejar reseña", "Salir"};
    }

    private void agregarResenia() {
        String[] inputs = armarModalParaIngresarDatosResenia();
        capturarDatosResenia(inputs);
    }

    private void capturarDatosResenia(String[] inputs) {
        if (inputs != null) {
            String nombreLibro = inputs[0];
            String nombreSocio = inputs[1];
            int calificacionLibro = Integer.parseInt(inputs[2]);
            String textoResenia = inputs[3];

            Resenia resenia = new Resenia(nombreLibro, nombreSocio, calificacionLibro, textoResenia);
            agregarResenia(resenia);
        }
    }

    private void agregarResenia(Resenia resenia) {
        LibroServicio biblioteca = new LibroServicio();
        biblioteca.agregarResenia(resenia);
    }

    private List<Libro> obtenerTodosLosLibros() {
        LibroServicio accesoLibros = new LibroServicio();
        return accesoLibros.obtenerTodosLosLibros();
    }

    public void mostrarTodosLosLibros() {
        List<Libro> listaLibros = obtenerTodosLosLibros();
        StringBuilder listaDeLibros = new StringBuilder("Libros encontrados:\n");

        for (Libro libro : listaLibros) {
            listaDeLibros.append("Nombre: ").append(libro.getTitulo())
                    .append(", Autor: ").append(libro.getAutor())
                    .append(", Fecha de Devolucion: ").append(libro.getFechaDeDevolucion()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaDeLibros.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String[] armarModalParaIngresarDatosResenia() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField libroField = new JTextField(20);
        JTextField usuarioField = new JTextField(20);
        JTextField calificacionField = new JTextField(5);
        JTextArea reseniaArea = new JTextArea(5, 20);
        reseniaArea.setLineWrap(true);
        reseniaArea.setWrapStyleWord(true);

        panel.add(new JLabel("Ingrese el nombre del libro:"));
        panel.add(libroField);
        panel.add(new JLabel("Ingrese su nombre:"));
        panel.add(usuarioField);
        panel.add(new JLabel("Ingrese la calificación (1-5):"));
        panel.add(calificacionField);
        panel.add(new JLabel("Ingrese una reseña:"));
        panel.add(new JScrollPane(reseniaArea));

        int option = JOptionPane.showConfirmDialog(null, panel, "Ingresar Libro y Reseña", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                libroField.getText(),
                usuarioField.getText(),
                calificacionField.getText(),
                reseniaArea.getText()
            };
        }
        return null;
    }

    private void ejecutarFuncionSeleccionadaPorSocio(int funcionSeleccionada) {
        switch (funcionSeleccionada) {
            case -1:
                System.exit(0);
            case 0:
                mostrarTodosLosLibros();
                break;
            case 1:
                agregarResenia();
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}
