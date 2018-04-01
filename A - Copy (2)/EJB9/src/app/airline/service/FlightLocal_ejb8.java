package app.airline.service;

import javax.ejb.Local;

/**
 * The interface
 */
@Local
public interface FlightLocal_ejb8 {
	
	public Integer getId();

	public void setId(Integer id);

	public String getFrom();

	public void setFrom(String from);

	public String getTo();

	public void setTo(String to);

	public Integer getPrice();

	public void setPrice(Integer price);
	public Integer getNumOfSeats();

	public void setNumOfSeats(Integer numOfSeats);
	public String getAirplanModel();

	public void setAirplanModel(String airplanModel);
	
	public String toStringAll();

}
