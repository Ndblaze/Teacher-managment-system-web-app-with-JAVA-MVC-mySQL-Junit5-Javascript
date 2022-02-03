<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Add session</title>
<style>
	<%@include file="/cssfiles/login.css"%>
</style>
</head>

<body>

<%@include file="/Prof/ProfHeader.jsp"%>

<div id="containerCreateGroup">
     <div id="content">
     <h3>Add New session</h3>
      <form name="addSession" action="addSession"  method="post" id="submitForm">
         <table class="form-style">
            <tr>
               <td>
                  <label>
                     DATE  <span class="required">*</span>
                  </label>
               </td>
               <td>
                  <input type="date" name="date" placeholder="yyyy-mm-dd" class="long" id="date"/>
                  <span id="errorDate" class="error"> there is an error </span>
               </td>
               <td style="display: none">
                  <input type="text" name="moduleName" class="long" value="${user.module}"/>
               </td>
               <td style="display: none">
                  <input type="text" name="group" class="long" value="${Theuser.group}"/>
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
    
    <script type="text/javascript" src="/DaawMiniProject/javascript/dataValidation.js" > 
     </script>   
</body>
</html>