package edu.calstatela;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;


@Component
public class DatabaseBean {
	
	public static final String GET_STUDENTS_INFO = "select s.student_id, s.student_name, s.student_cin, c.id from courses c join std_cor sc on c.id = sc.course_id join students s on sc.student_id = s.student_id order by c.id";
	public static final String GET_ONE_STUDENT = "select * from students where student_id = ?";
	public static final String COURSE = "select * from courses";
//	public static final String GET_COURSE = "select c.* , s.student_id, s.student_name, s.student_cin from courses c join std_cor sc on c.id = sc.course_id join students s on sc.student_id = s.student_id order by c.id";
	public static final String GET_COURSE = "select count(sc.student_id), c.* from courses c join std_cor sc where c.id = sc.course_id group by c.id";
	public static final String GET_COURSE_ALONE = "select count(sc.student_id), c.* from courses c join std_cor sc where c.id = sc.course_id and c.id = ? group by c.id";
	public static final String GET_ONE_COURSE = "select * FROM students s join std_cor sc on s.student_id = sc.student_id join courses c where sc.course_id = c.id and c.id = ?";
	public static final String GET_COURSES_INFO = "select * FROM students s left join std_cor sc on s.student_id = sc.student_id join  courses c where sc.course_id = c.id";
	public static final String GET_STUDENTS_IN_COURSE = "select * from students s join std_cor sc where s.student_id = sc.student_id and sc.course_id = ?";
	public static final String GET_COURSE_STUDENT = "select * from students s join attendance a where  a.stu_id = s.student_id and a.course_id = ?";
	public static final String GET_ATTENDANCE_RECORDS = "select * from students s join attendance a where  a.stu_id = s.student_id and a.course_id = ?";
	public static final String COURSE_RECORDS_ATTENDANCE_ACTIVITY = "select * from attendance a join courses c "+ 
																		"join students s on a.stu_id = s.student_id "+
																		"and a.course_id = c.id where a.course_id = ? and a.lab = ?";
	
	
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert insertAttendanceRecords;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertAttendanceRecords = new SimpleJdbcInsert(dataSource).withTableName("attendance")
				.usingGeneratedKeyColumns("lab_num");
	}
	
	
	//GETS LIST OF COURSES AVAILABLE.
	public List<Course> getCourses() {
		List<Course> courses = this.jdbcTemplate.query(GET_COURSE, new CourseMapper());
		return courses;
	}
	
	// GETS LIST OF ALL STUDENTS INFO 
	public List<Student> getStudents() {
		List<Student> students = this.jdbcTemplate.query(GET_STUDENTS_INFO, new StudentMapper());
		return students;
	}
	
	// just to get students with course id
		public List<Student> getStudentsCourse() {
			List<Student> students = this.jdbcTemplate.query(GET_STUDENTS_INFO, new StudentCourseMapper());
			return students;
		}

	// GETS THE ATTENDANCE RECORDS FOR EACH COURSE. CALL BY NUMBER.
	public List<StudentAttendance> getAttendance(int id) {
		List<StudentAttendance> attendance = this.jdbcTemplate.query(GET_ATTENDANCE_RECORDS, new Object[] { id },
				new AttendanceMapper());
		return attendance;
	}
	
	//GETS ATTENDANCE RECORDS TO A SPACIFIC COURSE NUMBER.
	public List<StudentAttendance> getAttendanceCourseActivity(int id, String activity){
		List<StudentAttendance> attendance = this.jdbcTemplate.query(COURSE_RECORDS_ATTENDANCE_ACTIVITY, new Object[] { id , activity}, new AttendanceMapper());
		return attendance;
	}


	// GETS A SINGLE COURSE. CALL BY COURSE NUMBER
			public Course getSingleCourse(int id) {
				Course courses = this.jdbcTemplate.queryForObject(GET_COURSE_ALONE, new Object[] { id },
						new SingleCourseMapper());
				return courses;
			}


	
	// GETS STUDENTS INFO IN EACH SPECIFIC COURSE. CALL BY COURSE NUMBER.
	public List<Student> getCourseStudents(int id){
		List<Student> students = this.jdbcTemplate.query(GET_COURSE_STUDENT, new Object[] {id},
				new StudentMapper());
			return students;
		}
	
	
	// just for trying something
	public Student getCourseStudentsObj(int id){
		Student students = this.jdbcTemplate.queryForObject(GET_COURSE_STUDENT, new Object[] {id},
				new StudentMapper());
			return students;
		}
	
	
	
	
	private static final class StudentMapper implements RowMapper<Student> {
		
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			int studentId = rs.getInt("student_id");
			String studentName = rs.getString("student_name");
			int studentCin = rs.getInt("student_cin");
			return new Student(studentId, studentName , studentCin);
		}
	}
	
	//Just to add the course id number with student
