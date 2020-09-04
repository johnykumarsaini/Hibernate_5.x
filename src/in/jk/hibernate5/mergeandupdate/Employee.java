package in.jk.hibernate5.mergeandupdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_google_employee")
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	private int empId;
	@Column(name = "name")
    private String name;
	@Column(name = "company")
    private String company;
	@Column(name = "designation")
    private String designation;
	
	
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
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", company=" + company + ", designation=" + designation
				+ "]";
	}
	

}
