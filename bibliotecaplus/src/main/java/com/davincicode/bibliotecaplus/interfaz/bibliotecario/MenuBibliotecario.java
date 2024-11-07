package com.davincicode.bibliotecaplus.interfaz.bibliotecario;

import com.davincicode.bibliotecaplus.gestionautores.servicio.AutorServicio;
import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import com.davincicode.bibliotecaplus.gestionsocio.servicio.ServicioSocio;
import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Socio;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;

import javax.swing.*;
import java.util.List;
public class MenuBibliotecario {

    public void mostrarMenu() {
        // Array con las funcionalidades disponibles
        String[] funcionalidades = {"Buscar Autores por Nacionalidad", "Buscar Libros disponibles", "Agregar Libros", "Cambiar Fecha de Devolución", "Salir"};

        // Mostrar el menú y capturar la selección del bibliotecario
        int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);

        // Ejecutar la acción correspondiente según la selección
        switch (funcionSeleccionada){
            case -1:
                System.exit(0); // Salir del sistema
                break;
            case 0:
                buscarAutoresPorNacionalidad();
                break;
            case 1:
                // TODO: Implementar búsqueda de libros disponibles
                break;
            case 2:
                agregarLibroABiblioteca();
                break;
            case 3:
                cambiarFechaDevolucion();  // Llamar a la función que cambia la fecha de devolución
                break;
            case 4:
                System.exit(0); // Salir del sistema
                break;
        }
    }

    private void agregarLibroABiblioteca(){
        // Este método se mantiene igual
        String[] datosLibro = armarModalCargarLibro();
        String titulo, autor, fechaDevolucion;
        titulo = datosLibro[8];
        autor = datosLibro[1];
        fechaDevolucion = datosLibro[2];
        Integer fechaDeConvertidaAInteger = Integer.valueOf(fechaDevolucion);/*convertimos la fecha String a Integer*/
        boolean disponibilidad = true; /*cuando cargamos el libro lo dejamos disponible para que lo pidan*/

        LibroServicio bibliotecario = new LibroServicio();/*creamos instancia de LibroServicio para llamar al metodo que agrega el libro*/
        bibliotecario.agregarLibroABiblioteca(titulo, autor, disponibilidad, fechaDeConvertidaAInteger);
    }

private void cambiarFechaDevolucion() {
    // Solicitamos al bibliotecario el ID del libro y la nueva fecha de devolución
    String libroIdString = JOptionPane.showInputDialog("Ingrese el ID del libro cuyo retorno desea modificar:");
    int libroId = Integer.parseInt(libroIdString); // Convertir el ID a entero
    LibroServicio servicio = new LibroServicio();
    Libro libro = servicio.buscarLibroPorId(libroId);
    // Buscar el libro por su ID
//    Libro libro = new LibroServicio().buscarLibroPorId(libroId);  // Asumiendo que tienes un método para buscar el libro por ID

    if (libro != null) {  // Verificamos si el libro fue encontrado
        // Mostrar todos los datos del libro
        String mensajeLibro = "Datos del libro:\n" +
                "Título: " + libro.getTitulo() + "\n" +
                "Autor: " + libro.getAutor() + "\n" +
                "Disponibilidad: " + (libro.isDisponibilidad() ? "Disponible" : "No disponible") + "\n" +
                "Fecha de devolución actual: " + (libro.getFechaDeDevolucion() == 0 ? "No tiene fecha de devolución" : libro.getFechaDeDevolucion());

        JOptionPane.showMessageDialog(null, mensajeLibro, "Información del Libro", JOptionPane.INFORMATION_MESSAGE);

        // Si el libro está disponible, no tiene sentido cambiar la fecha de devolución
        if (libro.isDisponibilidad()) {
            JOptionPane.showMessageDialog(null, "El libro está disponible y no tiene una fecha de devolución asignada. No se puede cambiar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Solicitar la nueva fecha de devolución si el libro está prestado
            String nuevaFecha = JOptionPane.showInputDialog("Ingrese la nueva fecha de devolución (en formato DDMMAA):");
            int nuevaFechaInt = Integer.parseInt(nuevaFecha); // Convertir la nueva fecha a Integer

            // Llamar al servicio para cambiar la fecha de devolución
//           LibroServicio libroServicio = new LibroServicio();
            servicio.cambiarFechaDeDevolucion(libroId, nuevaFechaInt);  // Llamada al servicio para cambiar la fecha de devolución
        }
    } else {
        // Si no se encuentra el libro con el ID proporcionado
        JOptionPane.showMessageDialog(null, "No se encontró un libro con el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades){
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Bibliotecario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
    }

    private void buscarAutoresPorNacionalidad() {
        // Este método ya estaba definido anteriormente
        String nacionalidad = ingresarNacionalidadAutor();//mostramos msje y capturamos la respuesta del usuario bibliotecario

        if (validarNacionalidad(nacionalidad)) { //validamos que se haya ingresado un texto y que no esté vacío
                List<Autor> listaAutores = buscarAutoresPorNacionalidad(nacionalidad);//llamamos al método que invoca a la función del servicio "AutorServicio" que nos posibilita buscar autores
                mostrarDatosAutoresMismaNacionalidad(listaAutores);
        } else {
            mostrarAdvertencia("La nacionalidad no puede estar vacía.");
        }
    }

    private String ingresarNacionalidadAutor(){
        return JOptionPane.showInputDialog("Ingrese la nacionalidad del autor/escritor");
    }

    private boolean validarNacionalidad(String nacionalidad){
        return nacionalidad != null && !nacionalidad.trim().isEmpty();
    }

    private List<Autor> buscarAutoresPorNacionalidad(String nacionalidad)  {
        AutorServicio autorServicio = new AutorServicio(); //crear un objeto de tipo AutorServicio para poder acceder al método findAutorByNacionalidad
        return  autorServicio.findAutorByNacionalidad(nacionalidad); //llama al método para buscar autor por nacionalidad y le pasa el argumento de la nacionalidad
    }

    private void mostrarDatosAutoresMismaNacionalidad(List<Autor> listaAutores){
        StringBuilder escritoresMismaNacionalidad = new StringBuilder("Autores encontrados:\n");
        for (Autor autor : listaAutores) {
            escritoresMismaNacionalidad.append("Nombre: ").append(autor.getNombre()) //añadimos a la variable "escritoresMismaNacionalidad" los datos personales de aquellos escritores que tienen en común la nacionalidad
                    .append(", Apellido: ").append(autor.getApellido())
                    .append(", Nacionalidad: ").append(autor.getNacionalidad()).append("\n");
        }
        JOptionPane.showMessageDialog(null, escritoresMismaNacionalidad.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE); //mostramos al usuario la lista de autores de determinada nacionalidad
    }

    private void mostrarAdvertencia(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    private String[] armarModalCargarLibro() {
        // Este método debe implementar el modal de carga de libro (se puede dejar en blanco si no se implementa aún)
        return new String[] {"","","010123", "Título del libro", "Autor", "Editor", "Género", "Descripción", "Fecha de Devolución"};
    }
}
