package in.jk.hibernate5.groupbyandhaving.clause;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_software_developer")
public class SoftwareDeveloper {
	
	@Id
	@Column(name = "developer_id")
	private int developerId;
	@Column(name = "name")
    private String name;
	@Column(name = "company")
    private String company;
	@Column(name = "salary")
	private int salary;
	
	
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "SoftwareDeveloper [developerId=" + developerId + ", name=" + name + ", company=" + company + ", salary="
				+ salary + "]";
	}
	
	

}
