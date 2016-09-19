<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="mainForm" action="/imooc/save" method="post">
		<div>
			<span>Course ID:</span><input type="text" id="courseId" name="courseId"></input>
		</div>
		<div>
			<span>Course Name:</span><input type="text" id="courseName" name="courseName"></input>
		</div>
		<div>
			<span>Teacher:</span><input type="text" id="teacher" name="teacher"></input>
		</div>	
		<div>
			<input type="submit" id="btnPass" name="submit" value="submit"></input>
		</div>	
	</form>		 
</body>
</html>