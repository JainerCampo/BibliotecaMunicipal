package modelo;

public class Usuario extends Persona {
    private String codigo;
    public Usuario(int id, String nombre, int edad, String codigo) {
        super(id, nombre, edad);
        this.codigo = codigo;
    }
    @Override
    public String descripcion() {
        return super.descripcion() + ", codigo=" + codigo;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
