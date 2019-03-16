package iteracion1.hotelandes.negocio;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Lavanderia
{
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
	
	private List<String> prendas;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Lavanderia(){
		super();
	}

	public Lavanderia(double costo, List<String> prendas) {
		super();
		this.costo = costo;
		this.prendas = prendas;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<String> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<String> prendas) {
		this.prendas = prendas;
	}

}

