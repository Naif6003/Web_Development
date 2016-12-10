package edu.calstatela;

public class StudentAttendance {
	
	int labId;
	String labName;
	String status;
	Student student;
	public StudentAttendance(int labId, String labName, String status, Student student) {
		this.labId = labId;
		this.labName = labName;
		this.status = status;
		this.student = student;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
