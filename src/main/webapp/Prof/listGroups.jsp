<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of groups</title>
<style>
	<%@include file="/cssfiles/listGroup.css"%>
	
</style>
</head>

<body>

<%@include file="/Prof/ProfHeader.jsp"%>

<div class="table">
     <div>
    <h1 class="header">List of Groups</h1>
     <table class="userTable" >
           <thead>
               <tr> 
                   <th>Group</th>
                   <th>List</th>
                </tr>
            
              <tbody id="tableBody">       
                <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">
                   <tr>
                    <td>  <c:out value="${usersList[i].group}" /> </td>
                    <td> <a href="/DaawMiniProject/addSession?group=${usersList[i].group}"> list</a></td>
                  </tr>
                 </c:forEach>           
            </tbody>    
         </thead>
      </table>
      </div>
   </div>
</body>
</html>
