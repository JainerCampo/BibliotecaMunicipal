package modelo;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;
    private ArrayList<Autor> autores;
    private ArrayList<Multa> multas;   
    
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.multas = new ArrayList<>();
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
    public void asignarAutorALibro(Libro libro, Autor autor) {    
        libro.agregarAutor(autor);
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
    
    // metodo asignar prestamo a usuario
   public boolean prestarLibro( int id, Libro libro, Usuario usuario, String fechaPrestamo, String fechaDevolucion){       

        Prestamo prestamo = new Prestamo(id, libro, usuario, fechaPrestamo, fechaDevolucion);
        libro.disminuirEjemplaresDisponibles();    
        prestamos.add(prestamo);
        return true;
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
    
    //metodo buscar prestamo
    public Prestamo buscarPrestamo(int idPrestamo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == idPrestamo) {
                return prestamo;
            }
        }
        return null; // El préstamo no existe
    }  

    //metodo asignar prestamo a usuario
    public void asignarPrestamoAUsuario(Prestamo prestamo, Usuario usuario) {
        usuario.agregarPrestamo(prestamo);
    }

    // metodo mostrar multas
    public String mostrarMultas() {
        if (multas.isEmpty()) {
            return "No hay multas registradas en la biblioteca.";
        }
        String resultado = "";
        for (Multa multa : multas) {
            resultado += multa.descripcion() + "\n";
        }
        return resultado;
    }

    // metodo agregar multa
    public void agregarMulta(Multa multa) {
        multas.add(multa);
    }
    
    // metodo asignar multa a usuario
    public static void asignarMultaUsuario(Multa multa, Usuario usuario){
        usuario.agregarMulta(multa);
    }

    //metodo buscar multa
    public Multa buscarMulta(int id) {
        for (Multa multa : multas) {
            if (multa.getId() == id) {
                return multa;
            }
        }
        return null; // La multa no existe
    }

    //metodo eliminar multa
    public boolean eliminarMulta(int id) {
        Multa multaEncontrada = buscarMulta(id);
        if (multaEncontrada != null) {
            multas.remove(multaEncontrada);
            return true; // Multa eliminada exitosamente
        }
        return false; // La multa no existe
    }
}