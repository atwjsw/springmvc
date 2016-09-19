<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="mainForm" action="/imooc/doUpload" method="post" enctype="multipart/form-data">
		<div>
			<span>File:</span><input type="file" id="file" name="file"></input>
		</div>
		<div>
			<input type="submit" id="btnPass" name="submit" value="submit"></input>
		</div>	
	</form>		 
</body>
</html>