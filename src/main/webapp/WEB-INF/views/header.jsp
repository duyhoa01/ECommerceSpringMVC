<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="head"> 
 
    <link href="<c:url value='/static/css/header_style.css' />" rel="stylesheet">
    
    <link href="<c:url value='/static/css/swiper-bundle.min.css' />" rel="stylesheet">
    
    <rapid:block name="header_head">
            base_head_content
    </rapid:block>
    
</rapid:override>

<rapid:override name="content">  

     <header>
        <div class="container">
            <a href="/ECommerce/" class="logo"><span>e</span>.<span>S</span>tore.</a>

            <nav class="nav">
                <ul>
                    <li><a href="<c:url value='/shop' />">shop</a></li>
                    <li><a href="http://127.0.0.1:5501/blog.html">khuyen mai</a></li>
                    <li>
                        <i class="uil uil-shopping-cart-alt"></i>
                        <a href="#home" class="cart">Gio Hang</a>
                    </li>
                    <li class="login"><a href="loginPage" class="btn btn-primary"> Don Hang </a></li>
                </ul>
            </nav>

            <div class="fas fa-bars"></div>

        </div>
    </header>
    
    <rapid:block name="header_content">
            base_body_content
    </rapid:block>  
    
    
    <script src="<c:url value='/static/js/swiper-bundle.min.js' />" ></script>
    
    <script src="<c:url value='/static/js/script.js' />" ></script>
    
    <script src="<c:url value='/static/js/header_script.js' />" ></script>
    
    
    
</rapid:override>  
 
<%@ include file="base.jsp" %> 