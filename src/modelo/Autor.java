package modelo;

public class Autor extends Persona {

    private String nacionalidad;

    public Autor(int id, String nombre, int edad, String nacionalidad) {
        super(id, nombre, edad);
        this.nacionalidad = nacionalidad;
    }

    // Getters y Setters
    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + ", nacionalidad=" + nacionalidad;
    }
}
