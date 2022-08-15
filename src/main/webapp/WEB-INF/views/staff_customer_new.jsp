<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:url value='/staff/customer/save' var='saveUrl'/>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/staff_customer_new.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

     <section class="dashboard">
        <div class="top">
            	<i class="uil uil-bars sidebar-toggle"></i>
    
                <div class="search-box">
                    
                    
                </div>
    
                <img src="<c:url value='/static/images/profile.jpg' />" alt="">
        </div>

        <div class="dash-content">
            <div class="wrapper">
			   <h2>User Sigup</h2>
			   <form:form  method="post"  modelAttribute="custommer" action="${saveUrl}" enctype="multipart/form-data">
			   	  <form:hidden path="id"/>
			   	  <form:hidden path="user.id"/>
			      <div class="row">
			         <div class="col-md-6">
			              <div class="input-box">
			                <form:input path="user.firstName" placeholder ="firstName" required="required"/>
			              </div>
			              <div class="input-box">
			               	<form:input path="user.username" placeholder ="username" required="required"/>
			              </div>
			              <div class="input-box">
			                <form:input path="user.email" placeholder ="email" />
			              </div>
			              <div class="input-box">
			                <input type="file" name="fileUpload" />
			              </div>
			         </div>
			         <div class="col-md-6">
			              <div class="input-box">
			               	<form:input path="user.lastName" placeholder ="lastName" required="required"/>
			              </div>
			              <div class="input-box">
			              	<form:input path="user.password" placeholder ="password" required="required" type="password"/>
			              </div>
			              <div class="input-box">
			                <form:input path="user.phone" placeholder ="phone" required="required"/>
			              </div>
			         </div>
			      </div>
			      
			      <div class="row">
			         <div class="col-md-6">
			              <div class="input-box">
			                <form:input path="user.address.city" placeholder ="city" />
			              </div>
			              <div class="input-box">
			               	<form:input path="user.address.distric" placeholder ="distric" />
			              </div>
			              
			         </div>
			         <div class="col-md-6">
			              <div class="input-box">
			               	<form:input path="user.address.commute" placeholder ="commute" />
			              </div>
			              <div class="input-box">
			              	<form:input path="user.address.street" placeholder ="street"/>
			              </div>
			             
			         </div>
			      </div>
			     
			     <div class="input-box button">
			       <input type="Submit" value="save" class="btn_sub">
			     </div>
			   </form:form>
			 </div>
        </div>
    </section>
    
</rapid:override>  
 
<%@ include file="staff_header.jsp" %> 