private static final class StudentCourseMapper implements RowMapper<Student> {
		
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			int studentId = rs.getInt("student_id");
			String studentName = rs.getString("student_name");
			int studentCin = rs.getInt("student_cin");
			int courseId = rs.getInt("id");
			return new Student(studentId, studentName , studentCin , courseId);
		}
	}
	
private class SingleCourseMapper implements RowMapper<Course> {
		
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			int courseId = rs.getInt("id");
			String courseName = rs.getString("course_name");
			String courseTimeDay = rs.getString("time_day");
			int courseUnits = rs.getInt("number_units");
			int courseSection = rs.getInt("section");
			String courseRoom = rs.getString("classroom_location");
			String courseInstructor = rs.getString("instructor");
					
			
			List<Student> allStudents = new ArrayList<Student>();
			for(Student stu : listOfStudents()){
				allStudents.add(stu);
			}
						
			List<Student> eachStu =new ArrayList<Student>();
			for(Student student: allStudents){
				if(courseId == student.courseId){
					eachStu.add(student);
				}
			}
		
		return new Course(courseId, courseName , courseTimeDay, courseUnits, courseSection, courseRoom, courseInstructor, eachStu);
	}
}

	private class CourseMapper implements RowMapper<Course> {
		

		
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			int courseId = rs.getInt("id");
			String courseName = rs.getString("course_name");
			String courseTimeDay = rs.getString("time_day");
			int courseUnits = rs.getInt("number_units");
			int courseSection = rs.getInt("section");
			String courseRoom = rs.getString("classroom_location");
			String courseInstructor = rs.getString("instructor");
			
			
			List<Student> allStudents = new ArrayList<Student>();
			for(Student stu : listOfStudents()){
				allStudents.add(stu);
			}
						
			List<Student> eachStu =new ArrayList<Student>();
			for(Student student: allStudents){
				if(courseId == student.courseId){
					eachStu.add(student);
				}
			}

			return new Course(courseId, courseName , courseTimeDay, courseUnits, courseSection, courseRoom, courseInstructor, eachStu);
		}
	}
	
	public List<Student> listOfStudents() {
		List<Student> students = this.jdbcTemplate.query(GET_STUDENTS_INFO, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				int studentId = rs.getInt("student_id");
				String studentName = rs.getString("student_name");
				int studentCin = rs.getInt("student_cin");
				int courseId = rs.getInt("id");
				return new Student(studentId, studentName, studentCin,courseId);
			}
		});
		return students;
	}

	
	
		private static final class AttendanceMapper implements RowMapper<StudentAttendance> {
		
		public StudentAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
			int lab_Number = rs.getInt("lab_num");
			String lab_Name = rs.getString("lab");
			String student_status = rs.getString("stu_status");
			
			int student_Id = rs.getInt("student_id");
			String student_Name = rs.getString("student_name");
			int student_cin = rs.getInt("student_cin");
			
			return new StudentAttendance(lab_Number, lab_Name, student_status , new Student(student_Id, student_Name, student_cin));
		}
	}
		
		
		public int insertattendance(StudentAttendance recordToAdd) {

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("labId", recordToAdd.getLabId());
			parameters.put("labName", recordToAdd.getLabName());
			parameters.put("status", recordToAdd.getStatus());
			parameters.put("student_id", recordToAdd.getStudent().getStudentId());
			parameters.put("student_name", recordToAdd.getStudent().getStudentName());
			parameters.put("student_cin", recordToAdd.getStudent().getStudentCIN());			
			Number newId = insertAttendanceRecords.executeAndReturnKey(parameters);
			return newId.intValue();
		}
		
		
	
	

}
