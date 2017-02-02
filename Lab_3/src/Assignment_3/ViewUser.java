package Assignment_3;


public class ViewUser{
	
	String user_Name;
	int user_CIN;
	char user_Gender;
	
	public  ViewUser(String name, int cin, char gender){
		this.user_Name = name;
		this.user_CIN = cin;
		this.user_Gender = gender;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public int getUser_CIN() {
		return user_CIN;
	}

	public void setUser_CIN(int user_CIN) {
		this.user_CIN = user_CIN;
	}

	public char getUser_Gender() {
		return user_Gender;
	}

	public void setUser_Gender(char user_Gender) {
		this.user_Gender = user_Gender;
	}
	
	
	
	
}