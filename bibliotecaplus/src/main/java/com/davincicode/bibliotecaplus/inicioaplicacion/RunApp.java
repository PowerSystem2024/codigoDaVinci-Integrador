//package com.davincicode.bibliotecaplus.inicioaplicacion;
//
//import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
//import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecario;
//import com.davincicode.bibliotecaplus.interfaz.socio.MenuSocio;
//
//import javax.swing.*;
///**Clase desde la cual corre la aplicación*/
//public class RunApp {
//    public static void main(String[] args) {
//        //Llamamos a la función que muestra el título de nuestra aplicación
//        mostrarTituloAplicacion();
//
//        // Inicializo un arreglo de tipo String con los valores de los roles que permite la aplicación
//        String[] opciones = inicializarArregloOpcionesRoles();
//
//        int seleccion = seleccionarRol(opciones);
//
//        // Validar la selección
//        validarSeleccionYMostrarMenuCorrespondiente(seleccion);
//    }
//
//    /**Generamos métodos publicos y estáticos para poder llamarlos desde el contexto estático del main
//     *
//     * los métodos con la palabra reservada static indican que pertenecen a la clase y no a una instancia específica de la clase
//     * de esta manera podemos llamar a los métodos directamente desde el contexto estático, sin tener que instanciar un objeto
//     * */
//
//    public static void mostrarTituloAplicacion(){
//       JOptionPane.showMessageDialog(null, "Bienvenido a BibliotecaPlus", "BibliotecaPlus", JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    public static String[]  inicializarArregloOpcionesRoles(){
//        return new String[]{"Bibliotecario", "Socio"};
//    }
//
//    public static int seleccionarRol(String[] opciones){
//        return JOptionPane.showOptionDialog(null, "Seleccione su rol:", "Selección de Rol",
//                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
//    }
//
//    public static void validarSeleccionYMostrarMenuCorrespondiente(int seleccion){
//        if (seleccion == -1) {
//            System.exit(0); // Si el usuario cierra la ventana
//        }
//        if (seleccion == 0) { // selección para el rol de Bibliotecario
//            /**cargamos la vista para el bibliotecario*/
//            MenuBibliotecario menuBibliotecario = new MenuBibliotecario();//creamos el menú para el bibliotecario
//            menuBibliotecario.mostrarMenu();
//        } else if (seleccion == 1) { // selección para el rol de Socio
//            /**cargamos la vista para el socio*/
//            MenuSocio menuSocio = new MenuSocio();
//            menuSocio.mostrarMenu();
//        }
//    }
//
//}
package com.davincicode.bibliotecaplus.inicioaplicacion;
import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecario;
import com.davincicode.bibliotecaplus.interfaz.socio.MenuSocio;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecario;

import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecario;

import com.davincicode.bibliotecaplus.interfaz.socio.MenuSocio;

import javax.swing.JButton;

public class RunApp {

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Bienvenido a BibliotecaPlus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450); // Tamaño ajustado a una pantalla mediana eje:y,x
       frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Cargar y redimensionar la imagen
ImageIcon imageIcon = new ImageIcon("src/main/resources/img/eva.png");
Image image = imageIcon.getImage();
Image newImage = image.getScaledInstance(600, 350, Image.SCALE_SMOOTH); // Ajusta el tamaño
imageIcon = new ImageIcon(newImage);
JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
frame.add(imageLabel);

        // Etiqueta de título
        JLabel titleLabel = new JLabel("Seleccione su Rol:", SwingConstants.CENTER);
titleLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Tamaño de fuente más pequeño
frame.add(titleLabel);

        // Botón para Bibliotecario
        JButton bibliotecarioButton = new JButton("Bibliotecario");
        bibliotecarioButton.setPreferredSize(new Dimension(20, 10)); // Ajustar tamaño de botón
        bibliotecarioButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Ajustar tamaño de la fuente
        bibliotecarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarSeleccionYMostrarMenuCorrespondiente(0);
            }
        });
        frame.add(bibliotecarioButton);

// Botón para Socio
        JButton socioButton = new JButton("Socio");
        socioButton.setPreferredSize(new Dimension(20, 10)); // Ajustar tamaño de botón
        socioButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Ajustar tamaño de la fuente
        socioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarSeleccionYMostrarMenuCorrespondiente(1);
            }
        });
        frame.add(socioButton);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    /**
     * Método para validar la selección y mostrar el menú correspondiente según
     * el rol
     */
    public static void validarSeleccionYMostrarMenuCorrespondiente(int seleccion) {
        if (seleccion == 0) { // Rol de Bibliotecario
            // Crear e invocar el menú de bibliotecario
            MenuBibliotecario menuBibliotecario = new MenuBibliotecario();
            menuBibliotecario.mostrarMenu();
        } else if (seleccion == 1) { // Rol de Socio
            // Crear e invocar el menú de socio
            MenuSocio menuSocio = new MenuSocio();
            menuSocio.mostrarMenu();
        }
    }
}
