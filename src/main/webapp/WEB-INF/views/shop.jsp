<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<rapid:override name="header_head"> 

    <link href="<c:url value='/static/css/shop_style.css' />" rel="stylesheet">
    
</rapid:override>

<rapid:override name="header_content">  

    <section class="font_page"></section>

    <section class="page">
        <div class="container">
            <div class="page__left">
                <form action="" >
                    <div class="search">
                        <input type="text" class="input-search" placeholder="Bạn tìm gì..." name="key"
                            maxlength="100" value="${key}" />
                        <button type="submit">
                            <i class="uil uil-search"></i>
                            <!-- <img src="./images/search.svg"> -->
                        </button>
                    </div>

                    <div class="feature">
                        <div class="fas fa-times"></div>

                        <div class="manufacturer">
                            <div class="name">
                                <span>Hãng sản xuất</span>
                            </div>
                            <div class="list_manfac">
                                <ul>
                                    <li>
                                        <input type="checkbox" name="manufacturer" value="0" <c:if test="${manufacturer.contains(Integer(0))}">checked="checked"</c:if> >
                                        <label for="man0">Tất cả</label><br>
                                    </li>
                                    <c:forEach var = "manu" items = "${manufacturers}">
	                                    <li>
	                                        <%-- <input type="checkbox" name="man1" value="2"> --%>
	                                        <input type = "checkbox" name = "manufacturer" value = "${manu.id}"  <c:if test="${manufacturer.contains(manu.id)}">checked="checked"</c:if>/>
	                                        <label for="man1">${manu.name}</label><br>
	                                    </li>
                                    </c:forEach>
                                </ul>

                            </div>
                        </div>

                        <div class="prince">
                            <div class="name">
                                <span>Giá</span>
                            </div>
                            <div class="list_manfac">
                                <ul>
                                    <li>
                                        <input type="checkbox" name="price" value="0">
                                        <label for="man0">Tất cả</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="price" value="1">
                                        <label for="man1">Dưới 2 triệu</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="price" value="2">
                                        <label for="man2">2 - 4 triệu</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="price" value="3">
                                        <label for="man3">4 - 7 triệu</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="price" value="4">
                                        <label for="man4">7 - 14 triệu</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="price" value="5">
                                        <label for="man5">trên 14 triệu</label><br>
                                    </li>
                                </ul>

                            </div>
                        </div>

                        <div class="pin">
                            <div class="name">
                                <span>Dung lượng pin</span>
                            </div>
                            <div class="list_manfac">
                                <ul>
                                    <li>
                                        <input type="checkbox" name="pin" value="0" <c:if test="${pin.contains(Integer(0))}">checked="checked"</c:if> >
                                        <label for="man0">Tất cả</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="pin" value="1" <c:if test="${pin.contains(Integer(1))}">checked="checked"</c:if>>
                                        <label for="man1">Dưới 3000mah</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="pin" value="2" <c:if test="${pin.contains(Integer(2))}">checked="checked"</c:if>>
                                        <label for="man2">3000 - 40000 mah</label><br>
                                    </li>
                                    <li>
                                        <input type="checkbox" name="pin" value="3"<c:if test="${pin.contains(Integer(3))}">checked="checked"</c:if> >
                                        <label for="man3">trên 4000 mah</label><br>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </div>

                    <button class="btn_feature" onclick="return false">
                        <span>Tính năng</span>
                    </button>

                </form>

            </div>

            <div class="page__main">
                <div class="main__header">
                    <div class="header__top">
                        <h1>Điện thoại</h1>
                        <p>(12 sản phẩm)</p>
                    </div>
                    <div class="header__bottom">
                        <h3>Lọc theo</h3>
                        <ul>
                            <li>sam sung</li>
                            <li>2 -4 triệu</li>
                        </ul>
                    </div>
                </div>
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
	                <tag:paginate offset="${offset}" count="${count}" key="${key}" steps="${3}" manufacturer="${manufacturer}" pin="${pin}" uri="" next="&raquo;" previous="&laquo;" />
	            </div>
            </div>
        </div>
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