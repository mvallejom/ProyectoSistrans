package iteracion1.hotelandes.negocio;

import java.util.Date;
import java.util.List;

public class Servicio {
	private String nombre;
	private Date horaApertura;
	private Date horaCierre;
	private String descripcion;
	private Hotel hotel;
	private double  costo;
	private int capacidad;
	private List<Producto>productos;
	private Lugar lugar;
	private List<ReservaServicio> reservas;
	private InfoConsumo infoconsumo ;
	private int disponible;
	private long id;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Servicio(String nombre, Date horaApertura, Date horaCierre, String descripcion, Hotel hotel, double costo,
			int capacidad, Lugar lugar) {
		super();
		this.nombre = nombre;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.descripcion = descripcion;
		this.hotel = hotel;
		this.costo = costo;
		this.capacidad = capacidad;
		this.lugar = lugar;
	}


	public List<ReservaServicio> getReservas() {
		return reservas;
	}






	public void setReservas(List<ReservaServicio> reservas) {
		this.reservas = reservas;
	}






	public InfoConsumo getInfoconsumo() {
		return infoconsumo;
	}






	public void setInfoconsumo(InfoConsumo infoconsumo) {
		this.infoconsumo = infoconsumo;
	}






	public int getDisponible() {
		return disponible;
	}






	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}













	public Date getHoraApertura() {
		return horaApertura;
	}


	public void setHoraApertura(Date horaApertura) {
		this.horaApertura = horaApertura;
	}


	public Date getHoraCierre() {
		return horaCierre;
	}


	public void setHoraCierre(Date horaCierre) {
		this.horaCierre = horaCierre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}



	public void menosDisponibles() throws Exception {
		capacidad--;
	}
}
