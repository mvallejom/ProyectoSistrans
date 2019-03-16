package iteracion1.hotelandes.negocio;

public class Servicio {
private double  costo;
private String nombre;
private ReservaServicio reserva;
private double costoAdicional;
private int disponibles;
private int duracionHora;



public Servicio( double costo,double costoAdicional,int disponibles,String nombre,int duracion) {
	this.costo = costo;
	this.costoAdicional=costoAdicional;
	this.disponibles=disponibles;
	this.nombre=nombre;
	this.duracionHora=duracion;
}


public int getDuracionHora() {
	return duracionHora;
}


public void setDuracionHora(int duracionHora) {
	this.duracionHora = duracionHora;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public int getDisponibles() {
	return disponibles;
}


public void setDisponibles(int disponibles) {
	this.disponibles = disponibles;
}


public double getCosto() {
	return costo;
}

public void setCosto(double costo) {
	this.costo = costo;
}

public ReservaServicio getReserva() {
	return reserva;
}

public void setReserva(ReservaServicio reserva) {
	this.reserva = reserva;
}


public double getCostoAdicional() {
	return costoAdicional;
}


public void setCostoAdicional(double costoAdicional) {
	this.costoAdicional = costoAdicional;
}

public void menosDisponibles() throws Exception {
	if(disponibles>0) {
		disponibles--;
	}
	else {
		throw new Exception();
	}
}

}
