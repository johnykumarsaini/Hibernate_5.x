package in.jk.hibernate5.defualtcolumn.value.example;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="hibernate5_institute_student")
@DynamicInsert
public class Student {
	
	@Id
	@Column(name="student_id")
	private int studentId;
	@Column(name="name")
	private String name;
	@Column(name="course")
	@ColumnDefault(value = "'Btech'")
	private String course;
	@Column(name="institute")
	@ColumnDefault(value = "'MIT'")
	private String institute;
	@Column(name="admission_date")
	private Date admissionDate;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", course=" + course + ", institute=" + institute
				+ ", admissionDate=" + admissionDate + "]";
	}
	
	

}
