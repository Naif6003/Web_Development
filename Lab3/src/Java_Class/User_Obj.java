package Java_Class;


public class User_Obj{
	
	
	public int user_Id;
	public String password;
	String user_Name;
	int user_CIN;
	String user_Gender;
	public Boolean isPresident;
	public Boolean isAdmin;
	
	
	
public User_Obj(int user_Id, String user_Name, int user_CIN, String user_Gender, Boolean isPresident, Boolean isAdmin) {
		
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.user_CIN = user_CIN;
		this.user_Gender = user_Gender;
		this.isPresident = isPresident;
		this.isAdmin = isAdmin;
	}
	
	
	
public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public Boolean getIsPresident() {
		return isPresident;
	}

	public void setIsPresident(Boolean isPresident) {
		this.isPresident = isPresident;
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

	public String getUser_Gender() {
		return user_Gender;
	}

	public void setUser_Gender(String user_Gender) {
		this.user_Gender = user_Gender;
	}
	
	
	
	
}