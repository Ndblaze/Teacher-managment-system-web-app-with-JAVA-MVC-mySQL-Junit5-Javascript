<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<style>
	<%@include file="/cssfiles/ListOfStudents.css"%>
</style>
</head>

<body>

   

<%@include file="/Admin/AdminHeader.jsp"%>

<div id="container">

     <h1 class="header">List of Students</h1><br>
   	
<div class="table">
<div>
       <a href="http://localhost:8080/DaawMiniProject/groupList" class="groupList"><Button>Group list </Button></a> 
         <table class="userTable" >
             <thead>
                 <tr> 
                     <th>Firstname</th>
                     <th>Lastname</th>
                     <th>Email</th>
                     <th>Phone number</th>
                     <th>Username</th>
                     <th>Password</th>
                     <th>Group</th>
                     <th>Update</th>
                     <th>Delete</th>
                 </tr>
                 <tbody id="tableBody">       
                     <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">
                        <tr>
                         <td> <c:out value="${usersList[i].firstname}" /> </td>
                         <td><c:out value="${usersList[i].lastname}" /></td>
                         <td> <c:out value="${usersList[i].adress}" /></td>
                         <td> <c:out value="${usersList[i].phone}" /></td>
                         <td>  <c:out value="${usersList[i].username}" /></td>
                         <td>  <c:out value="${usersList[i].password}" /></td>
                         <td>  <c:out value="${usersList[i].group}" /> </td>
                         <td>  <a href="/DaawMiniProject/updateStudentServlet?userid=${usersList[i].id}"> <i class="fa fa-pencil-square-o update" aria-hidden="true" ></i></a></td>
                         <td>   <a href="/DaawMiniProject/deleteStudentServlet?userid=${usersList[i].id}&?group=${usersList[i].group}">  <i class="fa fa-trash delete" aria-hidden="true"></i> </a></td>
                       </tr>
                      </c:forEach>  
                        
             </tbody>    
            </thead>
        </table>
        </div>
   </div>
  </div>
</body>
</html>
