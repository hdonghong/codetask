package pers.hdh.service;

import org.springframework.stereotype.Service;
import pers.hdh.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
