package in.jk.hibernate5.criteria.join.query;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_passenger")
public class Passenger {
	
	@Id
	@Column(name="passenger_id")
	private int passengerId;
	@Column(name="name")
    private String name;
	@Column(name="age")
    private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passenger_id")
	private Ticket ticket;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
