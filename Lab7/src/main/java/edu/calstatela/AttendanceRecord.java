package edu.calstatela;

public class AttendanceRecord {

	
	
	int attendanceId;
	Course course;
	Student student;
	String activityName;
	String status;
	
	public AttendanceRecord(int attendanceId, Course course, Student student, String activityName, String status) {
		
		this.attendanceId = attendanceId;
		this.course = course;
		this.student = student;
		this.activityName = activityName;
		this.status = status;
		
	}
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
