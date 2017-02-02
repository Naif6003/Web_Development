
public class Units {

	
	int id;
	int quantity;
	String units;
	double quantity2;
	String units2;
	


	public Units(int id,int quantity, String units, double quantity2, String units2) {
		this.id = id;
		this.quantity = quantity;
		this.units = units;
		this.quantity2 = quantity2;
		this.units2 = units2;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getQuantity2() {
		return quantity2;
	}
	public void setQuantity2(double quantity2) {
		this.quantity2 = quantity2;
	}
	public String getUnits2() {
		return units2;
	}
	public void setUnits2(String units2) {
		this.units2 = units2;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	
}
