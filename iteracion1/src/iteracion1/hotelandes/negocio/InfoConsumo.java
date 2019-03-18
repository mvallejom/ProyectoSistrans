package iteracion1.hotelandes.negocio;

public class InfoConsumo {
private int cantidad;
private Producto producto;
private Servicio servicio;



public InfoConsumo(int cantidad, Producto producto, Servicio servicio) {
	super();
	this.cantidad = cantidad;
	this.producto = producto;
	this.servicio = servicio;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public Producto getProducto() {
	return producto;
}
public void setProducto(Producto producto) {
	this.producto = producto;
}
public Servicio getServicio() {
	return servicio;
}
public void setServicio(Servicio servicio) {
	this.servicio = servicio;
}


}
