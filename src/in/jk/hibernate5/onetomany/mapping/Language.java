package in.jk.hibernate5.onetomany.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Langauges_list")
public class Language {
	
	@Id
	@Column(name="language_id")
	private int languageId;
	@Column(name="name")
    private String name;
	
	
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
