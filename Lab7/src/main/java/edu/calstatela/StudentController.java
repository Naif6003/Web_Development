package edu.calstatela;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	DatabaseBean databaseBean;
	
	
	//return all countries
		@RequestMapping("/students")
		public List<Student> getStudents() {
			return databaseBean.getStudents();
		}
		
		
		/*
		 * //return single employee using path variable. For example /employee/2
		@RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
		public Course getCourse(@PathVariable("id") int id) {
			return databaseBean.getSingleCourse(id);
		}
		 */
		
		// get students in specific class
		@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
		public List<Student> getStudetnsInCourse(@PathVariable("id") int id) {
			return databaseBean.getCourseStudents(id);
		}
		
}
