package in.jk.hibernate5.criteria.tuple.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_beverage")
public class Beverage {
	
	@Id
	@Column(name="beverageId")
	private int beverageId;
	@Column(name="name")
    private String name;
	@Column(name="price")
	private String price;
	
	public int getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(int beverageId) {
		this.beverageId = beverageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Bevarage [beverageId=" + beverageId + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
