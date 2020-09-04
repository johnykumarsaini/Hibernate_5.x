package in.jk.hibernate5.hqlquery.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_javadeveloper_list")
public class JavaDeveloper {
	
	@Id
	@Column(name = "developer_id")
	private int developerId;
	@Column(name = "name")
    private String name;
	@Column(name = "company")
    private String company;
	
	
	
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
	
	@Override
	public String toString() {
		return "Employee [developerId=" + developerId + ", name=" + name + ", company=" + company + "]";
	}
	
	

}
