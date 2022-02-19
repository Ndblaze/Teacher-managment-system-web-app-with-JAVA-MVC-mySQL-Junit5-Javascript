<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Teachers</title>
<style>
	<%@include file="/cssfiles/listGroup.css"%>
	
</style>
</head>

<body>

<%@include file="/Prof/ProfHeader.jsp"%>


<div class="table">
       <div>
        <h1 class="header"> The dates of sessions</h1><br>
        
        <table class="userTable" >
           <thead>
               <tr> 
                   <th>#</th>
                   <th>Date</th>
                   <th>List</th>
                </tr>
   
              <tbody id="tableBody">       
                <c:forEach var="i" begin="0" end="${sessionList.size()-1}" step="1">
                   <tr>
                   <td> <c:out value="${ 1 + i}" /> </td>
                    <td> <c:out value="${sessionList[i].date}" /> </td>
                    <td> <a href="/DaawMiniProject/listStudentOfSessionsServlet?date=${sessionList[i].date}&group=${sessionList[i].groupName}&module=${user.module}"> <i class="fa fa-solid fa-list list"></i></a></td>
                  </tr>
                 </c:forEach>           
            </tbody>    
         </thead>
      </table>
     </div>
   </div>
</body>
</html>
