<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
                  <thead>
                   <tr>
                     <th>Id</th>
                     <th> Name</th>
                     <th>email</th>
                     <th>Photo</th>
                     <th>Action</th>
                
                   </tr>
                   </thead>
                   
             <c:forEach var="e" items="${s1}">  
             
                   <tbody><tr>
                    <td>${e.id}</td>
                    <td>${e.sname}</td>
                   <td>${e.semail}</td>
                   <td>
                   <a href=""><img alt="" src="images/${e.sphoto}" width="40"></a>
                   </td>
                   <td>
                   <a href="edit?id=${e.id}" >Edit</a> |
                   <a href="del?id=${e.id}">Delete</a>
                   </td>
					
                   </tr>
                 </tbody>
                 </c:forEach> 
                 </table>
</body>
</html>