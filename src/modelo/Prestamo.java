package modelo;

public class Prestamo {
    private int id;
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Prestamo(int id, Libro libro, Usuario usuario, String fechaPrestamo, String fechaDevolucion) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String descripcion() {
        return "Prestamo { id=" + id +
                ", libro=" + libro.getTitulo() +
                ", usuario=" + usuario.getNombre() +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion + " }";
    }
}
