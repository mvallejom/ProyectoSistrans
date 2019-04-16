package iteracion1.hotelandes.negocio;

public class Mantenimiento {

	private String fechaComienzo;
	private String fechaTerminacion;
	private Servicio servicio;
	private Habitacion habitacion;
	
	public Mantenimiento(String fechaComienzo, String fechaFin,Servicio s , Habitacion h) {
		this.fechaComienzo= fechaComienzo;
		this.fechaTerminacion=fechaTerminacion;
		this.servicio=s;
		this.habitacion=h;
	}

	public String getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(String fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public String getFechaTerminacion() {
		return fechaTerminacion;
	}

	public void setFechaTerminacion(String fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
}
