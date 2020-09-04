package in.jk.hibernate5.batch.processing;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_movie_ticket")
public class MovieTicket {
	
	@Id
	@Column(name="ticket_id")
	private int ticketId;
	@Column(name="movie_name")
	private String movieName;
	@Column(name="movie_show_time")
	private Date movieShowTime;
	@Column(name="price")
	private int price;
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieShowTime() {
		return movieShowTime;
	}
	public void setMovieShowTime(Date movieShowTime) {
		this.movieShowTime = movieShowTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MovieTicket [ticketId=" + ticketId + ", movieName=" + movieName + ", movieShowTime=" + movieShowTime
				+ ", price=" + price + "]";
	}
	
	

}
