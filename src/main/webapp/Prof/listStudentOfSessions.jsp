<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<style>
	<%@include file="/cssfiles/listGroup.css"%>
</style>
</head>

<body>

<%@include file="/Prof/ProfHeader.jsp"%>

<div class="table">
    <div>
    <h1 class="header">List of Students</h1>
   <table class="userTable" >
           <thead>
               <tr> 
                   <th>FirstName</th>
                   <th>LastName</th>
                   <th>Presence</th>
                </tr>
                
                <tbody id="tableBody">       
                <c:forEach var="i" begin="0" end="${sessionStudent.size()-1}" step="1">
                   <tr>
                   <form name="insertPresntStudent" action="insertPresntStudent"  method="post">
                    <td>  <c:out value="${sessionStudent[i].firstname}" /> </td>
                    <td> <c:out value="${sessionStudent[i].lastname}" /> </td>
                    
                      <input style="display: none;" name="idsession" value="${sessionStudent[i].idsession}">
				      <input style="display: none;" name="student" value="${sessionStudent[i].student}">
				      <input style="display: none;" name="firstname" value="${sessionStudent[i].firstname}">
				      <input style="display: none;" name="lastname" value="${sessionStudent[i].lastname}">
				      <input style="display: none;" name="groupName" value="${sessionStudent[i].groupName}">
				      <input style="display: none;" name="date" value="${sessionStudent[i].date}">
				      <input style="display: none;" name="moduleName" value="${user.module}">
      
      
                       <td>
                         <div class="status">
					       <c:if test="${(sessionStudent[i].present).contains(\"present\") }">
					      <input style="display: none;" name="present" type="text" value="absent">
					      <input id="${i}"  type="submit" value="Present" class="present">
					      </c:if>
					       <c:if test="${(sessionStudent[i].present).contains(\"absent\")}">
					       <input style="display: none;" name="present" type="text" value="present">
					       <input id="${i}" type="submit" value="Absent" class="absent" >
					        </c:if>
					      </div>	
                       </td>
      
                       </form>
                    </tr>
                 </c:forEach>
             </tbody>    
         </thead>
      </table>
    </div>
  </div>
</body>
</html>
