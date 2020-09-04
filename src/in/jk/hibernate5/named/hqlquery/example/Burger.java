package in.jk.hibernate5.named.hqlquery.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_burger")
@NamedQuery(name = "burgerQuery",query = "FROM Burger where burgerId=:burgerId")
public class Burger {
	
	@Id
	@Column(name="burger_id")
	private int burgerId;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private int price;
	@Column(name="resturent_location")
	private String resturentLocation;
	public int getBurgerId() {
		return burgerId;
	}
	public void setBurgerId(int burgerId) {
		this.burgerId = burgerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getResturentLocation() {
		return resturentLocation;
	}
	public void setResturentLocation(String resturentLocation) {
		this.resturentLocation = resturentLocation;
	}
	@Override
	public String toString() {
		return "Burger [burgerId=" + burgerId + ", name=" + name + ", price=" + price + ", resturentLocation="
				+ resturentLocation + "]";
	}
	
	
	
	

}
