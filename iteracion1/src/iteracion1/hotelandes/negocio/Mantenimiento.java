package iteracion1.hotelandes.negocio;

import java.util.List;
import java.util.ArrayList;

public class Mantenimiento {

	private int id;
	private Hotel hotel;
	private String fechaComienzo;
	private String fechaTerminacion;
	private List<Servicio> servicio;
	private List<Habitacion> habitacion;
	
	public Mantenimiento(String fechaComienzo, String fechaFin,List<Servicio> servicios , List<Habitacion> habitaciones) {
		this.id=hotel.getMantenimientos().size()+1;
		this.fechaComienzo= fechaComienzo;
		this.fechaTerminacion=fechaTerminacion;
		this.servicio=servicios;
		this.habitacion=habitaciones;
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

	public List<Servicio> getServicio() {
		return servicio;
	}

	public void setServicio(List<Servicio> servicio) {
		this.servicio = servicio;
	}

	public List<Habitacion> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
}
