package in.jk.hibernate5.onetomany.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_developers_master")
public class Developer {
	
	@Id
	@Column(name="developer_id")
	private int developerId;
	@Column(name="name")
    private String name;
	@Column(name="company")
    private String company;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="developer_id" )
	private List<Language> languages;

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

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Developer [developerId=" + developerId + ", name=" + name + ", company=" + company + ", languages="
				+ languages + "]";
	}
	
	
	

}
