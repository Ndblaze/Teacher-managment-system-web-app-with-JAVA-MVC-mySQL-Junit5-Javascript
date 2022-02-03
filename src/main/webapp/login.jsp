<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<title>Login page</title>
	
    <style><%@include file="/cssfiles/login.css"%></style>
   
</head>

<body>
<%-- <%@include file="/header.jsp"%> --%>
     <div id="container">
     <div id="content">
	 <h1>Login</h1>
      <form name="login" action="loginServlet"  method="post" id="submitForm">
         <table class="form-style">
            <tr>
               <td>
                  <label>
                     Username <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input id="uname" type="text" name="username" class="long"/>
                  <span id="errorUsername" class="error"> there is an error </span>
               </td>
            </tr>
            <tr>
               <td>
                  <label>
                     Password <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input id="upass" type=text name="password" class="long"/>
                  <span id="errorPassword" class="error"> there is an error </span>
               </td>
            </tr>
            
            
            <tr>
               <td>
                  <label for = "type" >Type<span class="required"> *</span></label>
                  <select id = "type" name="type">
                  <option value="Administrateur"> Administrateur </option>
                  <option value="Enseignant"> Enseignant </option>
                  </select>
               </td>
            </tr>
            
            <tr>
               <td>
                  <input type="button" onclick="validate()" value="Login" class="button">
                 <!--   <input type="submit" value="Login" class="button">      -->   
                  <input type="reset" value="Reset" class="button"> 
               </td>
            </tr>
         </table>
      </form>
     </div>
     </div>
     
     <script type="text/javascript" src="/DaawMiniProject/javascript/validateLogin.js" > 
    
     </script> 
       
</body>
</html>