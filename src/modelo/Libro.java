package modelo;

import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private int paginas;
    private int ejemplares;
    private int ejemplaresDisponibles;
    private ArrayList<Autor> autores;

    public Libro(int id, String titulo, int paginas, int ejemplares, int ejemplaresDisponibles) {
        this.id = id;
        this.titulo = titulo;
        this.autores = new ArrayList<>();
        this.paginas = paginas;
        this.ejemplares = ejemplares;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public boolean agregarAutor(Autor autor) {
            for (Autor autor1 : autores) {
                if (autor1.equals(autor)) {
                    return false;
                }
            }
        autores.add(autor);
        return true;
    }

    public boolean eliminarAutor(Autor autor) {
        for (Autor autor1 : autores) {
                if (autor1.equals(autor)) {
                    autores.remove(autor);
                    return true;                            
                }
            }
        return false;
    }

    public int cantidadDeAutores() {
        return autores.size();
    }

    public String descripcion(){
        String resultado = "";
        for (Autor autor : autores) {
                resultado += autor.descripcion() + "\n";
            }
        return "Libro { id=" + id +
                ", título= " + titulo + "\n" +
                ", páginas=" + paginas + "\n" +
                ", ejemplares=" + ejemplares + "\n" +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles + "\n" +
                ", autores=" + resultado + " }";          
    }
    public void disminuirEjemplaresDisponibles() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
        }
    }
    public void aumentarEjemplaresDisponibles() {    
            ejemplaresDisponibles++;   
    }
    public void aumentarEjemplares(int cantidad) {
        if (cantidad > 0) {
            ejemplares += cantidad;
            ejemplaresDisponibles += cantidad;
        }
    }   
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

}
