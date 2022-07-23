package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import busmanagement.db.ConnectionManager;
import user.model.Admin;
import user.model.User;

public class UserDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	//User
	private static int id;
	private String name;
	private static String password;
	private String phoneno;
	static String email;
	//Admin
	private static int adminid;
	private String adminname;
	private static String adminpassword;
	private String adminphoneno;
	private String adminemail;
	
	//	Users Methods
	//1.0 User Login
	public static User loginUser(User u) {
		email = u.getEmail();
		password = u.getPassword();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setValid(true);
			}
			else {
				u.setValid(false);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	//End of 1.0 User Login
	
	//2.0 Get User by ID
	public static Object getUserById(int id) {
		User user = new User();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				//user.setPassword(rs.getString("password"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));				
				
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//End of 2.0 Get User by ID
	
	//3.0 Update User
	public void UpdateUser(User u) {
		
		id = u.getId();
		name = u.getName();
		phoneno = u.getPhoneno();
		email = u.getEmail();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE `users` SET `name`=?,`phoneno`=?,`email`=? WHERE `id`=?");
			
			ps.setString(1, name);
			ps.setString(2, phoneno);
			ps.setString(3, email);
			ps.setInt(4, id);
			ps.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//4.0 Register User
	public void registerUser(User u) {
		name = u.getName();
		password = u.getPassword();
		phoneno = u.getPhoneno();
		email = u.getEmail();
		
		try {
			//CONNECT TO DB
			con = ConnectionManager.getConnection();

			//CREATE STATEMENT
			ps = con.prepareStatement("INSERT INTO `users`(`name`, `password`, `phoneno`, `email`) VALUES (?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,password);
			ps.setString(3,phoneno);
			ps.setString(4,email);

			//EXECUTE QUERY
			ps.executeUpdate();

			//CLOSE CONNECTION
			con.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//5.0 Delete User
	public void deleteUser (int id) {
  		try {
  			//call getConnection method
  			con = ConnectionManager.getConnection();
  			
  			//create statement
  			ps = con.prepareStatement("DELETE FROM users WHERE id=?");
  			ps.setInt(1, id);
  			
  			//execute query
  			ps.executeUpdate();
  			
  			//close connection
  			con.close();
  			
  		}catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
	
//	Admin Methods
	//1.0 Admin Login
	public static Admin loginAdmin(Admin a) {
		adminid = a.getAdminid();
		adminpassword = a.getAdminpassword();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin WHERE adminid = ? AND adminpassword = ?");
			ps.setInt(1, adminid);
			ps.setString(2, adminpassword);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				a.setAdminid(rs.getInt("adminid"));
				a.setValid(true);
			}
			else {
				a.setValid(false);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	//End of 1.0 Admin Login
	
	//2.0 Get Admin by its id
	public static Object getAdminByAdminid(int adminid) {
		Admin admin = new Admin();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin WHERE adminid = ?");
			ps.setInt(1, adminid);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setAdminphoneno(rs.getString("adminphoneno"));
				admin.setAdminemail(rs.getString("adminemail"));
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
	//End of 2.0 Get Admin by its id
	
	//3.0 Update Admin Profile
	public void UpdateAdmin(Admin admin) {
		
		adminid = admin.getAdminid();
		adminname = admin.getAdminname();
		adminphoneno = admin.getAdminphoneno();
		adminemail = admin.getAdminemail();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE `admin` SET `adminname`=?,`adminphoneno`=?,`adminemail`=? WHERE `adminid`=?");
			
			ps.setString(1, adminname);
			ps.setString(2, adminphoneno);
			ps.setString(3, adminemail);
			ps.setInt(4, adminid);
			ps.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//End of 3.0 Update Admin Profile
	
	//4.0 Get All Admin
	public static List<Admin> getAllAdmin(){
		
		List<Admin> admins = new ArrayList<Admin>();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM admin");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setAdminphoneno(rs.getString("adminphoneno"));
				admin.setAdminemail(rs.getString("adminemail"));
				admins.add(admin);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}
}
