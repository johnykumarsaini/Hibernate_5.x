package in.jk.hibernate5.manytomany.mapping;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_employee_master")
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "name")
    private String name;
	@Column(name = "company")
    private String company;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_address_mapping" ,joinColumns = @JoinColumn(name="emp_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
	List<Address> addresses;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", company=" + company + ", addresses=" + addresses
				+ "]";
	}
	
	
	

}
