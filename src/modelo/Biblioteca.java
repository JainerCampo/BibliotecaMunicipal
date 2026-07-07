package modelo;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Autor> autores;   
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.autores = new ArrayList<>();       
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //====== metodos de la biblioteca ======

    // metodo agregar libro
    public boolean agregarLibro(Libro libro) {
        for (Libro libro1 : libros) {
            if(libro1.getTitulo().equalsIgnoreCase(libro.getTitulo())) {
                return false; // El libro ya existe, no se agrega
            }
        }
        libros.add(libro);
        return true;
    }

    //metodo agregar usuario
    public boolean agregarUsuario(Usuario usuario) {
        for (Usuario usuario1 : usuarios) {
            if(usuario1.getCodigo().equalsIgnoreCase(usuario.getCodigo())) {
                return false; // El usuario ya existe, no se agrega
            }
        }
        usuarios.add(usuario);
        return true;
    }

    //metodo mostrar usuarios
    public String mostrarUsuarios() {
        String resultado = "";
        for (Usuario usuario : usuarios) {
            resultado += usuario.descripcion() + "\n";
        }
        return resultado;
    }

    //metodo agregar autor
    public boolean agregarAutor(Autor autor) {
        for (Autor autor1 : autores) {
            if(autor1.getNombre().equalsIgnoreCase(autor.getNombre())) {
                return false; // El autor ya existe, no se agrega
            }
        }
        autores.add(autor);
        return true;
    }

    //metodo mostrar autor
    public String mostrarAutor(String nombreAutor) {
        String resultado = "";
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                resultado += autor.descripcion() + "\n";
            }
        }
        return resultado;
    }

    //buscar autor
    public Autor buscarAutor(String nombreAutor) {
        for (Autor autor : autores) {
            if (autor.getNombre().equalsIgnoreCase(nombreAutor)) {
                return autor;
            }
        }
        return null; // El autor no existe
    }

    //metodo mostrar autores
    public String mostrarAutores() {
        String resultado = "";
        for (Autor autor : autores) {
            resultado += autor.descripcion() + "\n";
        }
        return resultado;
    }

    //metodo asignar autor a libro
    public boolean asignarAutorALibro(String tituloLibro, String nombreAutor) {    
        Libro libro = buscarLibro(tituloLibro);
        if (libro == null) {
            return false; // El libro no existe
        }
        Autor autor = buscarAutor(nombreAutor);
        if (autor == null) {
            return false; // El autor no existe
        }
        return libro.agregarAutor(autor);
    }

    // metodo buscar libro
    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    //metodo buscar usuario
    public Usuario buscarUsuario(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }
    
    // metodo prestar libro
   public String prestarLibro( String tituloLibro, String codigoUsuario, String fechaPrestamo, String fechaDevolucion){       
        // verificar si el libro existe 
        Libro libro = buscarLibro(tituloLibro);
        if (libro == null) {
                return "Libro no encontrado"; 
            }
        // verificar si hay ejemplares disponibles
        if (libro.getEjemplaresDisponibles() <= 0) {
                return "No hay ejemplares disponibles";
            }   
        // verificar si el usuario existe
        Usuario usuario = buscarUsuario(codigoUsuario);
            if (usuario == null) {
                return "Usuario no encontrado"; 
            }
        Prestamo prestamo = new Prestamo(libro, usuario, fechaPrestamo, fechaDevolucion);
        libro.disminuirEjemplaresDisponibles();    
        prestamos.add(prestamo);
        return "Préstamo realizado con éxito";
    }

    //metodo mostrar libros
    public String mostrarLibros() {
        String resultado = "";
        for (Libro libro : libros) {
            resultado += libro.descripcion() + "\n";
        }
        return resultado;
    }

    //metodo devolver libro
    public boolean devolverLibro(String tituloLibro, String codigoUsuario) {
        Prestamo prestamoEncontrado = null;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equals(tituloLibro) && prestamo.getUsuario().getCodigo().equals(codigoUsuario)) {
                prestamo.getLibro().aumentarEjemplaresDisponibles();
                prestamoEncontrado = prestamo;
                break; // Salir del bucle una vez que se haya encontrado y procesado el préstamo
            }
        }
        if (prestamoEncontrado != null) {
            prestamos.remove(prestamoEncontrado);
            return true;
        }
        return false;
    }   

    // metodo mostrar prestamos
    public String mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            return "No hay préstamos registrados en la biblioteca.";
        }
        String resultado = "";
        for (Prestamo prestamo : prestamos) {
            resultado += prestamo.descripcion() + "\n";
        }
        return resultado;
    }
    
    
}