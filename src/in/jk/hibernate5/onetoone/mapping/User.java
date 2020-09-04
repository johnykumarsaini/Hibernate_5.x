package in.jk.hibernate5.onetoone.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_user")
public class User {
	
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	
	
	
	

}
