package com.imooc.mvcdemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.mvcdemo.model.Course;

public class Test2Interceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("执行到了afterCompletion2方法");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("执行到了postHandle2方法");
		Course course = (Course)arg3.getModelMap().get("course");
		//System.out.println("postHandle方法: " + ReflectionToStringBuilder.toString(course));
		course.setTeacher("PostHandler教师");
		arg3.addObject(course);
		arg3.setViewName("admin/file");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("执行到了preHandle2方法");
		System.out.println(arg2.getClass().getName());
		HandlerMethod hm = (HandlerMethod)arg2;
		//System.out.println(hm.getMethod().getName());
		return true;
	}

}
