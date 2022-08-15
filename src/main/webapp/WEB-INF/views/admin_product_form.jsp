<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:url value='/admin/product/save' var='saveUrl'/>


<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/admin_product_form.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

     <section class="dashboard">
        <form action ="" method="get">
            <div class="top">
                <i class="uil uil-bars sidebar-toggle"></i>
    
                
    
                <img src="<c:url value='/static/images/profile.jpg' />" alt="">
            </div>
        </form>
        

        <div class="dash-content">
            <div class="wrapper">
			   <h2>Phone Add</h2>
			   <form:form  method="post"  modelAttribute="product" action="${saveUrl} " enctype="multipart/form-data">
			   	  <form:hidden path="id"/>
			      <div class="row">
			         <div class="col-md-6">
			              <div class="input-box">
			                <form:input path="name" placeholder ="name" required="required"/>
			              </div>
			              <div class="input-box">
			                <input type="file" name="files" multiple="multiple" />
			              </div>
			         </div>
			         <div class="col-md-6">
			              <div class="input-box">
			               	<form:input path="count" placeholder ="count store" required="required"/>
			              </div>
			              <div class="input-box">
				              <form:select path="manufacrurer.id" items="${manufacturers}" itemLabel="name" itemValue="id">
						 
			 				  </form:select>
			              </div>
			         </div>
			      </div>
			      
			      <h2>specifications</h2>
			      
			      <div class="row">
			         <div class="col-md-6">
			              <div class="input-box">
			                <form:input path="specifications.dungLuongPin" placeholder ="dungLuongPin" />
			              </div>
			              <div class="input-box">
			                <form:input path="specifications.camera" placeholder ="camera" />
			              </div>
			              <div class="input-box">
			                <form:input path="specifications.oCung" placeholder ="oCung" />
			              </div>
			         </div>
			         <div class="col-md-6">
			              <div class="input-box">
			               	<form:input path="specifications.manHinh" placeholder ="manHinh" />
			              </div>
			              <div class="input-box">
			               	<form:input path="specifications.cardDoHoa" placeholder ="cardDoHoa" />
			              </div>
			              <div class="input-box">
			                <form:input path="specifications.nhuCau" placeholder ="nhuCau" />
			              </div>
			         </div>
			      </div>
			      
			      <h2>Phien Ban</h2>
			      
			      <img alt="" src="<c:url value='/static/images/add.svg' />" id="img_add">
			      
			      <div class="row" >
			         <div class="col-md-6" id="ram">
			         	  <h3>RAM</h3>
			         	  <c:if test="${empty product.id}">
				         	  <div class="input-box">
				                <input  placeholder ="Ram" name="rams"/>
				              </div>
			         	  </c:if>
			         	  
			         	  <c:if test="${not empty product.id}">
			         	  	<c:forEach items="${product.productDetails}" var="proDetail" varStatus="status">
			         	  		<div class="input-box">
			         	  			<%-- path="productDetails[${status.index}].ram " --%>
				                	<input placeholder ="Ram" name="rams" value="${proDetail.ram}"/>
				              	</div>
			         	  	</c:forEach>
			         	  </c:if>
			              
			         </div>
			         <div class="col-md-6"  id="price">
			         	  <h3>Price</h3>
			         	  <c:if test="${empty product.id}">
				         	  <div class="input-box">
				               	<input  placeholder ="Gia" name="prices"/>
				              </div>
			         	  </c:if>
			              
			              <c:if test="${not empty product.id}">
			         	  	<c:forEach items="${product.productDetails}" var="proDetail" varStatus="status">
			         	  		<div class="input-box">
			         	  			<input placeholder ="Price" name="prices" value="${proDetail.price}"/>
				                	<%-- <form:input  path="productDetails[${status.index}].price" placeholder ="Gia" name="prices" /> --%>
				              	</div>
			         	  	</c:forEach>
			         	  </c:if>
			              
			         </div>
			      </div>
			      
			      <h2>description</h2>
			      <div class="row">
			                <form:textarea path="description"  placeholder ="description" name="description" rows="5"/>
			      </div>
			      
			     
			     <div class="input-box button">
			       <input type="Submit" value="save" class="btn_sub">
			     </div>
			     
			   </form:form>
			 </div>
        </div>
    </section>
    
    <script src="<c:url value='/static/js/admin_product_form.js' />" ></script>
    
</rapid:override>  
 
<%@ include file="admin_header.jsp" %> 