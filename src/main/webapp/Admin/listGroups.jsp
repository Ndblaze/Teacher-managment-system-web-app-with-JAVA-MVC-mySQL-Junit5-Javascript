<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of groups</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	<%@include file="/cssfiles/listGroup.css"%>
</style>
</head>

<body>

<%@include file="/Admin/AdminHeader.jsp"%>
   	

   <div class="table">
     <div>
    <h1 class="header">List of Groups</h1><br>
    <div class="link">
	     <a href="http://localhost:8080/DaawMiniProject/addStudent"><button> Add Student </button></a>
	     <a href="http://localhost:8080/DaawMiniProject/CreateGroup"><button>Create Group </button></a>
     </div>
     <table class="userTable" >
           <thead>
               <tr> 
                   <th>Group</th>
                   <th>List</th>
                   <th>Delete</th>
                </tr>
             </thead>
              <tbody id="tableBody">       
                <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">
                   <tr>
                    <td>  <c:out value="${usersList[i].group}" /> </td>
                    <td><a href="/DaawMiniProject/StudentListServlet?group=${usersList[i].group}"><i class="fa fa-solid fa-list list"></i></a></td>
                     <td><a href="/DaawMiniProject/deleteGroupeServlet?userid=${usersList[i].id}&group=${usersList[i].group}"> <i class="fa fa-trash" aria-hidden="true"></i> </a></td>
                  </tr>
                 </c:forEach>           
            </tbody>    
      </table>
      </div>
   </div>
</body>
</html>
