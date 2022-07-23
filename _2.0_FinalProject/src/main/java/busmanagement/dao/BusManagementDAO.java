package busmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import busmanagement.db.ConnectionManager;
import busmanagement.model.*;
import user.model.User;
import user.model.Admin;

public class BusManagementDAO {
	
	//important
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement statement = null;
	static ResultSet rs = null;
	
	//object
	Admin admin;
	User user;
	String departure, destination, buscompany, drivername, 
	name, password, phoneno, email,
	adminname,adminpassword,adminphoneno,adminemail;
	int busid, tripid, adminid, id;
	double price;
	Date date,time;
	
	//1.0 Get Booking By User Id
	public static Object getBookingById(int id) {
		
		Booking booking = new Booking();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM booking WHERE id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				booking.setBookingid(rs.getInt("bookingid"));
				booking.setId(rs.getInt("id"));
				booking.setTripid(rs.getInt("tripid"));
			}
			else
				return null;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return booking;		
	}
	//End 1.0
	
	
	//TRIP METHODS
	//2.0 Get Trip By User Id
	public static Object getTripByTripId(int tripid) {
		Trip trip = new Trip();
		
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("SELECT * FROM trip WHERE tripid = ?");
			ps.setInt(1, tripid);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				trip.setTripid(rs.getInt("tripid"));
				trip.setAdminid(rs.getInt("adminid"));
				trip.setBusid(rs.getInt("busid"));
				trip.setDeparture(rs.getString("departure"));
				trip.setDestination(rs.getString("destination"));
				trip.setDate(rs.getDate("date"));
				trip.setTime(rs.getTime("time"));
				trip.setPrice(rs.getDouble("price")); 
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return trip;
	}
	//End 2.0
	
	//3.0 Get All Trips
	public static List<Trip> getAllTrip(){
		
		List<Trip> trips = new ArrayList<Trip>();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM trip ");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Trip trip = new Trip();
				trip.setTripid(rs.getInt("tripid"));
				trip.setAdminid(rs.getInt("adminid"));
				trip.setBusid(rs.getInt("busid"));
				trip.setDeparture(rs.getString("departure"));
				trip.setDestination(rs.getString("destination"));
				trip.setDate(rs.getDate("date"));
				trip.setTime(rs.getTime("time"));
				trip.setPrice(rs.getDouble("price"));
				trips.add(trip);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return trips;
	}

	//4.0 Update Trip
	public void UpdateTrip(Trip trip) {
		
		java.util.Date utilDate = trip.getDate();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.util.Date utilTime = trip.getTime();
		java.sql.Time sqlTime = new java.sql.Time(utilTime.getTime());
		
		tripid = trip.getTripid();
		adminid = trip.getAdminid();
		busid = trip.getBusid();
		departure = trip.getDeparture();
		destination = trip.getDestination();
		date = trip.getDate();
		time = trip.getTime();
		price = trip.getPrice();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE `trip` SET `departure`=?,`destination`=?,`date`=?,`time`=?,`price`=? WHERE `tripid`=?");
			ps.setString(1, departure);
			ps.setString(2, destination);
			ps.setDate(3,sqlDate);
			ps.setTime(4,sqlTime);
			ps.setDouble(5, price);
			ps.setInt(6, tripid);
			
			ps.executeUpdate();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//End of 4.0 Update Trip
	
	//5.0 Add Trip
	public void AddTrip(Trip trip, Admin admin, Bus bus) {
		
		java.util.Date utilDate = trip.getDate();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		java.util.Date utilTime = trip.getTime();
		java.sql.Time sqlTime = new java.sql.Time(utilTime.getTime());
		
		adminid = admin.getAdminid();
		busid = bus.getBusid();
		departure = trip.getDeparture();
		destination = trip.getDestination();
		date = trip.getDate();
		time = trip.getTime();
		price = trip.getPrice();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("INSERT INTO `trip`( `adminid`, `busid`, `departure`, `destination`, `date`, `time`, `price`) VALUES (?,?,?,?,?,?,?)");
			
			ps.setInt(1, adminid);
			ps.setInt(2, busid);
			ps.setString(3, departure);
			ps.setString(4, destination);
			ps.setDate(5,sqlDate);
			ps.setTime(6,sqlTime);
			ps.setDouble(7, price);
			
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//5.0 End of Add Trip
	
	
	
	//5.0 Delete Trip
	public void deleteTripByTripId(int tripid) {
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("DELETE FROM trip WHERE tripid = ?");
			ps.setInt(1, tripid);
			
			ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//End of 5.0 Delete Trip
	
	//6.0 Search Trip by departure and destination
	public static List<Trip> searchTrip(String departure, String destination){
		List<Trip> trips = new ArrayList<Trip>();
		
		try {
			//CONNECT TO DB
			con = ConnectionManager.getConnection();
			
			//CREATE STATEMENT
			ps = con.prepareStatement("SELECT *,b.buscompany FROM trip t JOIN bus b ON (t.busid = b.busid)WHERE departure=? AND destination=?");
			ps.setString(1, departure);
			ps.setString(2, destination);
			
			//EXECUTE QUERY
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Trip trip = new Trip();
				trip.setTripid(rs.getInt("tripid"));
				trip.setAdminid(rs.getInt("adminid"));
				trip.setBusid(rs.getInt("busid"));
				trip.setDeparture(rs.getString("departure"));
				trip.setDestination(rs.getString("destination"));
				trip.setDate(rs.getDate("date"));
				trip.setTime(rs.getTime("time"));
				trip.setPrice(rs.getDouble("price"));
				trip.setBuscompany(rs.getString("buscompany"));
				trips.add(trip);
			}
			
			//CLOSE CONNECTION
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}return trips;
		
	}
	
	//7.0 Book Trip
	public void BookTrip(Booking b) {
		id = b.getId();
		tripid = b.getTripid();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("INSERT INTO booking(id,tripid) VALUES(?,?)");
			ps.setInt(1, id);
			ps.setInt(2, tripid);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//8.0 List booking by id
	public static List<Booking> listBookingById(int id){
		List<Booking> booking =new ArrayList<Booking>();
		try {
			//CONNECT TO DB
			con = ConnectionManager.getConnection();
			
			//CREATE STATEMENT
			ps = con.prepareStatement("SELECT * FROM trip JOIN booking USING (tripid) WHERE id=?");
			ps.setInt(1, id);
			
			//EXECUTE QUERY
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String departure = rs.getString("departure");
				String destination = rs.getString("destination");
				Date date = rs.getDate("date");
				Date time = rs.getTime("time");
				Double price = rs.getDouble("price");
				
				Booking b = new Booking(departure,destination,date,time,price);
				b.setBookingid(rs.getInt("bookingid"));
				b.setTripid(rs.getInt("tripid"));
				b.setId(rs.getInt("id"));
				b.setBusid(rs.getInt("busid"));
				
				booking.add(b);
			}
			
			//CLOSE CONNECTION
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}return booking;
	}
	
	
	//End od 6.0 Search Trip by departure and destination
	//-------------------BUS----------------------
	//6.0 Add Bus
	public void addBus(Bus bus) {
		
		busid = bus.getBusid();
		buscompany = bus.getBuscompany();
		drivername = bus.getDrivername();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("INSERT into BUS (busid, buscompany, drivername) VALUES (?,?,?)");
			ps.setInt(1, busid);
			ps.setString(2, buscompany);
			ps.setString(3, drivername);
			
			ps.executeUpdate();
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//End of 6.0 Add Bus
	
	//7.0 Delete Bus
	public void deleteBus(int busid) {
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("DELETE from bus WHERE busid=?");
			ps.setInt(1,busid);
			
			ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//End of 7.0 Delete Bus
	
	//8.0 Get Bus by Bus ID
	public static Object getBusByBusId(int busid) {
		Bus bus = new Bus();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM bus WHERE busid=?");
			ps.setInt(1, busid);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				bus.setBusid(rs.getInt("busid"));
				bus.setBuscompany(rs.getString("buscompany"));
				bus.setDrivername(rs.getString("drivername"));
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
	}
	return bus;
	}
	//Enf of Get Bus by Bus ID
	
	//9.0 Update Bus
	public void UpdateBus(Bus bus) {
		busid = bus.getBusid();
		buscompany = bus.getBuscompany();
		drivername = bus.getDrivername();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE `bus` SET `buscompany`=?,`drivername`=? WHERE `busid`=?");
			
			ps.setString(1,buscompany);
			ps.setString(2, drivername);
			ps.setInt(3, busid);
			ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//End of 9.0 Update Bus
	
	//10.0 Get All Bus
	public static List<Bus> getAllBus(){
		
		List<Bus> buses = new ArrayList<Bus>();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT * FROM bus");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Bus bus = new Bus();
				bus.setBusid(rs.getInt("busid"));
				bus.setBuscompany(rs.getString("buscompany"));
				bus.setDrivername(rs.getString("drivername"));
				buses.add(bus);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return buses;		
	}
	//End of 10.0 Get All Bus
	
	//11.0 Delete Bus By Bus Id
	public void deleteBusByBusId(int busid) {
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("DELETE FROM bus WHERE busid = ?");
			ps.setInt(1, busid);
			
			ps.executeUpdate();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//End of 11.0 Delete Bus By Bus Id

	//Generate Report
		public List<Trip> GenerateReport(int tripid) {
		    List<Trip> trips = new ArrayList<Trip>();
		    try {
		    con = ConnectionManager.getConnection();
		      
		      ps = con.prepareStatement("SELECT , (SELECT COUNT() FROM `booking`WHERE booking.tripid = "+tripid
		      		+ ") AS `joined` FROM `trip` WHERE tripid = " + tripid) ;
		      
		      rs = ps.executeQuery();
		      while (rs.next()) {
		        Trip trip = new Trip();
		        trip.setTripid(rs.getInt("tripid"));
		        trip.setBusid(rs.getInt("busid"));
		        trip.setAdminid(rs.getInt("adminid"));
		        trip.setDeparture(rs.getString("departure"));
		        trip.setDestination(rs.getString("destination"));
		        trip.setDate(rs.getDate("date"));
		        trip.setTime(rs.getTime("time"));
		        //event.setNoOfParticipant(rs.getInt("no_of_participants"));
		        //event.setJoined(rs.getInt("joined"));
		        trips.add(trip);
		      }
		      con.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return trips;
		  }
		//End of Generate Report
		
		//Get booking 
		
		public List<User> GetBookings(int eventid) {
		    List<User> users = new ArrayList<User>();
		    try {
		    	con = ConnectionManager.getConnection();	      
		      ps = con.prepareStatement("SELECT `users`.`id`, `users`.`name`, `users`.`phoneno`, `users`.`email` FROM `booking` "
		      		+ "INNER JOIN `trip` ON `trip`.`tripid`= `booking`.`tripid` "
		      		+ "INNER JOIN `users` ON `users`.`id` = `booking`.`id` WHERE `booking`.`tripid` = "+ tripid);
		      
		      rs = ps.executeQuery();
		      while (rs.next()) {
		        User user = new User();
		        user.setId(rs.getInt("id"));
		        user.setName(rs.getString("name"));
		        user.setPhoneno(rs.getString("phoneno"));
		        user.setEmail(rs.getString("email"));
		        
		        //event.setNoOfParticipant(rs.getInt("no_of_participants"));
		        //event.setJoined(rs.getInt("joined"));
		        users.add(user);
		      
		      }
		      con.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return users;
		  }
		
		//Get booking
	
	//-------------------BUS----------------------
	
}
