package controlador;

import java.util.Scanner;

import modelo.Autor;
import modelo.Biblioteca;
import modelo.Libro;
import modelo.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");

        int opcion;

        do {

            System.out.println("\n========== SISTEMA DE BIBLIOTECA ==========");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Agregar autor");
            System.out.println("4. Asignar autor a libro");
            System.out.println("5. Buscar libro");
            System.out.println("6. Buscar usuario");
            System.out.println("7. Prestar libro");
            System.out.println("8. Devolver libro");
            System.out.println("9. Mostrar libros");
            System.out.println("10. Mostrar usuarios");
            System.out.println("11. Mostrar autores");
            System.out.println("12. Mostrar préstamos");
            System.out.println("13. Salir");
            System.out.print("Opción: ");
            System.out.println();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    // Agregar libro
                    agregarLibro(biblioteca, scanner);
                    break;

                case 2:

                    // Agregar usuario
                    agregarUsuario(biblioteca, scanner);
                    break;

                case 3:
                    // Agregar autor
                    agregarAutor(biblioteca, scanner);
                    break;

                case 4:
                    // Asignar autor a un libro
                    asignarAutorALibro(biblioteca, scanner);
                    break;

                case 5:
                    // Buscar libro
                    mostrarLibro(biblioteca, scanner);
                    break;

                case 6:
                    // Buscar usuario
                    mostrarUsuario(biblioteca, scanner);
                    break;

                case 7:
                    // Prestar libro
                    prestarLibro(biblioteca, scanner);
                    break;

                case 8:
                    // Devolver libro
                    devolverLibro(biblioteca, scanner);
                    break;

                case 9:
                    // Mostrar libros
                    mostrarLibros(biblioteca);
                    break;

                case 10:
                    // Mostrar usuarios
                    mostrarUsuarios(biblioteca);
                    break;

                case 11:
                    // Mostrar autores
                    mostrarAutores(biblioteca);
                    break;

                case 12:
                    // Mostrar préstamos
                    System.out.println(biblioteca.mostrarPrestamos());
                    break;

                case 13:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 13);

        scanner.close();
    }

    //metodo agregar libro
    public static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el número de páginas: ");
        int paginas = scanner.nextInt();
        System.out.print("Ingrese el número de ejemplares: ");
        int ejemplares = scanner.nextInt();
        System.out.print("Ingrese el número de ejemplares disponibles: ");
        int ejemplaresDisponibles = scanner.nextInt();
        System.out.println();
        if (biblioteca.agregarLibro(new Libro(id, titulo, paginas, ejemplares, ejemplaresDisponibles))) {
            System.out.println("Libro agregado exitosamente.");
        } else {
            System.out.println("El libro ya existe en la biblioteca.");
        }
    }

    // metodo mostrar libro
    public static void mostrarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro a buscar: ");
        String titulo = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(titulo);
        if (libro != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libro.descripcion());
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }

    }

    //metodo mostrar libros
    public static void mostrarLibros(Biblioteca biblioteca) {
        String resultado = biblioteca.mostrarLibros();
        if (resultado.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
        } else {
            System.out.println("Libros registrados en la biblioteca:");
            System.out.println(resultado);
        }
    }

    //metodo agregar usuario
    public static void agregarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el id del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el edad del usuario: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el codigo del usuario: ");
        String codigo = scanner.nextLine();
        if (biblioteca.agregarUsuario(new Usuario(id, nombre, edad, codigo ))) {
            System.out.println("Usuario agregado exitosamente.");
        } else {
            System.out.println("El usuario ya existe en la biblioteca.");
        }
    }

    // metodo mostrar usuario
    public static void mostrarUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el código del usuario a buscar: ");
        String codigo = scanner.nextLine();
        Usuario usuario = biblioteca.buscarUsuario(codigo);
        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            System.out.println(usuario.descripcion());
        } else {
            System.out.println("El usuario no se encuentra en la biblioteca.");
        }
    }

    //metodo mostrar usuarios
    public static void mostrarUsuarios(Biblioteca biblioteca) { 
        String resultado = biblioteca.mostrarUsuarios();
        if (resultado.isEmpty()) {
            System.out.println("No hay usuarios registrados en la biblioteca.");
        } else {
            System.out.println("Usuarios registrados en la biblioteca:");
            System.out.println(resultado);
        }
    }

    //metodo agregar autor
    public static void agregarAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el ID del autor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el nombre del autor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del autor: ");
        int edad = scanner.nextInt();
        
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la nacionalidad del autor: ");
        String nacionalidad = scanner.nextLine();

        if (biblioteca.agregarAutor(new Autor(id, nombre, edad, nacionalidad))) {
            System.out.println("Autor agregado exitosamente.");
        } else {
            System.out.println("El autor ya existe en la biblioteca.");
        }
    }

    // metodo mostrar autores
    public static void mostrarAutores(Biblioteca biblioteca) {
        String resultado = biblioteca.mostrarAutores();
        if (resultado.isEmpty()) {
            System.out.println("No hay autores registrados en la biblioteca.");
        } else {
            System.out.println("Autores registrados en la biblioteca:");
            System.out.println(resultado);
        }
    }

    //metodo asignar autor a libro
    public static void asignarAutorALibro (Biblioteca biblioteca, Scanner scanner){
        System.out.println("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        if (biblioteca.asignarAutorALibro(titulo, nombreAutor)) {
            System.out.println("Autor asignado al libro exitosamente.");
        } else {
            System.out.println("No se pudo asignar el autor al libro. Verifique que el libro y el autor existan.");
        }   
    }

    //metodo prestar libro
    public static void prestarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el título del libro a prestar: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el código del usuario que va a prestar el libro: ");
        String codigoUsuario = scanner.nextLine();
        System.out.println("Ingrese la fecha de préstamo (formato: dd/MM/yyyy): ");
        String fechaPrestamo = scanner.nextLine(); 
        System.out.println("Ingrese la fecha de devolución (formato: dd/MM/yyyy): ");
        String fechaDevolucion = scanner.nextLine(); 
        String resultado = biblioteca.prestarLibro(titulo, codigoUsuario, fechaPrestamo, fechaDevolucion);
        System.out.println(resultado);
    }

    // metodo devolver libro
    public static void devolverLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el título del libro a devolver: ");
        String titulo = scanner.nextLine();

        System.out.println("Ingrese el código del usuario que va a devolver el libro: ");
        String codigoUsuario = scanner.nextLine();
        
        if (biblioteca.devolverLibro(titulo, codigoUsuario)) {
            System.out.println("Devolución realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la devolución. Verifique que el libro y el usuario existan.");
        }
    }
    
}
