<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add User</title>
<style>
	<%@include file="/cssfiles/delete.css"%>
</style> 
</head>

<body>

<%@include file="/Admin/AdminHeader.jsp"%>

<div class="container">
  <div class="content">
      <form name="deletTeacherServlet" action="deleteTeacherServlet"  method="post">
        <h1>Delete ${user.firstname}'s Profile </h1>
        <hr />
         
           <div>
                  <label>
                      Firstname:     <span>   ${user.firstname} </span>
                  </label>
            </div>
            <div>
                  <label>
                     Lastname:   <span> ${user.lastname} </span>
                  </label>
            </div>
             
             <div>
                  <label>
                     Adress: <span> ${user.adress} </span>
                  </label>
             </div>
            <div>
                  <label>
                     Phone no:  <span> ${user.phone}  </span>
                  </label>
            </div>
            
             <div>
                  <label>
                     Username: <span> ${user.username} </span>
                  </label>
            </div>
            <div>
                  <label>
                     Password: <span> ${user.password} </span>
                  </label>
             </div> 
           
              <div style="display: none">
                  <label  > Type<span class="required"> *</span></label>
                       
                  <select id = "type" name="type"  class="long" >
                  <option value="Etudiant"> Etudiant </option>
                  <option value="Administrateur"> Administrateur </option>
                  <option value="Enseignant"> Enseignant </option>
                   <option value="Admin"> Admin </option>
                  </select>
                  
              </div>
          
            <div>
                  <input type="submit" value="delete" class="button">
                  <a href="/DaawMiniProject/ProfListServlet" ><input type="button" value="Cancel" class="button"></a>        
<!--                   <input type="reset" value="Reset">  -->
            </div>
            
                <div style="display: none">
          
                  <label>
                    ID <span class="required">*</span>
                  </label>
                   <input type="text" name="id" class="long" value="${user.id}"/>
            </div>
        
      </form>
</body>
</html>























<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   --%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>List of Users</title> -->
<!-- <style> -->
<%-- 	<%@include file="/cssfiles/table.css"%> --%>
<%-- 	<%@include file="/cssfiles/style.css"%> --%>
<!-- </style> -->
<!-- </head> -->

<!-- <body> -->

<%-- <%@include file="/Admin/AdminHeader.jsp"%> --%>


<!-- <h1>List of Students</h1><br> -->


<!--    	  <a href="http://localhost:8080/mnProject/groupList"> Group list</a> -->
   	

<!-- <div class="table"> -->
    
<!--     <div class="row header blue"> -->
<!--       <div class="cell"> -->
<!--         Firstname -->
<!--       </div> -->
<!--       <div class="cell"> -->
<!--         Lastname -->
<!--       </div> -->
<!--       <div class="cell"> -->
<!--         Adress -->
<!--       </div> -->
<!--       <div class="cell"> -->
<!--         Phone -->
<!--       </div> -->
<!--       <div class="cell"> -->
<!--         Username -->
<!--       </div> -->
<!--       <div class="cell"> -->
<!--         Password -->
<!--       </div> -->
<!--      	<div class="cell"> -->
<!--         Group -->
<!--       </div> -->
<!--       <div style="display: none" class="cell"> -->
<!--         Type -->
<!--       </div> -->

<!--         <div class="cell"> -->
       
<!--       </div> -->
<!--     </div> -->
   
 <%--   <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">   --%> 
  
<!--     <div class="row"> -->
    
<!--       <div class="cell" data-title="Product"> -->
<%--         <c:out value="${user.firstname}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Unit Price"> -->
<%--         <c:out value="${user.lastname}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Quantity"> -->
<%--         <c:out value="${user.adress}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Date Sold"> -->
<%--         <c:out value="${user.phone}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Status"> -->
<%--         <c:out value="${user.username}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Status"> -->
<%--         <c:out value="${user.password}" /> --%>
<!--       </div> -->
<!--        <div class="cell" data-title="Status"> -->
<%--         <c:out value="${user.group}" /> --%>
<!--       </div> -->
<!--        <div style="display: none" class="cell" data-title="Status"> -->
<%--         <c:out value="${user.type}" /> --%>
<!--       </div> -->
<!--       <div class="cell" data-title="Status"> -->
<!--       </div> -->
<!--     </div> -->

<%-- <!-- </div> -->
<%--         <a  href="/mnProject/deleteStudentServlet?userid=${usersList[i].id}&?group=${usersList[i].group}">  Delete</a> --%>
       
<!-- </body>  -->
<!-- </html> -->