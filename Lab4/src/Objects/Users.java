package Objects;

public class Users {
		
		public int user_Id;
		public String password;
		public String user_Name;
		public Boolean isAdmin;


		public Users(int user_Id, String password, String user_Name, Boolean isAdmin) {
			this.user_Id = user_Id;
			this.password = password;
			this.user_Name = user_Name;
			this.isAdmin = isAdmin;
		}
		
		
		
		public int getUser_Id() {
			return user_Id;
		}
		public void setUser_Id(int user_Id) {
			this.user_Id = user_Id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUser_Name() {
			return user_Name;
		}
		public void setUser_Name(String user_Name) {
			this.user_Name = user_Name;
		}
		public Boolean getIsAdmin() {
			return isAdmin;
		}
		public void setIsAdmin(Boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
		
	
		
		
	}

