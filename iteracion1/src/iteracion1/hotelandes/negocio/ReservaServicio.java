package iteracion1.hotelandes.negocio;


public class ReservaServicio {

	private int id;
	private String fechaEntrada;
	private String fechaSalida;
	private Cliente cliente;
	private Servicio servicio;
	private Hotel h;
	

	public ReservaServicio( String fechaEntrada, String fechaSalida, Cliente cliente,
			Servicio servicio) {
		id=h.getReservasServicio().size()+1;
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
	
	public ReservaServicio( String fechaEntrada, String fechaSalida,
			Servicio servicio) {
		id=h.getReservasServicio().size()+1;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
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

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	

}
