package in.jk.hibernate5.manytoone.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hibernate5_java_developer")
public class JavaDeveloper {
	
	@Id
	@Column(name="java_developer_id")
	private int javaDeveloperId;
	@Column(name="developer_name")
    private String developerName;
	@Column(name="company")
    private String company;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "javaDeveloper")
	List<JavaFramework> javaFramework;
	
	public int getJavaDeveloperId() {
		return javaDeveloperId;
	}
	public void setJavaDeveloperId(int javaDeveloperId) {
		this.javaDeveloperId = javaDeveloperId;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public 	List<JavaFramework> getJavaFramework() {
		return javaFramework;
	}
	public void setJavaFramework(List<JavaFramework> javaFramework) {
		this.javaFramework = javaFramework;
	}
	@Override
	public String toString() {
		return "JavaDeveloper [javaDeveloperId=" + javaDeveloperId + ", developerName=" + developerName + ", company="
				+ company + ", javaFramework=" + javaFramework + "]";
	}
	
	
	
	

}
