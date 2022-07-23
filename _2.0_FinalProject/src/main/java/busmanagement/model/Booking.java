package busmanagement.model;
import java.util.Date;

public class Booking extends Trip{
	private int bookingid;
	private int id;
	private int tripid;
	private int busid;
	//private String depature;
	//private String destination;
	///private Date date;
	//private Date time;
	//private double price;
	
	public int getBusid() {
		return busid;
	}

	public void setBusid(int busid) {
		this.busid = busid;
	}

	/*public String getDepature() {
	return depature;
	}

	public void setDepature(String depature) {
		this.depature = depature;
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
	*/
	public Booking(String departure, String destination, Date date, Date time, double price) {
		super(departure,destination,date,time,price);
	}
	
	public Booking () {
		
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	
	
}
