package in.jk.hibernate5.criteria.join.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_ticket")
public class Ticket {
	
	@Id
	@Column(name="ticket_id")
	private int ticketId;
	@Column(name="start_station")
    private String startStation;
	@Column(name="destination_station")
    private String destinationStation;
	@Column(name="price")
    private int price;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", startStation=" + startStation + ", destinationStation="
				+ destinationStation + ", price=" + price + "]";
	}
	
	
	

}
