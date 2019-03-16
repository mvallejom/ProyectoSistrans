package iteracion1.hotelandes.negocio;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Producto
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private String nombre;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private double costo;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private List<Consumo> consumosHabitacion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Producto(){
		super();
	}
	

	public Producto(String nombre, double costo, List<Consumo> consumosHabitacion) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.consumosHabitacion = consumosHabitacion;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<Consumo> getConsumosHabitacion() {
		return consumosHabitacion;
	}

	public void setConsumosHabitacion(List<Consumo> consumosHabitacion) {
		this.consumosHabitacion = consumosHabitacion;
	}

}

