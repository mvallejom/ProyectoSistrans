package iteracion1.hotelandes.negocio;

import java.util.Date;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Empleado extends Usuario
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
	public Empleado(){
		super();
	}

	public Empleado(Hotel hotel) {
		super();
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	//-------------------------------------------
	//
	//----------------------------------------
	public void registrarConsumo(Lugar lugar,Cliente cliente,List<Producto> productos,boolean añadirHabitacion) {
		double totalPagar=0;
		for(Producto p:productos) {
			totalPagar+=p.getCosto();
		}

		if(añadirHabitacion) {
			Consumo m=new Consumo(lugar, cliente.getHabitacion(), productos);
		}
		else {
			cliente.pagar(totalPagar);
		}

	}

	public void generarReserva(Cliente c, Date fecha, int horas,String tipo) {
		ReservaServicio r= new ReservaServicio(fecha, horas, tipo, c);
		Consumo m=new Consumo(c.getHabitacion(), r.generarCosto());
	}
}


