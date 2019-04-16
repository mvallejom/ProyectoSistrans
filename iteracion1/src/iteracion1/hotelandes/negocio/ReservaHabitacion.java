package iteracion1.hotelandes.negocio;


import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class ReservaHabitacion
{
	private String fechaEntrada;

	private String fechaSalida;

	private int numeroPersonas;

	private Habitacion habitacion;
	
	private List<Cliente> clientes;

	public ReservaHabitacion(){
		super();
	}

	public ReservaHabitacion(String fechaEntrada, String fechaSalida, int numeroPersonas, Habitacion habitacion, List<Cliente> cliente) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.numeroPersonas = numeroPersonas;
		this.habitacion = habitacion;
		this.clientes = cliente;
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

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
