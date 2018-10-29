<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
  <%--=msg --%>
    <meta charset="utf-8">
    <title>Viewcart ShopCart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
  </head>
<body>
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a ><span class="icon-twitter"></span></a>
					<a ><span class="icon-facebook"></span></a>
					<a ><span class="icon-youtube"></span></a>
					<a ><span class="icon-tumblr"></span></a>
				</div>
				<a href="/OnlineBookStore/allBook"> <span class="icon-home"></span> Home</a> 
				<a ><span class="icon-user"></span> My Account</a> 
				<a ><span class="icon-edit"></span> Free Register </a> 
				<a ><span class="icon-envelope"></span> Contact us</a>
				<a class="active" href="viewcart.jsp"><span class="icon-shopping-cart"></span>Cart Item(s)</span></a>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.jsp"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0613 2528 951 </strong><br><br></p>
	<span class="btn btn-mini"><span class="icon-shopping-cart"></span></span>
	<span class="btn btn-warning btn-mini">$</span>
	<span class="btn btn-mini">&pound;</span>
	<span class="btn btn-mini">&euro;</span>
	</div>
</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
			  <li class="active"><a href="/OnlineBookStore/allBook">Home	</a></li>
			</ul>
			<form hidden action="#" class="navbar-search pull-left">
			  <input type="text" placeholder="Search" class="search-query span2">
			</form>
			<ul class="nav pull-right">	
			</ul>
		  </div>
		</div>
	  </div>
	</div>

<!-- 
Body Section 
-->
	<div class="row">
	<div class="span12">
    
	<div class="well well-small">
		<h1>Cart Items</h1>
	<hr class="soften"/>

    <table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Availability</th>
                  <th>Unit price</th>
                  <th>Qty </th>
				</tr>
              </thead>
              <tbody>
              
              <jsp:useBean id="items_in_cart" scope="session" class="com.org.book.cart.Cart"/>
	         <div>  
	           <c:forEach var="item" items="${items_in_cart.bookcart}" >
                <tr>
                  <td><img width="100" src="${item.image}" alt=""></td>
                  <td><c:out value="${item.title}"/><br>Author : <c:out value="${item.author}"/></td>
                  <td><span class="shopBtn"><span class="icon-ok"></span></span> </td>
                  <td>$<c:out value="${item.price}"/></td>
                  <td>
                  <c:out value="${item.quantity}"/>
				  <form style='display: inline'action="/OnlineBookStore/Cart" method="post">			
			           <input type ="hidden" name="title" value="${item.title}"> 
			           <input type ="hidden" name="author" value="${item.author}">
			           <input type ="hidden" name="quantity" value="${item.quantity}">
			           <input type ="hidden" name="bookid" value="${item.bookid}">
			           <input type ="hidden" name="price" value="${item.price}">
			           <input type="hidden" name="operation" value="add">
			           <input class="btn btn-mini btn-danger" type="Submit" value="+">
		          </form>
		          <form style='display: inline' action="/OnlineBookStore/Cart" method="post">
		               <input type ="hidden" name="title" value="${item.title}"> 
						<input type ="hidden" name="author" value="${item.author}">
						<input type ="hidden" name="quantity" value="${item.quantity}">
						<input type ="hidden" name="bookid" value="${item.bookid}">
						<input type ="hidden" name="price" value="${item.price}">
						<input type="hidden" name="operation" value="remove">
						<input class="btn btn-mini btn-danger" type="Submit" value="-">
				 </form>
				 	</td>
                </tr>
                </c:forEach>
                </div>
                
                <tr>
                  <td >Total products:	</td>
                  <td></td>
                  <td></td>
                  <td> $<c:out value="${items_in_cart.totalPrice}"/> </td>
                  <td></td>
                </tr>
				</tbody>
            </table><br/>
    
	<a href="/OnlineBookStore/allBook" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a>
	<c:set var="cartTotal" value="${items_in_cart.totalPrice}"/>
	<% 
		double CartTotal = (double) pageContext.getAttribute("cartTotal");
		if(CartTotal != 0) {
	%>
		<a href="/OnlineBookStore/CreateOrderServlet" class="shopBtn btn-large pull-right">Checkout <span class="icon-arrow-right"></span></a>
	<%
		}
	%>
</div>
</div>
</div>

<!-- 
Clients 
-->
<section class="our_client">
	<hr class="soften"/>
	<h4 class="title cntr"><span class="text"> Publishers</span></h4>
	<hr class="soften"/>
	<div class="row">
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer1.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer2.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer3.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer4.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer5.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer6.png"></a>
		</div>
	</div>
</section>

<!--
Footer
-->
<footer class="footer">
<div class="row-fluid">
<div class="span2">
<h5>Your Account</h5>
<a >YOUR ACCOUNT</a><br>
<a >PERSONAL INFORMATION</a><br>
<a >ADDRESSES</a><br>
<a >DISCOUNT</a><br>
<a >ORDER HISTORY</a><br>
 </div>
<div class="span2">
<h5>Information</h5>
<a >CONTACT</a><br>
<a >SITEMAP</a><br>
<a >LEGAL NOTICE</a><br>
<a >TERMS AND CONDITIONS</a><br>
<a >ABOUT US</a><br>
 </div>
<div class="span2">
<h5>Our Offer</h5>
<a >NEW PRODUCTS</a> <br>
<a >TOP SELLERS</a><br>
<a >SPECIALS</a><br>
<a >MANUFACTURERS</a><br>
<a >SUPPLIERS</a> <br/>
 </div>
 <div class="span6">
<h5>A Message to all book lovers:</h5>
"There is no friend as loyal as a Book"<br>
Maybe this is why we read, and why in moments of darkness we return to books: to find words for what we already know
 </div>
 </div>
</footer>
</div><!-- /container -->

<div class="copyright">
<div class="container">
	<p class="pull-right">
		<a ><img src="assets/img/maestro.png" alt="payment"></a>
		<a ><img src="assets/img/mc.png" alt="payment"></a>
		<a ><img src="assets/img/pp.png" alt="payment"></a>
		<a ><img src="assets/img/visa.png" alt="payment"></a>
		<a ><img src="assets/img/disc.png" alt="payment"></a>
	</p>
	<span>Copyright &copy; 2018<br> Shop Cart Online Bookstore</span>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
</html>
