package Objects;

public class Ingredients {

	
	int ingredient_id;
	String ingredient_name;
	double ingredient_price;
	
	
	
	public Ingredients(int ingredient_id, String ingredient_name, double ingredient_price) {
		
		this.ingredient_id = ingredient_id;
		this.ingredient_name = ingredient_name;
		this.ingredient_price = ingredient_price;
	}
	
	
	
	public int getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public double getIngredient_price() {
		return ingredient_price;
	}
	public void setIngredient_price(double ingredient_price) {
		this.ingredient_price = ingredient_price;
	}
	
	
	
	
	
	
}
