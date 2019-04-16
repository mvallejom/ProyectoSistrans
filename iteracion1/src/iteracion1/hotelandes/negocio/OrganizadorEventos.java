package iteracion1.hotelandes.negocio;

import java.awt.List;
import java.util.ArrayList;

public class OrganizadorEventos extends Usuario {

	private Hotel hotel;
	private ArrayList<Convencion> convenciones;
	
	private OrganizadorEventos(Hotel h,String tipoDocumento, long numeroDocumento, String nombre, String correo) {
			super(tipoDocumento, numeroDocumento, nombre, correo);

		this.hotel=h;
		convenciones=new ArrayList<Convencion>();
		
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public ArrayList<Convencion> getConvenciones() {
		return convenciones;
	}
	public void setConvenciones(ArrayList<Convencion> convenciones) {
		this.convenciones = convenciones;
	}
	
	
}
