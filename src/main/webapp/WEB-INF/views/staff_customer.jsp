<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 
	
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <link href="<c:url value='/static/css/staff_customer_style.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

     <section class="dashboard">
     	<form action ="" method="get" id="searchForm">
        <div class="top">
            <i class="uil uil-bars sidebar-toggle"></i>
    
                <div class="search-box">
                    <i class="uil uil-search" id="btnSearch"></i>
                    <input type="text" placeholder="Search here..." name="key" value="${key}">
                    
                </div>
    
                 <a href="<c:url value='/staff/customer/new' />" class="button"><span style="color: #ffff">thêm mới</span></a>
    
                <img src="<c:url value='/static/images/profile.jpg' />" alt="">
        </div>
        
        </form>

        <div class="dash-content">
            <div class="overview">
	            <div class="title">
	                <i class="uil uil-tachometer-fast-alt"></i>
	                <span class="text">Customer</span>
	            </div>
	
	            <table class="table table-striped table hover">
	                <theah>
	                    <th>Name</th>
	                    <th>Profile Picture</th>
	                    <th>Mobile</th>
	                    <th>Address</th>
	                    <th>Email</th>
	                    <th>Update</th>
	                    <th>Delete</th>
	                </theah>
	                <tbody>
	                	<c:forEach items="${customers}" var="customer" varStatus="status">
	                		<tr>
		                        <td> ${customer.user.firstName} ${customer.user.lastName}</td>
		                        <td> <img src="<c:url value='${customer.user.image}' />" alt="Profile Pic" height="40px" width="40px" /></td>
		                        <td>${customer.user.phone}</td>
		                        <td>${customer.user.address.city}</td>
		                        <td>${customer.user.email}</td>
		                        <td><a class="btn btn-primary btn-xs" href="<c:url value='/staff/customer/${customer.id}/edit' />"><span class="glyphicon glyphicon-edit"></span></a></td>
		                        <td><a class="btn btn-danger btn-xs" href="<c:url value='/staff/customer/${customer.id}/delete' />"><span class="glyphicon glyphicon-trash"></span></a></td>
	                   	 	</tr>
	                	</c:forEach>
		             </tbody>
	            </table>
	            
	            <div class="paging">	                
	                <tag:paginate offset="${offset}" count="${count}" key="${key}" steps="${8}" uri="" next="&raquo;" previous="&laquo;" />
	            </div>
            
	       </div>
        </div>
    </section>
    
    <script src="<c:url value='/static/js/staff_custommer.js' />" ></script>
    
</rapid:override>  
 
<%@ include file="staff_header.jsp" %> 