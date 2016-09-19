package com.imooc.mvcdemo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.mvcdemo.model.Course;
import com.imooc.mvcdemo.model.User;
import com.imooc.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/imooc")
public class HelloMvcController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/mvc")
	//host:8080/hello/mvc
	public String helloMvc() {
		return "home";
	}
	
	@RequestMapping(value="/course", method=RequestMethod.GET)
	public String displayCourse(@RequestParam("courseId") Integer courseId, Model model) {
		System.out.println("controller.displayCourse");
		Course course = courseService.getCourse(courseId);
		model.addAttribute(course);
		System.out.println("controller.displayCourse");
		return "course";
	}
	
	@RequestMapping(value="/course2/{courseId}", method=RequestMethod.GET)
	public String displayCourse2(@PathVariable("courseId") Integer courseId, Model model) {
		//System.out.println("controller.displayCourse");
		Course course = courseService.getCourse(courseId);
		model.addAttribute(course);
		//System.out.println("controller.displayCourse");
		return "course";
	}
	
	@RequestMapping(value="/course3/{courseId}", method=RequestMethod.GET)
	public @ResponseBody Course getCourseInJson(@PathVariable("courseId") Integer courseId) {
		System.out.println("controller.getCourseInJson");
		return courseService.getCourse(courseId);		
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
	public String createCourse() {
		return "admin/edit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveCourse(Integer courseId, String courseName, String teacher) {
		
		System.out.println(courseName + "  " + teacher);
		//System.out.println(ReflectionToStringBuilder.toString(course));
		
		//return "redirect:course2/"+course.getCourseId();
		return "redirect:course2/"+courseId;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String userlogin(String username, String password, HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println(username + "  " + password);
		//System.out.println(ReflectionToStringBuilder.toString(course));
		
		if ((username=="123") && (password=="123")) {
			User user = new User();
			req.getSession().setAttribute("user", user);
		}
		
		//return "redirect:course2/"+course.getCourseId();
		return "forward:admin?add";
	}
	
	@RequestMapping(value="/upload")
	public String showUploadPage() {
		return "admin/file";
	} 
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
		
		if (!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis() + file.getOriginalFilename()));
		}
		
		return "success";
	} 
	
	
}
