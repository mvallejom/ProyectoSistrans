package iteracion1.hotelandes.negocio;

import java.util.Date;

public class ReservaServicio {

	private Date fecha;
	private int horas; 
	private double costo;
	private String nombreServicio;
	private Cliente cliente;
	private Servicio servicio;
	


	public ReservaServicio(Date fecha, int horas,String nombreServicio,Cliente cliente) {

		this.fecha = fecha;
		this.horas = horas;
		this.nombreServicio=nombreServicio;
		this.cliente=cliente;
		try {
			servicio.menosDisponibles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getnombreServicio() {
		return nombreServicio;
	}

	public void setnombreServicio(String tipo) {
		this.nombreServicio = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int duracion) {
		this.horas = duracion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double generarCosto() {
		costo=(horas*servicio.getCosto())+servicio.getCostoAdicional();
		return costo;
	}

}
