package iteracion1.hotelandes.negocio;

import java.util.Date;

public class ReservaServicio {

	private int id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Cliente cliente;
	private Servicio servicio;
	

	public ReservaServicio( Date fechaEntrada, Date fechaSalida, Cliente cliente,
			Servicio servicio) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cliente = cliente;
		this.servicio = servicio;
		try {
			servicio.menosDisponibles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	

}
