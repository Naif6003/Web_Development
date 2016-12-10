package edu.calstatela;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

		@Autowired
		DatabaseBean databaseBean;
		
		
//		//return all countries
//			@RequestMapping(value="/attendanceRecords/{id}", method=RequestMethod.GET)
//			public List<StudentAttendance> getStudents() {
//				return databaseBean.getAttendance();
//			}
			
			
			/*
			 * //return single employee using path variable. For example /employee/2
			@RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
			public Course getCourse(@PathVariable("id") int id) {
				return databaseBean.getSingleCourse(id);
			}
			 */
			
			// get students in specific class
			@RequestMapping(value="/attendanceRecords/{id}", method=RequestMethod.GET)
			public List<StudentAttendance> getStudetnsInCourse(@PathVariable("id") int id) {
				return databaseBean.getAttendance(id);
				}
			
			
			// get students in specific class
			@RequestMapping(value="/attendanceRecordCourseActivity/{id}/{activity}", method=RequestMethod.GET)
			public List<StudentAttendance> getAttendanceCourseActivity(@PathVariable("id") int id,@PathVariable("activity") String activity) {
				return databaseBean.getAttendanceCourseActivity(id,activity);
				}
			
	

}
