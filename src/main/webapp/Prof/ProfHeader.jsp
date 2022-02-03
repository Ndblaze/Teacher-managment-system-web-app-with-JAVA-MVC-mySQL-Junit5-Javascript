<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<style>
	<%@include file="/cssfiles/header.css"%>
</style>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<c:if test="${!empty sessionScope.user}">
<%--   <h1>Welcome ${user.firstname} ${user.lastname}</h1> --%>

 <div id="links">
	  <div id="link">
		  <div id="left">
			  <a class="active" href="http://localhost:8080/DaawMiniProject/Prof/ProfHeader.jsp"> <img alt="logo" src="images/logo3.png" class="logo"/>  </a>
			
		  </div>
		  <div id="rightP">
		      <a href="http://localhost:8080/DaawMiniProject/groupListP">Faire l’appel</a>
			  <a href="http://localhost:8080/DaawMiniProject/PresenceGroupservlet">Relevé de présence</a>
			  <a href="http://localhost:8080/DaawMiniProject/updateTeacherHimself?id=${user.id}">Profile</a>
		 	  <a href="http://localhost:8080/DaawMiniProject/logoutServlet">Logout<i class="fa fa-sign-out" aria-hidden="true"></i></a>
		  </div>
	  </div>
 </div>

</c:if>	

<c:if test="${empty sessionScope.user}">
  <h1>Welcome to My Web Application</h1>
</c:if>	

 


</body>
</html>