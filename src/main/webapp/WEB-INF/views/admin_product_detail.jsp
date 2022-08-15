<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/admin_product_detail.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

     <section class="dashboard">
        <form action ="" method="get">
            <div class="top">
                <i class="uil uil-bars sidebar-toggle"></i>
    
                <div class="search-box">
                    
                </div>
    
                 <a href="<c:url value='/admin/product/${product.id}/edit' />" class="button"><span style="color: #ffff">chỉnh sửa</span></a>
    
                <img src="<c:url value='/static/images/profile.jpg' />" alt="">
            </div>
        </form>
        
        <div class="dash-content">
        
        	<section id="productdetails" class="section-p1">
	        <div class="container">
	            <div class="single-pro-image">
	                <img src="<c:url value='${product.images.get(0)}' />" width="100%" height="500px" id="MainImg" alt="">
	    
	                <div class="small-img-group">
	    
	                    <div class="small-img-col">
	                        <img src="<c:url value='${product.images.get(0)}' />" width="100%" class="small-img"  alt="">
	                    </div>
	    
	                    <div class="small-img-col">
	                        <img src="<c:url value='${product.images.get(1)}' />" width="100%" class="small-img"  alt="">
	                    </div>
	    
	                    <div class="small-img-col">
	                        <img src="<c:url value='${product.images.get(2)}' />" width="100%" class="small-img"  alt="">
	                    </div>
	    
	                    <div class="small-img-col">
	                        <img src="<c:url value='${product.images.get(3)}' />" width="100%" class="small-img"  alt="">
	                    </div>
	    
	                </div>
	    
	                
	            </div>
	
	            <div class="single-pro-details">
	                <!-- <h3>Home / T-Shirt</h3> -->
	                <h2>${product.name}</h2>
	                <h1 id="price">${product.productDetails.get(0).price} đ</h1>
	                <select id="selecRam">
	                    <c:forEach items="${product.productDetails}" var="productDetail" varStatus="status">
	                    	<option value="${productDetail.price}">${productDetail.ram}</option>
	                   	</c:forEach>
	                </select>
	              
	                <table class="table table-striped">
	                    <tbody>
	                      <tr>
	                        <td>Màn hình</td>
	                        <td>${product.specifications.manHinh} </td>
	                      </tr>
	                      <tr>
	                        <td>Camera</td>
	                        <td>${product.specifications.camera}</td>
	                      </tr>
	                      <tr>
	                        <td>Bộ nhớ trong</td>
	                        <td>${product.specifications.oCung}</td>
	                      </tr>
	                      <tr>
	                        <td>CPU</td>
	                        <td>${product.specifications.cpu}</td>
	                      </tr>
	                      <tr>
	                        <td>GPU</td>
	                        <td>${product.specifications.cardDoHoa}</td>
	                      </tr>
	                      <tr>
	                        <td>Dung lượng pin</td>
	                        <td>${product.specifications.dungLuongPin}</td>
	                      </tr>
	                      <tr>
	                        <td>Thẻ sim</td>
	                        <td>${product.specifications.theSim}</td>
	                      </tr>
	                      <tr>
	                        <td>Hệ điều hành</td>
	                        <td>${product.specifications.os}</td>
	                      </tr>
	                      <tr>
	                        <td>Thời gian ra mắt</td>
	                        <td>${product.specifications.dateRelase}</td>
	                      </tr>
	                    </tbody>
	                </table>
	            </div>
        	</div>
    	</section>
        	
        </div>
        
		
		
    </section>
    
    <script src="<c:url value='/static/js/admin_product_detail.js' />" ></script>
    
</rapid:override>  
 
<%@ include file="admin_header.jsp" %> 