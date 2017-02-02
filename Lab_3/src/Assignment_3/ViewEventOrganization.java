package Assignment_3;


public class ViewEventOrganization{
	
	String org_Type;
	ViewUser org_President;
	ViewUser org_Secrtary;

	
	public ViewEventOrganization(String type, ViewUser president, ViewUser secretary){
		
		this.org_Type = type;
		this.org_President = president;
		this.org_Secrtary = secretary;
	}

	public String getOrg_Type() {
		return org_Type;
	}

	public void setOrg_Type(String org_Type) {
		this.org_Type = org_Type;
	}

	public ViewUser getOrg_President() {
		return org_President;
	}

	public void setOrg_President(ViewUser org_President) {
		this.org_President = org_President;
	}

	public ViewUser getOrg_Secrtary() {
		return org_Secrtary;
	}

	public void setOrg_Secrtary(ViewUser org_Secrtary) {
		this.org_Secrtary = org_Secrtary;
	}
	
}

