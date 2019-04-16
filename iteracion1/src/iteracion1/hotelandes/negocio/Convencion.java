package iteracion1.hotelandes.negocio;

public class Convencion {

	private double cuenta;
	private Hotel hotel;
	private OrganizadorEventos organizador;
	private ReservaHabitacion reserva;
	
	public Convencion(Hotel h, OrganizadorEventos org, ReservaHabitacion reserva) {
		this.hotel=hotel;
		this.organizador=org;
		this.reserva=reserva;
		cuenta=0;
	}
	
	public double getCuenta() {
		return cuenta;
	}
	public void setCuenta(double cuenta) {
		this.cuenta = cuenta;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public OrganizadorEventos getOrganizador() {
		return organizador;
	}
	public void setOrganizador(OrganizadorEventos organizador) {
		this.organizador = organizador;
	}
	public ReservaHabitacion getReserva() {
		return reserva;
	}
	public void setReserva(ReservaHabitacion reserva) {
		this.reserva = reserva;
	}
	
	
}
