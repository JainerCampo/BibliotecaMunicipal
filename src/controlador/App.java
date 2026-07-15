package controlador;

import java.util.Scanner;

import modelo.Autor;
import modelo.Biblioteca;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;
import modelo.Multa;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");

        int opcion;

        do {

            System.out.println("\n========== SISTEMA DE BIBLIOTECA ==========");
            System.out.println();
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println();
            System.out.println("6. Agregar usuario");
            System.out.println("7. Buscar usuario");
            System.out.println("8. Mostrar usuarios");
            System.out.println();
            System.out.println("9. Agregar autor");
            System.out.println("10. Mostrar autores");
            System.out.println("11. Buscar autor");
            System.out.println("12. Asignar autor a libro");
            System.out.println();
            System.out.println("13. Mostrar préstamos");
            System.out.println("14. Buscar préstamo");
            System.out.println("15. Asignar préstamo a usuario");
            System.out.println();
            System.out.println("16. Crear multa");
            System.out.println("17. Asignar multa a usuario");
            System.out.println("18. Mostrar multas");
            System.out.println("19. Eliminar multa");
            System.out.println("20. Salir");
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

                    // Mostrar libros
                    mostrarLibros(biblioteca);
                    break;

                case 3:
                    // Buscar libro
                    mostrarLibro(biblioteca, scanner);                    
                    break;

                case 4:
                    // Prestar libro
                    prestarLibro(biblioteca, scanner);
                    break;

                case 5:
                    // devolver libro
                    devolverLibro(biblioteca, scanner);        
                    break;

                case 6:
                    // Agregar usuario
                    agregarUsuario(biblioteca, scanner);
                    break;

                case 7:
                    // Buscar usuario
                    mostrarUsuario(biblioteca, scanner);
                    break;

                case 8:
                    // Mostrar usuarios
                    mostrarUsuarios(biblioteca);
                    break;

                case 9:
                    // Agregar autor
                    agregarAutor(biblioteca, scanner);                    
                    break;

                case 10:
                    // Mostrar autores
                    mostrarAutores(biblioteca);
                    break;

                case 11:
                    // Buscar autor
                    buscarAutor(biblioteca, scanner);
                    break;

                case 12:
                    // Asignar autor a libro
                    asignarAutorALibro(biblioteca, scanner);
                    break;
                case 13: 
                    // Mostrar prestamos
                    mostrarPrestamos(biblioteca);
                    break;
                case 14: 
                    // Buscar prestamo
                    buscarPrestamo(biblioteca, scanner);
                    break;
                case 15:
                    // Asignar prestamo a usuario
                    asignarPrestamoAUsuario(biblioteca, scanner);
                    break;
                case 16:
                    // Crear multa
                    crearMulta(biblioteca, scanner);
                    break;
                case 17:
                    // Asignar multa a usuario
                    asignarMultaUsuario(biblioteca, scanner);
                    break;
                case 18:
                    // Mostrar multas
                    mostrarMultas(biblioteca);
                    break;
                case 19:
                    // Eliminar multa
                    eliminarMulta(biblioteca, scanner);
                    break;
                case 20:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 20);

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

    //metodo buscar autor
    public static void buscarAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el nombre del autor a buscar: ");
        String nombreAutor = scanner.nextLine();

        Autor autor = biblioteca.buscarAutor(nombreAutor);
        if (autor != null) {
            System.out.println("Autor encontrado:");
            System.out.println(autor.descripcion());
        } else {
            System.out.println("El autor no se encuentra en la biblioteca.");
        }
    }

    //metodo asignar autor a libro
    public static void asignarAutorALibro (Biblioteca biblioteca, Scanner scanner){
        System.out.println("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(titulo);
        if (libro == null) {
            System.out.println("El libro no existe.");
            return;
        }

        System.out.println("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        Autor autor = biblioteca.buscarAutor(nombreAutor);
        if (autor == null) {
            System.out.println("El autor no existe.");
            return;
        }

        biblioteca.asignarAutorALibro(libro, autor);
        System.out.println("Autor asignado al libro exitosamente.");
           
    }

    //metodo prestar libro
    public static void prestarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el ID del préstamo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpiar el buffer

        System.out.println("Ingrese el título del libro a prestar: ");
        String titulo = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(titulo);
        if (libro == null) {
            System.out.println("El libro no existe.");
            return;
        }

        System.out.println("Ingrese el código del usuario que va a prestar el libro: ");
        String codigoUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("El usuario no existe.");
            return;
        }

        System.out.println("Ingrese la fecha de préstamo (formato: dd/MM/yyyy): ");
        String fechaPrestamo = scanner.nextLine();

        System.out.println("Ingrese la fecha de devolución (formato: dd/MM/yyyy): ");
        String fechaDevolucion = scanner.nextLine();

        boolean resultado = biblioteca.prestarLibro(id, libro, usuario, fechaPrestamo, fechaDevolucion);

        if (resultado) {
            System.out.println("Préstamo realizado con éxito.");
        } 
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

    //metodo mostrar prestamos
    public static void mostrarPrestamos(Biblioteca biblioteca) {
        String resultado = biblioteca.mostrarPrestamos();
        if (resultado.isEmpty()) {
            System.out.println("No hay préstamos registrados en la biblioteca.");
        } else {
            System.out.println("Préstamos registrados en la biblioteca:");
            System.out.println(resultado);
        }
    }

    // metodo buscar prestamo
    public static void buscarPrestamo(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el Id del préstamo a buscar: ");
        int idPrestamo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Prestamo prestamo = biblioteca.buscarPrestamo(idPrestamo);
        if (prestamo != null) {
            System.out.println(prestamo.descripcion());
        } else {
            System.out.println("El préstamo no se encuentra en la biblioteca.");
        }
    }

    //metodo asignar prestamo a usuario
    public static void asignarPrestamoAUsuario(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el ID del préstamo: ");
        int idPrestamo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Prestamo prestamo = biblioteca.buscarPrestamo(idPrestamo);
        if (prestamo == null) {
            System.out.println("El préstamo no existe.");
            return;
        }

        System.out.println("Ingrese el código del usuario al que se le asignará el préstamo: ");
        String codigoUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("El usuario no existe.");
            return;
        }

        biblioteca.asignarPrestamoAUsuario(prestamo, usuario);
        System.out.println("Préstamo asignado exitosamente.");        
        
    }

    //metodo crear multa
    public static void crearMulta(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el ID de la multa: ");
        int idMulta = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Multa multa = biblioteca.buscarMulta(idMulta);
        if (multa == null) {
            System.out.println("La Multa ya exite");
            return;
        }

        System.out.println("Ingrese el monto de la multa: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la fecha de la multa (formato: dd/MM/yyyy): ");
        String fecha = scanner.nextLine();

        biblioteca.agregarMulta(new Multa(idMulta, monto, fecha)); 
        System.out.println("Multa creada exitosamente.");       
    }

    // metodo asignar multa a usuario
    public static void asignarMultaUsuario(Biblioteca biblioteca, Scanner scanner){
        System.out.println("Digite el ID del la multa: ");
        int idMulta = scanner.nextInt();
        scanner.nextLine();
        Multa multa = biblioteca.buscarMulta(idMulta);
        if (multa == null) {
            System.out.println("La multa no existe");
            return;
        }
        System.out.println("Digite el codigo del usuario: ");
        String codUsuario = scanner.nextLine();
        Usuario usuario = biblioteca.buscarUsuario(codUsuario);
        if (usuario == null) {
            System.out.println("El usuario no existe");
        }

        usuario.agregarMulta(multa);
        System.out.println("Multa agregada a usuario exitosamente");
    }

    //metodo mostrar multas
    public static void mostrarMultas(Biblioteca biblioteca) {
        String resultado = biblioteca.mostrarMultas();
        if (resultado.isEmpty()) {
            System.out.println("No hay multas registradas en la biblioteca.");
        } else {
            System.out.println("Multas registradas en la biblioteca:");
            System.out.println(resultado);
        }
    }

    //metodo eliminar multa
    public static void eliminarMulta(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Ingrese el ID de la multa a eliminar: ");
        int idMulta = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean resultado = biblioteca.eliminarMulta(idMulta);
        if (resultado) {
            System.out.println("Multa eliminada exitosamente.");
        } else {
            System.out.println("No se pudo eliminar la multa. Verifique que la multa exista.");
        }
    }
}
