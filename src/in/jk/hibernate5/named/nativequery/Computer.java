package in.jk.hibernate5.named.nativequery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_computer")
@NamedNativeQuery(name = "findComputer", query = "Select *  from hibernate5_computer")
public class Computer {
	
	@Id
	@Column(name="computer_id")
	private int computerId;
	@Column(name="computer_name")
    private String coumpterName;
	@Column(name="price")
    private int price;
	public int getComputerId() {
		return computerId;
	}
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	public String getCoumpterName() {
		return coumpterName;
	}
	public void setCoumpterName(String coumpterName) {
		this.coumpterName = coumpterName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Computer [computerId=" + computerId + ", coumpterName=" + coumpterName + ", price=" + price + "]";
	}
	
	
	
	

}
