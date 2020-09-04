package in.jk.hibernate5.criteria.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_person")
public class Person {
	
	@Id
	@Column(name="person_id")
	private int personId;
	@Column(name="person_name")
    private String personName;
	@Column(name="mobile_number")
    private String mobileNumber;
	@Column(name="gender")
    private String gender;
	
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ",";
	}
	
	
	
	

}
