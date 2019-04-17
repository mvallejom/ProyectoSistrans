package iteracion1.hotelandes.negocio;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Consumo
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private int id;

	private String fechaConsumo;
	private Convencion convencion;
	
	public String getFechaConsumo() {
		return fechaConsumo;
	}


	public void setFechaConsumo(String fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String lugar;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private double costoTotal;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Habitacion habitacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<Producto> productos;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Consumo(){
		super();
	}
	

	public Consumo( String lugar, Habitacion h, List<Producto> productos,String fecha) {
		this.id = id;
		this.lugar = lugar;
		this.habitacion = h;
		this.productos = productos;
		this.fechaConsumo=fecha;
	}
	
	
	public Consumo(Habitacion habitacion,double costo) {
		
		this.habitacion = habitacion;
		costoTotal=costo;
	}

	public Consumo(Convencion c,double costo) {
		
		this.habitacion = habitacion;
		costoTotal=costo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public double calcularCostoTotal() {
		
		for(Producto p: productos) {
			costoTotal+=p.getCosto();
		}
		return costoTotal;
		
	}

}

