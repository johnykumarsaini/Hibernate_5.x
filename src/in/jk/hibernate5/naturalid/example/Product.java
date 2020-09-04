package in.jk.hibernate5.naturalid.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "hibernate5_product_details_master")
public class Product {

	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "name")
    private String name;
	
	@NaturalId
	@Column(name = "serial_no")
	private int serialNo;
	@Column(name = "price")
    private int price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", serialNo=" + serialNo + ", price=" + price
				+ "]";
	}
	
	
	

}
