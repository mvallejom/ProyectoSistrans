package iteracion1.hotelandes.negocio;

import java.util.List;
import java.util.ArrayList;

public class Convencion {

	private String name;
	private double cuenta;
	private Hotel hotel;
	private OrganizadorEventos organizador;
	private List<ReservaHabitacion> reservas;
	private List<ReservaServicio> servicios;
	private List<Consumo> consumos;
	
	public Convencion(Hotel h,String nombre, OrganizadorEventos org, List<ReservaHabitacion> reserva, List<ReservaServicio> servicios) {
		this.hotel=hotel;
		this.organizador=org;
		this.reservas=reserva;
		this.servicios=servicios;
		this.name=nombre;
		this.consumos=new ArrayList<Consumo>();
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

	public List<ReservaHabitacion> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaHabitacion> reservas) {
		this.reservas = reservas;
	}

	public List<ReservaServicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<ReservaServicio> servicios) {
		this.servicios = servicios;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}
	
	public double calcularCuenta() {
		for (ReservaHabitacion h :reservas) {
			cuenta+=h.getHabitacion().getCuenta();
		}
		for(ReservaServicio s: servicios) {
			cuenta+=s.getServicio().getCosto();
		}
		for(Consumo c:consumos) {
			cuenta+=c.calcularCostoTotal();
		}
		return cuenta;
	}
	
	public void pagar() {
		setCuenta(0);
	}
	
}
