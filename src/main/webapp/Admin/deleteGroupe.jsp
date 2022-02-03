<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <form name="deleteGroupeServlet" action="deleteGroupeServlet"  method="post">
        <h1>Delete Group ${user.group}  </h1>
        <hr />
           <div>
                  <label>
                      Group name:    <span>   ${user.group} </span>
                  </label>
            </div>
        
             <div style="display: none">
            
                  <label>
                    ID <span class="required">*</span>
                  </label>
                  <input type="text" name="id" value="${user.id}" class="long" />
                  <input type="text" name="group" value="${user.group}" class="long" />
               </div>
               
                <div>
                  <input type="submit" value="Delete" class="button">
                   <a href="/DaawMiniProject/groupList" ><input type="button" value="Cancel" class="button"></a>          
<!--                   <input type="reset" value="Reset">  -->
               </div>
      </form>
      </div>
      </div>
</body>
</html>