package busmanagement.model;

import java.util.Date;

public class Trip {
	private int tripid;
	private int adminid;
	private int busid;
	private String departure;
	private String destination;
	private Date date;
	private Date time;
	private double price;
	private String buscompany;
	
	public Trip () {
		
	}
	
	public Trip(String departure, String destination, Date date, Date time, double price) {
		this.departure = departure;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.price = price;
	}
	
	
	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public int getBusid() {
		return busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBuscompany() {
		return buscompany;
	}

	public void setBuscompany(String buscompany) {
		this.buscompany = buscompany;
	}
	
	
	
}
