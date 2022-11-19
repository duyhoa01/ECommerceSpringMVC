<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/product_detail_style.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

    <section class="font_page"></section>

    <section id="productdetails" class="section-p1">
        <div class="container">
            <div class="single-pro-image">
                <img src="./images/apple-iphone-12-mini-5.png" width="100%" id="MainImg" alt="">
    
                <div class="small-img-group">
    
                    <div class="small-img-col">
                        <img src="./images/iphone-12-den-new-600x600-600x600.jpg" width="100%" class="small-img"  alt="">
                    </div>
    
                    <div class="small-img-col">
                        <img src="./images/apple-iphone-12-mini-5.png" width="100%" class="small-img"  alt="">
                    </div>
    
                    <div class="small-img-col">
                        <img src="./images/apple-iphone-12-mini-5.png" width="100%" class="small-img"  alt="">
                    </div>
    
                    <div class="small-img-col">
                        <img src="./images/apple-iphone-12-mini-5.png" width="100%" class="small-img"  alt="">
                    </div>
    
                </div>
    
                
            </div>

            <div class="single-pro-details">
                <!-- <h3>Home / T-Shirt</h3> -->
                <h2>Men's Fashion T Shirt</h2>
                <h1>$139.00</h1>
                <select>
                    <option>Select Size</option>
                    <option>XL</option>
                    <option>L</option>
                    <option>M</option>
                    <option>S</option>
                </select>
                <input type="number" value="1">
                <button class="normal">Add To Cart</button>
                <!-- <h1>Nổi bật</h1>
                <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
                    Unde, eos? Nesciunt odit soluta, aut cum consequuntur quaerat,
                     nisi obcaecati exercitationem maxime architecto, 
                     molestias illo quos doloribus repellendus! Corrupti,
                      eius facilis?
                </span> -->
                <!-- <h5>Thông số kỹ thuật </h5> -->
                <table class="table table-striped">
                    <tbody>
                      <tr>
                        <td>Màn hình</td>
                        <td>6.7 inch, OLED, Super Retina XDR, 2778 x 1284 Pixels</td>
                      </tr>
                      <tr>
                        <td>Camera sau</td>
                        <td>2.0 MP + 12.0 MP + 12.0 MP</td>
                      </tr>
                      <tr>
                        <td>Camera Selfie</td>
                        <td>12.0 MP</td>
                      </tr>
                      <tr>
                        <td>RAM</td>
                        <td>6GB</td>
                      </tr>
                      <tr>
                        <td>Bộ nhớ trong</td>
                        <td>128 GB</td>
                      </tr>
                      <tr>
                        <td>CPU</td>
                        <td>Apple A15 Bionic</td>
                      </tr>
                      <tr>
                        <td>GPU</td>
                        <td>Apple GPU 5 nhân</td>
                      </tr>
                      <tr>
                        <td>Dung lượng pin</td>
                        <td>4352 mAh</td>
                      </tr>
                      <tr>
                        <td>Thẻ sim</td>
                        <td>1 - 1 eSIM, 1 Nano SIM</td>
                      </tr>
                      <tr>
                        <td>Hệ điều hành</td>
                        <td>iOS 15</td>
                      </tr>
                      <tr>
                        <td>Xuất xứ</td>
                        <td>Trung Quốc</td>
                      </tr>
                      <tr>
                        <td>Thời gian ra mắt</td>
                        <td>09/2021</td>
                      </tr>
                    </tbody>
                </table>
            </div>
        </div>
        
    </section>

    <section class="hightlights">

    </section>

    <section class="pro-same">
        <section class="slide-container swiper" >
            <div class="container">
    
                <!-- <h1 class="heading"><span>'</span> Top Deal<span>'</span></h1> -->
    
                <div class="slide-content">
                    <div class="card-wrapper swiper-wrapper">
                        <div class="pro swiper-slide">
                            <img src="./images/apple-iphone-12-mini-5.png" alt="">
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
                            <img src="./images/apple-iphone-12-mini-5.png" alt="">
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
                            <img src="./images/apple-iphone-12-mini-5.png" alt="">
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