<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Register ShopCart</title>
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
				<a class="active"><span class="icon-edit"></span> Free Register </a> 
				<a ><span class="icon-envelope"></span> Contact us</a>
				<a href="viewcart.jsp"><span class="icon-shopping-cart"></span>Cart Item(s)</span></a>
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
		  </div>
		</div>
	  </div>
	</div>
	
<!-- 
Body Section 
-->
<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
	 <li><a href="/OnlineBookStore/categoryviewservlet?Category=Biography"><span class="icon-chevron-right"></span>Biography</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Business"><span class="icon-chevron-right"></span>Business</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Finance"><span class="icon-chevron-right"></span>Finance</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Fashion"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Computers"><span class="icon-chevron-right"></span>Computers</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=History"><span class="icon-chevron-right"></span>History</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Children"><span class="icon-chevron-right"></span>Children</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Fiction"><span class="icon-chevron-right"></span>Fiction </a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Home"><span class="icon-chevron-right"></span>Home</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Crafts and Hobbies"><span class="icon-chevron-right"></span>Crafts and Hobbies</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Romance"><span class="icon-chevron-right"></span>Romance</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Science and Nature"><span class="icon-chevron-right"></span>Science and Nature</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Poetry"><span class="icon-chevron-right"></span>Poetry</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Comics"><span class="icon-chevron-right"></span>Comics</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Food and Wine"><span class="icon-chevron-right"></span>Food and Wine</a></li>
		<li style="border:0"> &nbsp;</li>	
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">	
		  </ul>
	</div>
	
	<div class="span9">
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="/OnlineBookStore/allBook">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	
<!-- Registration form -->
 
      <h3> Registration</h3>
      
   <form action= "RegisterControllerServlet" method="post">
	<hr class="soft"/>
	<div class="well">
	<div class="form-horizontal">
		<h3>Your Personal Details</h3>
		<div class="control-group">
		<label class="control-label">Title</label>
		<div class="controls">
		<select class="span1" name="days">
			<option value="">-</option>
			<option value="1">Mr.</option>
			<option value="2">Mrs</option>
			<option value="3">Miss</option>
		</select>
		</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputFname">First name <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="fname" id="fname" placeholder="First Name" required>
			</div>
		 </div>
		 <div class="control-group">
			<label class="control-label" for="inputLname">Last name <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="lname" id="lname" placeholder="Last Name" required>
			</div>
		 </div>
		<div class="control-group">
		<label class="control-label" for="inputEmail">Email <sup>*</sup></label>
		<div class="controls">
		  <input type="email" name="email" id="email" placeholder="Email" required>
		</div>
	  </div>	  
		<div class="control-group">
		<label class="control-label">Password <sup>*</sup></label>
		<div class="controls">
		  <input type="password" name="pwd" id="pwd1" placeholder="Password" required>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label">Confirm Password <sup>*</sup></label>
		<div class="controls">            
		  <input type="password" id="pwd2" placeholder="Password" onkeyup="checkPass(); return false;" required>
		  <span id="confirmMessage" class="confirmMessage"></span>
		</div>
	  </div>
	</div>
</div>

<script type="text/javascript">
function checkPass()
{
    //Store the password field
    var password1 = document.getElementById('pwd1');
    var password2 = document.getElementById('pwd2');
    var message = document.getElementById('confirmMessage');
    
    //Set the colors
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    
    //Compare the password fields 
    if(password1.value == password2.value){
        //The passwords match. 
        password2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }
    else{
        //The passwords do not match.
        password2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  
</script>
<div class="well">
	<div class="form-horizontal" >
		<h3>Your Address Details</h3>
		<div class="control-group">
			<label class="control-label">Street <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="street" id="street" placeholder=" Street" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">City <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="city" id="city" placeholder="City" required>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">Province <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="province" id="province" placeholder="Province" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Country <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="country" id="country" placeholder="Country" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">ZIP <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="zip" id="zip" placeholder="ZIP" required>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Phone <sup>*</sup></label>
			<div class="controls">
			  <input type="text" name="phone" id="phone" placeholder="phone" required>
			</div>
		</div>
	<div class="control-group">
		<div class="controls">
		 <button type="submit" name="submitAccount" value="Register" class="shopBtn exclusive">Register</button>
		</div>
	</div>
	</div>
	</div>
	</form>	
</div>
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

	