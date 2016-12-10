package Objects;

public class Dishes_Object {

	int dish_id;
	String dish_name;
	int dish_menu_id;
	
	
	
	
	
	
	public Dishes_Object(int dish_id, String dish_name, int dish_menu_id) {
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_menu_id = dish_menu_id;
	}
	
	
	
	
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public int getDish_menu_id() {
		return dish_menu_id;
	}
	public void setDish_menu_id(int dish_menu_id) {
		this.dish_menu_id = dish_menu_id;
	}
	
	
}
