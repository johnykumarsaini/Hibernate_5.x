package in.jk.hibernate5.manytoone.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_java_framework")
public class JavaFramework {
	
	@Id
	@Column(name="framework_id")
	private int frameworkId;
	@Column(name="name")
    private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "developer_id")
	private JavaDeveloper javaDeveloper;

	public int getFrameworkId() {
		return frameworkId;
	}

	public void setFrameworkId(int frameworkId) {
		this.frameworkId = frameworkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JavaDeveloper getJavaDeveloper() {
		return javaDeveloper;
	}

	public void setJavaDeveloper(JavaDeveloper javaDeveloper) {
		this.javaDeveloper = javaDeveloper;
	}

	@Override
	public String toString() {
		return "JavaFramework [frameworkId=" + frameworkId + ", name=" + name + ", javaDeveloper=" + javaDeveloper
				+ "]";
	}
	
	
	

}
