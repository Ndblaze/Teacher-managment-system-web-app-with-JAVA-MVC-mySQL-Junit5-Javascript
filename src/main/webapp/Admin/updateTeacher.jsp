<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <form name="UpdateUser" action="updateTeacher"  method="post" id="submitForm">
     <h1>UPDATE TEACHER</h1>
     <hr />
         <div class="sharedRow">
	         <div>
                <label>
                    Firstname <span class="required">*</span>
                </label>
                <input type="text" name="fname" class="long inputBox" placeholder=""  value="${TheUser.firstname}" id="Fname"/>
                <span id="errorFirstname" class="error"> there is an error </span>
	          </div> 
	          <div>
                  <label>
                     Lastname <span class="required">*</span>
                  </label>
                  <input type="text" name="lname" class="long inputBox"  value="${TheUser.lastname}" id="Lname"/>
                <span id="errorLastname" class="error"> there is an error </span>
	          </div>  
            </div>
          
             <div class="sharedRow">
		         <div>
	               <label>
	                     Adress <span class="required">*</span>
	                  </label>
	                <input type="text" name="adress" class="long inputBox" value="${TheUser.adress}"  id="address" />
                 <span id="errorAddress" class="error"> there is an error </span>
		          </div> 
		          <div>
	                   <label>
	                     Phone <span class="required">*</span>
	                   </label>
	                  <input type="text" name="phone" class="long inputBox"  value="${TheUser.phone}" id="phone"/>
                      <span id="errorPhone" class="error"> there is an error </span>
		          </div>  
             </div>
             
             <div class="sharedRow">
		         <div>
	               <label>
                     Username <span class="required">*</span> 
                  </label>
	                <input type="text" name="username" class="long inputBox"  value="${TheUser.username}" id="uname"/>
	                <span id="errorUsername" class="error"> there is an error </span>
		          </div> 
		          <div>
	                   <label>
                         Password <span class="required">*</span>
                     </label>
	                  <input type="text" name="password" class="long inputBox"  value="${TheUser.password}" id="pass"/>
                      <span id="errorPassword" class="error"> there is an error </span>
		          </div>  
             </div>
          
              <div style= "display: none;">
                  <label  > Type<span class="required"> *</span></label>
                     
                  <select id = "type" name="type"  class="long" >
                  <option value="Enseignant"> Enseignant </option>
                  <option value="Administrateur"> Administrateur </option>
                  <option value="Etudiant"> Etudiant </option>
                   <option value="Admin"> Admin </option>
                  </select>  
              </div>
            
              <div class="ChooseModule">
                  <label >
                    Choose Module <span class="required" >*</span>
                  </label>
              
                  <select id = "module" name="module"  class="long">
                  <option value="${TheUser.module}"> ${TheUser.module} </option>
                  <option value="DAC"> DAC </option>
                  <option value="TABD"> TABD </option>
                   <option value="DAWW"> DAAW </option>
                   <option value="TQL"> TQL </option>
                   <option value="GPL"> GPL </option>
                   <option value="GL2"> GL2 </option>
                  </select>
                  <span id="errorModule" class="error"> there is an error </span>
               </div>
               
               
           
                  <input type="button"  onclick="validate()" value="Update" class="button">      
                  <input type="reset" value="Reset" class="button"> 
             
            
            <div style="display: none">
              
                  <label>
                    ID <span class="required">*</span>
                  </label>
               
                  <input type="text" name="id" class="long" value="${TheUser.id}"/>
            </div>
      </form>
     </div> 
   </div> 
   
    <script type="text/javascript" src="/DaawMiniProject/javascript/updateAddTeacher.js" > 
    
     </script> 
</body>
</html>
