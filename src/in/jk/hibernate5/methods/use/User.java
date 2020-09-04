package in.jk.hibernate5.methods.use;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_user_list")
public class User {
	
	@Id
	@Column(name="user_id")
	private int userId;
	@Column(name="name")
	private String name;
	@Column(name="email_id")
	private String emailId;
	@Column(name="contact_number")
	private String contactNumber;
	
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", contactNumber=" + contactNumber
				+ "]";
	}
	
	

}
