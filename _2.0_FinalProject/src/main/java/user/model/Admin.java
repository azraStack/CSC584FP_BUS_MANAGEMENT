package user.model;

//import java.util.Date;

public class Admin {
	private int adminid;
	private String adminname;
	private String adminpassword;
	private String adminphoneno;
	private String adminemail;
	private boolean valid;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public String getAdminphoneno() {
		return adminphoneno;
	}
	public void setAdminphoneno(String adminphoneno) {
		this.adminphoneno = adminphoneno;
	}
	public String getAdminemail() {
		return adminemail;
	}
	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
