<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Users</title>
<style>
	<%@include file="/cssfiles/table.css"%>
	<%@include file="/cssfiles/style.css"%>
</style>
</head>

<body>

<%@include file="/Prof/ProfHeader.jsp"%>


<h1>la presance</h1><br>



<div class="table">
    
    <div class="row header blue">
      <div class="cell">
        Firstname
      </div>
      <div class="cell">
        Lastname
      </div>
      <div class="cell">
        12/12/2021
      </div>
      
    </div>
  
  <c:forEach var="i" begin="0" end="${usersList.size()-1}" step="1">  
  
    <div class="row">
    
      <div class="cell" data-title="Product">
        <c:out value="${usersList[i].firstname}" />
      </div>
      <div class="cell" data-title="Unit Price">
        <c:out value="${usersList[i].lastname}" />
      </div>
      <div class="cell" data-title="Quantity">
        <c:out value="${usersList[i].adress}" />
      </div>

      <div class="cell" data-title="Status">
       <a href="/mnProject/updateServlet?userid=${i+1}"> update</a>
      </div>
    </div>

  </c:forEach>
</div>

</body>
</html>