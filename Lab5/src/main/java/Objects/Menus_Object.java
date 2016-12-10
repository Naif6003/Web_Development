package Objects;

public class Menus_Object {
	
	int menu_id;
	String menu_name;
	String menu_description;
	
	
	public Menus_Object(int menu_id, String menu_name, String menu_description) {

		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_description = menu_description;
	}
	
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_description() {
		return menu_description;
	}
	public void setMenu_description(String menu_description) {
		this.menu_description = menu_description;
	}
	
	

}
