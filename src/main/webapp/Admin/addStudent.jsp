<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add User</title>
<style>
	<%@include file="/cssfiles/Update.css"%>
</style>
</head>

<body>

<%@include file="/Admin/AdminHeader.jsp"%>

<div id="update">
  <div id="content">
      <form name="addUser" action="addStudent"  method="post" id="submitForm">
      <h1>Add New Student</h1>
	     <hr />
	     <div class="sharedRow">
	         <div>
               <label>
                   Firstname <span class="required">*</span>
               </label>
               <input type="text" name="fname" class="long inputBox" placeholder="firstname" id="Fname"/>
               <span id="errorFirstname" class="error"> there is an error </span>
	     </div> 
	         <div>
                <label>
                   Lastname <span class="required">*</span>
                </label>
                <input type="text" name="lname" class="long inputBox" placeholder="lastname" id="Lname"/>
                <span id="errorLastname" class="error"> there is an error </span>
	         </div>  
         </div>
         
         <div class="sharedRow">
		     <div>
                <label>
                     Adress <span class="required">*</span>
                </label>
                <input type="text" name="adress" class="long inputBox"  placeholder="adress"  id="address" />
                <span id="errorAddress" class="error"> there is an error </span>
		     </div> 
	         <div>
                <label>
                  Phone <span class="required">*</span>
                </label>
                <input type="text" name="phone" class="long inputBox" placeholder="phone number" id="phone"/>
                <span id="errorPhone" class="error"> there is an error </span>
	         </div>  
         </div>
         
         <div class="sharedRow">
	         <div>
	            <label>
	                 Username <span class="required">*</span> 
	            </label>
	            <input type="text" name="username" class="long inputBox" placeholder="username" id="uname"/>
	            <span id="errorUsername" class="error"> there is an error </span>
	        </div> 
	        <div>
                <label>
                     Password <span class="required">*</span>
                 </label>
                <input type="text" name="password" class="long inputBox" placeholder="password" id="pass"/>
                <span id="errorPassword" class="error"> there is an error </span>
	        </div>  
         </div>
            
              <div style="display: none">
                  <label  > Type<span class="required"> *</span></label>
                       
                  <select id = "type" name="type"  class="long">
<!--                   <option value="Administrateur"> Administrateur </option> -->
                  <option value="Etudiant"> Etudiant </option>
                  <option value="Enseignant"> Enseignant </option>
                  <option value="Admin"> Admin </option>
                  </select>
               </div>
               
               <div class="group">
	         <div>
               <label>
                  Group (A, B, ...) <span class="required" >*</span> 
               </label>
               <input type="text" name="group" class="long inputBox" placeholder="choose a group" id="groupName" />
               <span id="errorCreatGroup" class="error"> there is an error </span>
	         </div> 
         </div>
             <br />
            <input type="button"  onclick="validate()" value="update" class="button">      
            <input type="reset" value="Reset" class="button">
      </form>
       </div>
</div>

  <script type="text/javascript" src="/DaawMiniProject/javascript/update.js" > 
    
     </script>
</body>
</html>