<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/admin_product_list_style.css' />" rel="stylesheet">
    
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
    
                 <a href="<c:url value='/admin/product/new' />" class="button"><span style="color: #ffff">thêm mới</span></a>
    
                <img src="<c:url value='/static/images/profile.jpg' />" alt="">
            </div>
        </form>
        

        <div class="dash-content">
            <div class="pro-container">
            	<c:forEach items="${products}" var="product" varStatus="status">
	                <div class="pro">
	                    <img src="<c:url value='${product.images.get(1)}' />" alt="">
	                    <div class="des">
	                        <span>${product.manufacrurer.name}</span>
	                        <h5><a href="<c:url value='/admin/product/${product.id}' />">${product.name}</a></h5>
	                        <div class="star">
	                            <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i>
	                            <i class="fas fa-star"></i>
	                        </div>
	                        <h4>${product.productDetails.get(0).price} đ</h4>
	                        <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
	                    </div>
	                </div>
               </c:forEach> 
            </div>
            <div class="paging">
                <tag:paginate offset="${offset}" count="${count}" key="${key}" steps="${3}" uri="" next="&raquo;" previous="&laquo;" />
            </div>
            
            
        </div>
    </section>
    
    <script src="<c:url value='/static/js/admin_product_list.js' />" ></script>
    
</rapid:override>  
 
<%@ include file="admin_header.jsp" %> 