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
		System.out.println("ִ�е���afterCompletion2����");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("ִ�е���postHandle2����");
		Course course = (Course)arg3.getModelMap().get("course");
		//System.out.println("postHandle����: " + ReflectionToStringBuilder.toString(course));
		course.setTeacher("PostHandler��ʦ");
		arg3.addObject(course);
		arg3.setViewName("admin/file");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("ִ�е���preHandle2����");
		System.out.println(arg2.getClass().getName());
		HandlerMethod hm = (HandlerMethod)arg2;
		//System.out.println(hm.getMethod().getName());
		return true;
	}

}
