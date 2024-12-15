package com.davincicode.bibliotecaplus.interfaz.bibliotecario;
import com.davincicode.bibliotecaplus.gestionautores.servicio.AutorServicio;
import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuBibliotecario {

    public void mostrarMenu() {
        JFrame frame = new JFrame("Menú del Bibliotecario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 540);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        ImageIcon imageIcon = new ImageIcon("src/main/resources/img/leonardo.png");
        Image image = imageIcon.getImage().getScaledInstance(600, 320, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image), SwingConstants.CENTER);
        frame.add(imageLabel);

        JLabel titleLabel = new JLabel("Seleccione una opción:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(titleLabel);

        JButton buscarAutoresButton = new JButton("Buscar Autores por Nacionalidad");
        buscarAutoresButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buscarAutoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAutoresPorNacionalidad();
            }
        });
        frame.add(buscarAutoresButton);

        JButton buscarLibrosButton = new JButton("Buscar Libros disponibles");
        buscarLibrosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buscarLibrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibrosDisponibles();
            }
        });
        frame.add(buscarLibrosButton);

        JButton agregarLibrosButton = new JButton("Agregar Libros");
        agregarLibrosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        agregarLibrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        frame.add(agregarLibrosButton);

        // Botón para Cambiar Fecha de Devolución
        JButton cambiarFechaDevolucionButton = new JButton("Cambiar Fecha de Devolución");
        cambiarFechaDevolucionButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cambiarFechaDevolucionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarFechaDevolucion();
            }
        });
        frame.add(cambiarFechaDevolucionButton);

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

    private void buscarAutoresPorNacionalidad() {
        String nacionalidad = JOptionPane.showInputDialog("Ingrese la nacionalidad del autor/escritor:");
        if (nacionalidad != null && !nacionalidad.trim().isEmpty()) {
            List<Autor> listaAutores = new AutorServicio().findAutorByNacionalidad(nacionalidad);
            mostrarDatosAutoresMismaNacionalidad(listaAutores);
        } else {
            JOptionPane.showMessageDialog(null, "La nacionalidad no puede estar vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarDatosAutoresMismaNacionalidad(List<Autor> listaAutores) {
        StringBuilder autores = new StringBuilder("Autores encontrados:\n");
        for (Autor autor : listaAutores) {
            autores.append("Nombre: ").append(autor.getNombre())
                   .append(", Apellido: ").append(autor.getApellido())
                   .append(", Nacionalidad: ").append(autor.getNacionalidad()).append("\n");
        }
        JOptionPane.showMessageDialog(null, autores.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarLibrosDisponibles() {
        List<Libro> librosDisponibles = new LibroServicio().obtenerTodosLosLibros();//obtenerLibrosDisponibles(); no se che
        StringBuilder libros = new StringBuilder("Libros disponibles:\n");
        for (Libro libro : librosDisponibles) {
            libros.append("Título: ").append(libro.getTitulo())
                  .append(", Autor: ").append(libro.getAutor()).append("\n");
        }
        JOptionPane.showMessageDialog(null, libros.toString(), "Libros Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        

        if (titulo != null && autor != null && !titulo.isEmpty() && !autor.isEmpty()) {
            new LibroServicio().agregarLibroABiblioteca(titulo, autor, true);//agregarLibro(titulo, autor, Integer.parseInt(fechaDevolucion)); no funciona
            JOptionPane.showMessageDialog(null, "Libro agregado con éxito.", "Agregar Libro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios para agregar un libro.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cambiarFechaDevolucion() {
        String libroIdString = JOptionPane.showInputDialog("Ingrese el ID del libro cuyo retorno desea modificar:");

        if( !libroIdString.trim().isEmpty()){
            int libroId = Integer.parseInt(libroIdString);
            LibroServicio servicio = new LibroServicio();
            Libro libro = servicio.buscarLibroPorId(libroId);

            if (libro != null) {
                String mensajeLibro = "Datos del libro:\n" +
                        "Título: " + libro.getTitulo() + "\n" +
                        "Autor: " + libro.getAutor() + "\n" +
                        "Disponibilidad: " + (libro.isDisponibilidad() ? "Disponible" : "No disponible") + "\n" +
                        "Fecha de devolución actual: " + (libro.getFechaDeDevolucion() == 0 ? "No tiene fecha de devolución" : libro.getFechaDeDevolucion());

                JOptionPane.showMessageDialog(null, mensajeLibro, "Información del Libro", JOptionPane.INFORMATION_MESSAGE);

                if (!libro.isDisponibilidad()) {
                    String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha de devolución (en formato DDMMAA):");
                    int nuevaFechaInt = Integer.parseInt(nuevaFecha);
                    servicio.cambiarFechaDeDevolucion(libroId, nuevaFechaInt);
                    JOptionPane.showMessageDialog(null, "Fecha de devolución cambiada con éxito.", "Cambio de Fecha", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El libro está disponible y no tiene una fecha de devolución asignada. No se puede cambiar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Es necesario que ingreses el id del libro.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }
}
