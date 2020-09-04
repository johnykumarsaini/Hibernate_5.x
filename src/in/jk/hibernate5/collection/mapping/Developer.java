package in.jk.hibernate5.collection.mapping;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_developer")
public class Developer {
	
	@Id
	@Column(name="developer_id")
	private int developerId;
	@Column(name="name")
    private String name;
	@Column(name="company")
    private String company;
	
	@ElementCollection
	@JoinTable(name = "languages")
	private Collection<Language> languages =new HashSet<Language>();

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

	public Collection<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Collection<Language> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Developer [developerId=" + developerId + ", name=" + name + ", company=" + company + ", languages="
				+ languages + "]";
	}
	
	
	

}
