package in.jk.hibernate5.onetoone.mapping.hql.join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hibernate5_course")
public class Course {
	
	@Id
	@Column(name="courseId")
	private int courseId;
	@Column(name="courseName")
	private String courseName;
	@Column(name="branch")
	private String branch;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", branch=" + branch + "]";
	}
	
	
	

}
