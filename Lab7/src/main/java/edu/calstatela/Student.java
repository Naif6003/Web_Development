package edu.calstatela;


public class Student {

	int studentId;
	String studentName;
	int studentCIN;
	int courseId;
	
public Student(int studentId, String studentName, int studentCIN) {
		
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCIN = studentCIN;
		
	}



	
	public Student(int studentId, String studentName, int studentCIN, int courseId) {
	this.studentId = studentId;
	this.studentName = studentName;
	this.studentCIN = studentCIN;
	this.courseId = courseId;
}




	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentCIN() {
		return studentCIN;
	}
	public void setStudentCIN(int studentCIN) {
		this.studentCIN = studentCIN;
	}
	
	
	
	
	
}
