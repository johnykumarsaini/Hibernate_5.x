package in.jk.hibernate5.n.plus.one.problem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_technical_skill")
public class TechnicalSkill {
	
	@Id
	@Column(name="skillId")
	private int skillId;
	@Column(name="name")
	private String name;
	
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TechnicalSkill [skillId=" + skillId + ", name=" + name + "]";
	}
	
	
	

}
