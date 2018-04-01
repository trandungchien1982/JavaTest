package app.airline.service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class FlightService
 */
@Stateless(name="flightStateless")
public class FlightServiceStatelessBean implements FlightLocal_ejb8 {

	private Integer id = null;
	private String from = null;
	private String to = null;
	private Integer price = null;
	private Integer numOfSeats = null;
	private String airplanModel = null;

	/**
	 * Default constructor.
	 */
	public FlightServiceStatelessBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(Integer numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public String getAirplanModel() {
		return airplanModel;
	}

	public void setAirplanModel(String airplanModel) {
		this.airplanModel = airplanModel;
	}
	
	public String toString() {
		return "FlightService-STATELESS [id=" + id + ", from=" + from + ", to=" + to + ", price=" + price + ", numOfSeats="
				+ numOfSeats + ", airplanModel=" + airplanModel + "]";
	}

	public String toStringAll() {
		return this.toString();
	}	
}
