package modelo;

public class Multa {
	private int id;
	private double monto;
	private String fecha; // formato YYYY-MM-DD

	public Multa(int id, double monto, String fecha) {
		this.id = id;
		this.monto = monto;
		this.fecha = fecha;		
	}

	// getters y setters
	public int getId() { 
        return id; 
    }
	public void setId(int id) { 
        this.id = id; 
    }
	public double getMonto() { 
        return monto; 
    }
	public void setMonto(double monto) { 
        this.monto = monto; 
    }
	public String getFecha() { 
        return fecha; 
    }
	public void setFecha(String fecha) { 
        this.fecha = fecha; 
    }

    public String descripcion() {
        return "multa { id=" + id +
                ", monto=" + monto +
                ", fecha=" + fecha + " }";
    }      
}
