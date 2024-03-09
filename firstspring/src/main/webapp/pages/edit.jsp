<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Update Form</h1>
<form action="update" method="post">
<input type="hidden" name="id" value="${data.id}" placeholder="Enter name"><br><br>
<input type="text" name="sname" value="${data.sname}"  placeholder="Enter name"><br><br>
<input type="text" name="semail" value="${data.semail}" placeholder="Enter email"><br><br>
<input type="submit" value="Update">
</form>
</center>
</body>
</html>