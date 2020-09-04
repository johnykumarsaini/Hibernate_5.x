package in.jk.hibernate5.n.plus.one.problem;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_javaprogramers")
public class JavaProgramer {
	
	@Id
	@Column(name="programer_id")
	private int progrmerId;
	@Column(name="name")
	private String name;
	@Column(name="company")
	private String comapny;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "programer_id")
	private List<TechnicalSkill> technicalSkill;

	
	public int getProgrmerId() {
		return progrmerId;
	}


	public void setProgrmerId(int progrmerId) {
		this.progrmerId = progrmerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getComapny() {
		return comapny;
	}


	public void setComapny(String comapny) {
		this.comapny = comapny;
	}


	public List<TechnicalSkill> getTechnicalSkill() {
		return technicalSkill;
	}


	public void setTechnicalSkill(List<TechnicalSkill> technicalSkill) {
		this.technicalSkill = technicalSkill;
	}


	@Override
	public String toString() {
		return "JavaProgramer [progrmerId=" + progrmerId + ", name=" + name + ", comapny=" + comapny
				+ ", technicalSkill=" + "" + "]";
	}
	
	

}
