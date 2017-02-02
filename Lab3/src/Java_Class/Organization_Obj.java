package Java_Class;

public class Organization_Obj{
	
	public int id;
	public Category org_Type;
	String org_Name;
	String org_Description;
	String org_President;
	String org_Secrtary;

	
	

	public Organization_Obj(int id, String org_Name, Category org_Type, String org_Description, String org_President,
			String org_Secrtary) {
	
		this.id = id;
		this.org_Name = org_Name;
		this.org_Type = org_Type;
		this.org_Description = org_Description;
		this.org_President = org_President;
		this.org_Secrtary = org_Secrtary;
	}

	public String getOrg_Name() {
		return org_Name;
	}

	public void setOrg_Name(String org_Name) {
		this.org_Name = org_Name;
	}

	public int getId() {
		return id;
	}

	public String getOrg_Description() {
		return org_Description;
	}

	public void setOrg_Description(String org_Description) {
		this.org_Description = org_Description;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getOrg_President() {
		return org_President;
	}

	public void setOrg_President(String org_President) {
		this.org_President = org_President;
	}

	public String getOrg_Secrtary() {
		return org_Secrtary;
	}

	public void setOrg_Secrtary(String org_Secrtary) {
		this.org_Secrtary = org_Secrtary;
	}

	public Category getOrg_Type() {
		return org_Type;
	}

	public void setOrg_Type(Category org_Type) {
		this.org_Type = org_Type;
	}

	
	
}

