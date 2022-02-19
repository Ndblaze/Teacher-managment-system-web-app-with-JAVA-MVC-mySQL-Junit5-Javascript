<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>List of Users</title>
<style>
	<%@include file="/cssfiles/ListOfStudents.css"%>
</style>
</head>

<body>

<%@include file="/Admin/AdminHeader.jsp"%>

<div id="container">

     <h1 class="header">List of Teachers</h1><br>
   	
   	
<div class="table">
<div>
       <a href="http://localhost:8080/DaawMiniProject/addTeacher" class="groupList"><Button>Add New Teacher </Button></a> 
         <table class="userTable" >
             <thead>
                 <tr> 
                     <th>Firstname</th>
                     <th>Lastname</th>
                     <th>Email</th>
                     <th>Phone number</th>
                     <th>Username</th>
                     <th>Password</th>
                     <th>Module</th>
                     <th>Update</th>
                     <th>Delete</th>
                 </tr>
                 </thead>
                 <tbody id="tableBody">    
                     <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">
                
                        <tr>
                         <td> <c:out value="${usersList[i].firstname}" /> </td>
                         <td><c:out value="${usersList[i].lastname}" /></td>
                         <td> <c:out value="${usersList[i].adress}" /></td>
                         <td> <c:out value="${usersList[i].phone}" /></td>
                         <td>  <c:out value="${usersList[i].username}" /></td>
                         <td>  <c:out value="${usersList[i].password}" /></td>
                         <td>  <c:out value="${usersList[i].module}" /> </td>
                         <td>  <a href="/DaawMiniProject/updateTeacher?userid=${usersList[i].id}"> <i class="fa fa-pencil-square-o update" aria-hidden="true" ></i> </a></td>
                         <td>  <a href="/DaawMiniProject/deleteTeacherServlet?userid=${usersList[i].id}">  <i class="fa fa-trash delete" aria-hidden="true"></i></a></td>
                       </tr>
                      </c:forEach>
             </tbody>    
        </table>
        </div>
   </div>
  </div>
</body>
</html>
