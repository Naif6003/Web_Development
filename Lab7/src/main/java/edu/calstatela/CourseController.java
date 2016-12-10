package edu.calstatela;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CourseController {

	
		@Autowired
		DatabaseBean databaseBean;
		
		
		
		//return all courses
		@RequestMapping("/courses")
		public List<Course> getCourse() {
			return databaseBean.getCourses();
		}
		
		
	
		//return single employee using path variable. For example /employee/2
		@RequestMapping(value="/courses/{id}", method=RequestMethod.GET)
		public Course getCourse(@PathVariable("id") int id) {
			return databaseBean.getSingleCourse(id);
		}
		
		
		
	
//		@RequestMapping(value="/courses", method = RequestMethod.POST)
//		public Map<String, String> AddEmployee(@RequestBody Course employeeToAdd) {
//			
//			int id = databaseBean.insertEmployees(employeeToAdd);
//			
//			//simple JSON object with single property
//			return Collections.singletonMap("id", id+"");
//		}
		
		
}
