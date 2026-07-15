package modelo;

import java.util.ArrayList;

public class Usuario extends Persona {
    private String codigo;
    private ArrayList<Prestamo> prestamos; // Lista de préstamos asociados al usuario
    private ArrayList<Multa> multas; // Lista de multas asociadas al usuario
    
    public Usuario(int id, String nombre, int edad, String codigo) {
        super(id, nombre, edad);
        this.codigo = codigo;
        this.prestamos = new ArrayList<>();
        this.multas = new ArrayList<>();
    }
    @Override
    public String descripcion() {
        return super.descripcion() 
        + ", codigo=" + codigo 
        + ", prestamos=" + prestamos.size()
        + ", multas=" + multas.size();
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void agregarMulta(Multa multa) {
        multas.add(multa);
    }


}
