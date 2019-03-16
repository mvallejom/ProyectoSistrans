package iteracion1.hotelandes.negocio;

import java.util.Date;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Recepcionista extends Usuario
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	private Hotel hotel;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Recepcionista(){
		super();
	}

	public Recepcionista(Hotel hotel) {
		super();
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void checkIn(String tipoDocumento, long numeroDocumento, String nombre, String correo,boolean reserva, ReservaHabitacion reservaHabitacion,TipoHabitacion tipo, int capacidad) {
		Cliente c=null;
		Habitacion hab=null;
		if(reserva) {
			hab=hotel.buscarHabitacion(reservaHabitacion.getTipo(), reservaHabitacion.getNumeroPersonas());
			c =new Cliente(tipoDocumento, numeroDocumento, nombre, correo, hab);
		}
		else {
			hab=hotel.buscarHabitacion(tipo, capacidad);
			c =new Cliente(tipoDocumento, numeroDocumento, nombre, correo, hab);
		}
		hotel.adicionarCliente(c);
	}
	
	
	public boolean checkOut(Cliente c) throws Exception {
		
		boolean pazYsalvo=false;
		double totalPagar=c.getHabitacion().getCuenta();
		c.pagar(totalPagar);
		if(c.getHabitacion().getCuenta()>0&& !prestamosDevueltos(c)) {
			throw new Exception();
		}
		else {
			pazYsalvo=true;
		}
		return pazYsalvo;
		
	}
	
	public boolean prestamosDevueltos(Cliente c) {
		boolean resp=true;
		for(Prestamo p: c.getPrestamos()) {
			if(!p.isDevuelto()){
				resp=false;
			}
			
		}
		return resp;
	}
	
	
	public void generarReserva(Cliente c, Date fecha, int horas,String tipo) {
		ReservaServicio r= new ReservaServicio(fecha, horas, tipo, c);
		Consumo m=new Consumo(c.getHabitacion(), r.generarCosto());
	}


}

