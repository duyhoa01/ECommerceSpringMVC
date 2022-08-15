<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/style.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

     <section class="home">
        <div class="container">
            <div class="row min-vh-100 align-items-center text-center text-md-left">
                <div class="col-md-6 pr-md-5">
                    <img src="<c:url value='/static/images/online-shopping.svg' />" width="100%" alt="" />
                    <!-- </div> -->
                </div>

                <div class="col-md-6 pl-md-5 content">
                    <h1><span>Tiệc</span> to, <span>giảm</span> sốc.</h1>
                    <h3>ưu đãi dành cho bạn</h3>
                    <a href="#hotdeal"><button class="button">learn more</button></a>

                </div>
            </div>
        </div>
    </section>


    <section class="slide-container swiper">

        <div class="container">

            <h1 class="heading"><span>'</span> Top Deal<span>'</span></h1>

            <div class="slide-content">
                <div class="card-wrapper swiper-wrapper">
                    <div class="pro swiper-slide">
                        <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                        <div class="des">
                            <span>apple</span>
                            <h5>iphone 12 pro max 128GB</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>20.199.000 đ</h4>
                            <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                        </div>
                    </div>
                    <div class="pro swiper-slide">
                        <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                        <div class="des">
                            <span>apple</span>
                            <h5>iphone 14 pro max 128GB</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>20.199.000 đ</h4>
                            <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                        </div>
                    </div>
                    <div class="pro swiper-slide">
                        <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                        <div class="des">
                            <span>apple</span>
                            <h5>iphone 15 pro max 128GB</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>20.199.000 đ</h4>
                            <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                        </div>
                    </div> 
                </div>
            </div>

            <div class="swiper-button-next swiper-navBtn"></div>
            <div class="swiper-button-prev swiper-navBtn"></div>
            <div class="swiper-pagination"></div>
        </div>

    </section>

    <section class="hot-container swier">

        <section class="slide-container swiper">
            <div class="container">

                <h1 class="heading"><span>'</span> Top Hot<span>'</span></h1>

                <div class="slide-content">
                    <div class="card-wrapper swiper-wrapper">
                        <div class="pro swiper-slide">
                            <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                            <div class="des">
                                <span>apple</span>
                                <h5>iphone 12 pro max 128GB</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <h4>20.199.000 đ</h4>
                                <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                            </div>
                        </div>
                        <div class="pro swiper-slide">
                            <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                            <div class="des">
                                <span>apple</span>
                                <h5>iphone 12 pro max 128GB</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <h4>20.199.000 đ</h4>
                                <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                            </div>
                        </div>
                        <div class="pro swiper-slide">
                            <img src="<c:url value='/static/images/apple-iphone-12-mini-5.png' />" alt="">
                            <div class="des">
                                <span>apple</span>
                                <h5>iphone 12 pro max 128GB</h5>
                                <div class="star">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                </div>
                                <h4>20.199.000 đ</h4>
                                <a href="#"><i class="fas fa-shopping-cart cart"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="swiper-button-next swiper-navBtn"></div>
                <div class="swiper-button-prev swiper-navBtn"></div>
                <div class="swiper-pagination"></div>
            </div>

        </section>

    </section>

    <section class="footer">

        <div class="container">

            <div class="row">

                <div class="col-md-4">
                    <a href="#" class="logo"><span>H</span>ealth<span>C</span>are.</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Numquam optio facere ab iure
                            explicabo quae itaque? Obcaecati aliquam explicabo quis. Aliquam commodi minima unde
                            excepturi?
                            Aspernatur voluptatum suscipit repellendus ea?</p>
                </div>

                <div class="col-md-4 text-center">
                    <h3>links</h3>
                    <a href="#">home</a>
                    <a href="#">about</a>
                    <a href="#">facility</a>
                    <a href="#">review</a>
                    <a href="#">contact</a>
                </div>

                <div class="col-md-4 text-center">
                    <h3>Share</h3>
                    <a href="#">facebook</a>
                    <a href="#">twitter</a>
                    <a href="#">instagram</a>
                    <a href="#">github</a>
                </div>

            </div>

        </div>

        <h1 class="credit text-center mx-auto">create by <span>mr. Hoa</span></h1>

    </section>
    
</rapid:override>  
 
<%@ include file="header.jsp" %> 