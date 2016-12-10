package edu.calstatela;

import java.util.List;

public class Course {

	int id;
	String courseName;
	String timeDay;
	int numberOfUnits;
	int section;
	String classLocation;
	String instructor;
	List<Student> std;
	
	
	
	
	
	public Course(int id, String courseName, String timeDay, int numberOfUnits, int section, String classLocation,
			String instructor) {
		this.id = id;
		this.courseName = courseName;
		this.timeDay = timeDay;
		this.numberOfUnits = numberOfUnits;
		this.section = section;
		this.classLocation = classLocation;
		this.instructor = instructor;
	}
	public Course(int id, String courseName, String timeDay, int numberOfUnits, int section, String classLocation,
			String instructor, List<Student> std) {
		this.id = id;
		this.courseName = courseName;
		this.timeDay = timeDay;
		this.numberOfUnits = numberOfUnits;
		this.section = section;
		this.classLocation = classLocation;
		this.instructor = instructor;
		this.std = std;
	}
	public Course(int id, String courseName, String timeDay, int numberOfUnits, int section, String classLocation,
			String instructor, Student student) {
		
		this.id = id;
		this.courseName = courseName;
		this.timeDay = timeDay;
		this.numberOfUnits = numberOfUnits;
		this.section = section;
		this.classLocation = classLocation;
		this.instructor = instructor;
	}
	public List<Student> getStd() {
		return std;
	}
	public void setStd(List<Student> std) {
		this.std = std;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTimeDay() {
		return timeDay;
	}
	public void setTimeDay(String timeDay) {
		this.timeDay = timeDay;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String getClassLocation() {
		return classLocation;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	
	
	
	
	
	
	
}
