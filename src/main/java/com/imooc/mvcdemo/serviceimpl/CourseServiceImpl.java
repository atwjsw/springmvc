package com.imooc.mvcdemo.serviceimpl;

import org.springframework.stereotype.Service;

import com.imooc.mvcdemo.model.Course;
import com.imooc.mvcdemo.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Override
	public Course getCourse(int courseId) {
		System.out.println("CourseServiceImpl.getCourse");
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName("Spring MVC");
		course.setTeacher("Authur");
		return course;
	}

}
