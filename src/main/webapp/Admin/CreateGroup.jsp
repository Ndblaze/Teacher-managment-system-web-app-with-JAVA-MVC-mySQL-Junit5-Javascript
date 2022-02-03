<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add User</title>
<style>
	<%@include file="/cssfiles/login.css"%>
</style>
</head>

<body>

<%@include file="/Admin/AdminHeader.jsp"%>


 <div id="containerCreateGroup">
     <div id="content">
      <h3>Add New Group</h3>
      <form name="CreateGroup" action="CreateGroup"  method="post" id="submitForm">
         <table class="form-style">
            <tr>
               <td>
                  <label>
                      Group name <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="text" name="nbGroup" class="long" id="groupName"/>
                  <span id="errorCreatGroup" class="error"> there is an error </span>
               </td>
            </tr>
            <tr>
               <td>
                  <input type="button" onclick="validate()" value="Create" class="button">      
                  <input type="reset" value="Reset" class="button"> 
               </td>
            </tr>
         </table>
      </form>
    </div>
    </div>
    
    <script type="text/javascript" src="/DaawMiniProject/javascript/add.js" > 
    
     </script>   
</body>
</html>