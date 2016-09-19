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
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String userlogin(String username, String password, HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println(username + "  " + password);
		//System.out.println(ReflectionToStringBuilder.toString(course));
		
		if ((username.equals("123")) && (password.equals("123"))) {
			System.out.println("login success");
			User user = new User();
			req.getSession().setAttribute("user", user);
		}
		
		//return "redirect:course2/"+course.getCourseId();
		return "forward:/imooc/upload";
	}	
}
