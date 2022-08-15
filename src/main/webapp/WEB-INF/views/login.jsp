<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

 <rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/login_style.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

	<div class="center">
        <h1>Login</h1>
        <form name='f' method='POST' action='process-login'>
	        <div class="txt_field">
	            <input type='text' name='username' value='' required>
	            <span></span>
	            <label>Username</label>
	        </div>
	        <div class="txt_field">
	            <input type='password' name='password' required />
	            <span></span>
	            <label>Password</label>
	        </div>
	        <div class="pass">Forgot Password?</div>
	        <input name="submit" type="submit" value="submit" />
	        <div class="signup_link">
	            Not a member? <a href="user-signup">Signup User</a> <a href="staff-signup">Apply Staff</a>
	        </div>
        </form>
    </div>

</rapid:override>  
 
<%@ include file="header.jsp" %>  

