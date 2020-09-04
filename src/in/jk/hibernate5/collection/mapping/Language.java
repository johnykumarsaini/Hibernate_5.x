package in.jk.hibernate5.collection.mapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Language {
	
	
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
