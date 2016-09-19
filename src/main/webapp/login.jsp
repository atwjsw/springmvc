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
	<form name="mainForm" action="/user/login" method="post">
		<div>
			<span>用户名:</span><input type="text" id="username" name="username"></input>
		</div>
		<div>
			<span>密码:</span><input type="text" id="password" name="password"></input>
		</div>
		<div>
			<input type="submit" id="btnPass" name="submit" value="submit"></input>
		</div>	
	</form>		 
</body>
</html>