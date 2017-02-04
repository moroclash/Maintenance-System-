<%-- 
    Document   : Home
    Created on : Mar 28, 2016, 7:23:50 PM
    Author     : moroclash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Creatio Website Template | Home :: w3layouts</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="description" content="We are a company specializing in the repair of all electrical appliances of all kinds .. you can connect with us by our websuite .. We will get to you wherever you are ">
        <meta name="keywords" content="Fix Devises in Egypt,maintenance company in egypt ,repair electronic devices in egypt"> <!-- lsaa hnktp tany -->
        <!--[if lt IE 9]>
                <script src="js/html5shiv.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <!---strat-slider---->
        <link rel="stylesheet" type="text/css" href="css/slider.css" />
        <script type="text/javascript" src="js/modernizr.custom.28468.js"></script>
        <script type="text/javascript" src="js/jquery.cslider.js"></script>
        <script type="text/javascript">
            $(function () {

                $('#da-slider').cslider({
                    autoplay: true,
                    bgincrement: 450
                });

            });
        </script>
        <!---//strat-slider---->
        <!-- scroll -->
        <script type="text/javascript">
            $(document).ready(function () {

                var defaults = {
                    containerID: 'toTop', // fading element id
                    containerHoverID: 'toTopHover', // fading element hover id
                    scrollSpeed: 1200,
                    easingType: 'linear'
                };


                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!-- //scroll -->	
        <!-- start portfolios -->
        <link href="css/portfolio.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/fliplightbox.min.js"></script>
        <script type="text/javascript">
            $('body').flipLightBox()
        </script>
        <script type="text/javascript" src="js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
        <script type="text/javascript">
            $(function () {

                var filterList = {
                    init: function () {

                        // MixItUp plugin
                        // http://mixitup.io
                        $('#portfoliolist').mixitup({
                            targetSelector: '.portfolio',
                            filterSelector: '.filter',
                            effects: ['fade'],
                            easing: 'snap',
                            // call the hover effect
                            onMixEnd: filterList.hoverEffect()
                        });

                    },
                    hoverEffect: function () {

                        // Simple parallax effect
                        $('#portfoliolist .portfolio').hover(function () {
                            $(this).find('.label').stop().animate({
                                bottom: 0
                            }, 200, 'easeOutQuad');
                            $(this).find('img').stop().animate({
                                top: -40
                            }, 500, 'easeOutQuad');
                        }, function () {
                            $(this).find('.label').stop().animate({
                                bottom: -40
                            }, 200, 'easeInQuad');
                            $(this).find('img').stop().animate({
                                top: 0
                            }, 300, 'easeOutQuad');
                        });

                    }
                };

                // Run the show!
                filterList.init();

            });
        </script>
        <!-- popup -->
        <link rel="stylesheet" type="text/css" href="css/magnific-popup1.css">
        <link rel="stylesheet" type="text/css" href="css/magnific-popup.css">
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });
            });
        </script>
        <script type="text/javascript" src="js/jquery.lightbox.js"></script>
        <link rel="stylesheet" type="text/css" href="css/lightbox.css" media="screen" />
        <script type="text/javascript">
            $(function () {
                $('#portfoliolist a').lightBox();
            });
        </script>
        <!-- nav -->  
        <script type="text/javascript" 	src="js/jquery.smint.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.subMenu').smint({
                    'scrollSpeed': 1000
                });
            });
        </script>
        <script>
            window.addEventListener("load", function () {
                setTimeout(function () {
                    window.scrollTo(0, 1);
                }, 0);
            });</script>
    </head>
    <body>
        <!-- start slider -->
        <div class="slider_bg s7">
            <!-- start main -->
            <!---start-da-slider----->
            <div id="da-slider" class="da-slider">
                <div class="da-slide">
                    <h2 class="title">Repair  </h2>
                    <h3 class="title">All Electrical Devices</h3>
                    <p class="description">TV's.Refrigerators.Washers.etc</p>  
                </div>
                <div class="da-slide">
                    <h2 class="title">All brands</h2>
                    <h3 class="title">Toshpa.Sony.LG</h3>
                    <p class="description">Samsang. zanussi . Sharpe</p> 
                </div>
                <div class="da-slide">
                    <h2 class="title">Registe</h2>
                    <h3 class="title">To Connect with us</h3>
                    <p class="description">Quick and excellent service</p> 
                </div>
                <div class="da-slide">
                    <h2 class="title">Branches</h2>
                    <h3 class="title">all over Egypt</h3>
                    <p class="description">Cairo . Giza . Other</p> 
                </div>	
                <div class="da-slide">
                    <h2 class="title">Experience</h2>
                    <h3 class="title">,High efficiency</h3>
                    <p class="description">Technical and Service</p> 
                </div>
            </div>
            <!---//End-da-slider----->
        </div>
        <a  href="#services" class="button scroll"><img src="images/arrow.png"></a>	
        <!-- start header -->
        <div class="header">
            <div class="logo">
                <a  href="#s7" class="scroll"><img src="images/logo.png"></a>
            </div>
            <!-- start top-nav-->
            <div class="h_right">	
                <div class="subMenu" >
                    <div class="wrap">
                        <div class="inner">
                            <a href="#" id="sTop" class="subNavBtn">Home</a> 
                            <a href="#" id="s1" class="subNavBtn">Brands</a>
                            <a href="#" id="s2" class="subNavBtn">SERVICES</a>
                            <a href="#" id="s3" class="subNavBtn">ABOUT US</a>
                            <a href="#" id="s4" class="subNavBtn">Connect US</a>
                        </div>
                        <!-- /.navbar-collapse -->
                        <a id="s7" class="right-msg subNavBtn msg-icon"href="#"><span> </span></a>
                        <div class="clearfix"> </div>		
                    </div>	
                </div>
                <!-- start smart_nav * -->
                <nav class="nav">
                    <ul class="nav-list">
                        <li class="nav-item"><a href="#services">Home</a></li>
                        <li class="nav-item"><a href="#work" class="scroll">Brands</a></li>
                        <li class="nav-item"><a href="#about" class="scroll">SERVICES</a></li>
                        <li class="nav-item"><a href="#blog" class="scroll">ABOUT US</a></li>
                        <li class="nav-item"><a href="#studio" class="scroll">Connect US</a></li>
                        <div class="clear"></div>
                    </ul>
                </nav>
                <script type="text/javascript" src="js/responsive.menu.js"></script>
                <!-- end smart_nav * -->
            </div>
            <div class="clear"></div>
        </div>
        <!---//End-header--->	
        <!--- Home --->	
        <div class="services sTop" id="services">
            <div class="wrap">
                <h3>Connect With US</h3>
                <p>Call on Mobile  or Regist in Websuite</p>
                <div class="col_1_of_3 span_1_of_3">
                    <img src="images/service1.png" alt="Connect us">
                    <h4><a href="#">Registe</a></h4>
                    <p>The Connection is very Easy ,Faster , Efficiency , High Performance.</p>
                    <p><a href="#">Registe</a></p>
                </div>
                <div class="col_1_of_3 span_1_of_3">
                    <img src="images/service3.png" alt="">
                    <h4><a href="#">Track</a></h4>
                    <p>you can track your device and connect with service to tell you what's new</p>
                    <p><a  href="#">see</a></p>
                </div>
                <div class="col_1_of_3 span_1_of_3">
                    <img src="images/service2.png" alt="">
                    <h4><a href="#">Feedback</a></h4>
                    <p>you can tell us the feedback about Tecnicals , Service , System ,and you can make Complain</p>
                    <p><a href="#">see</a></p>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="portfoliO s1" id="work"><!-- start portfoli1 -->
            <div class="wrap">	
                <h3>Brands</h3>
                <p>Fix all electronic prands</p>
                <div class="container"><!-- start container -->		 
                    <!-- start h_menu -->
                    <div class="h_menu">
                        <ul class="flexy-menu thick orange">
                            <li class="active mm"> <span class="filter active" data-filter="app card icon web">VIEW ALL</span></li>
                            <li class="mm"><span class="filter" data-filter="app  icon">Tv</span></li>
                            <li class="mm"><span class="filter" data-filter="card ">Washers</span></li>				            
                            <li class="mm"><span class="filter" data-filter="icon app card ">air conditioner</span></li>
                            <li class="mm"><span class="filter" data-filter="web card icon">Other</span></li>
                        </ul>
                    </div>	<!-- end h_menu -->
                    <script type="text/javascript" src="js/flexy-menu.js"></script>
                    <link href="css/header_style1.css" rel="stylesheet" type="text/css" media="all" />
                    <script type="text/javascript">$(document).ready(function () {
                $(".flexy-menu").flexymenu({speed: 400, type: "horizontal", align: "right"});
            });</script>

                    <!-- end smart_nav * -->
                    <ul id="filters" class="clearfix">
                        <li>
                            <span class="filter active" data-filter="app card icon web">VIEW ALL</span>
                        </li>
                        <li>
                            <span class="filter" data-filter="app  icon">Tv</span>
                        </li>
                        <li>
                            <span class="filter" data-filter="card ">Washers</span>
                        </li>
                        <li>
                            <span class="filter" data-filter="icon app card ">air conditioner</span>
                        </li>
                        <li>
                            <span class="filter" data-filter="web card icon">Other</span>
                        </li>
                    </ul>

                    <div id="portfoliolist">
                        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_1rsz_1carrier.png" alt="Image 2" style="top: 0px;"> </a>
                                <a href="images/port.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_rsz_gsmarena_001.jpg" alt="Image 2" style="top: 0px;"> </a>

                            </div>
                        </div>						
                        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port1.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_rsz_black-and-decker.jpg" alt="Image 2" style="top: 0px;"> </a>								
                            </div>
                        </div>
                        <div class="portfolio web mix_all" data-cat="web" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port2.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_rsz_samsung-logo-hd-wallpapers.jpg" alt="Image 2" style="top: 0px;"> </a>							
                            </div>
                        </div>   
                        <div class="portfolio card mix_all" data-cat="card" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port3.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_1rsz_panasonic_logo.jpg" alt="Image 2" style="top: 0px;"> </a>

                            </div>
                        </div>
                        <div class="portfolio web mix_all" data-cat="web" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port4.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_sharpe--logo.jpg" alt="Image 2" style="top: 0px;"> </a>

                            </div>
                        </div>
                        <div class="portfolio app mix_all" data-cat="app" style="display: inline-block; opacity: 1;">
                            <div class="portfolio-wrapper">
                                <a href="images/port5.jpg #small-dialog1" class="flipLightBox popup-with-zoom-anim"><img src="images/rsz_1rsz_toshiba-logo-on-its-netbook.jpg" alt="Image 5" style="top: 0px;"> </a>

                            </div>
                        </div>

                    </div>				
                </div>	
                <div class="img">
                    <a href="#"><img src="images/zoom.png" alt=""></a>	
                </div>						
            </div><!-- end container -->
        </div>
        <!----start-team-members---->
        <div class="team-members s2" id="about">
            <div class="wrap"> 
                <div class="tm-head">
                    <h3>Service</h3>
                    <p>We her to repair your Device.</p>
                </div>
                <div class="tm-head-grids">
                    <div class="tm-head-grid">
                        <img src="images/rsz_star-clean-and-maintenance-1.jpg" alt="" />
                        <h4>Fix your device</h4>
                        <h5>Call us</h5>
                        <ul class="top-social-icons">
                            <div class="clear"> </div>
                        </ul>
                    </div>
                    <div class="tm-head-grid">
                        <img src="images/rsz_house-maintenance.jpg" alt="" />
                        <h4>Comming</h4>
                        <h5>to home</h5>
                        <ul class="top-social-icons">
                            <div class="clear"> </div>
                        </ul>   
                    </div>
                    <div class="tm-head-grid">
                        <img src="images/rsz_maintenance.jpg" alt="" />
                        <h4>Connect with Company</h4>
                        <h5>in websuite</h5>
                        <ul class="top-social-icons">
                            <div class="clear"> </div>
                        </ul>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
        </div>
        <!----//End-team-members----> 
        <!----start-blog---->
        <div class="blog s3" id="blog">
            <div class="wrap"> 
                <div class="blog-head">
                    <h3>BLOG</h3>
                    <p>Proin iaculis purus consequat sem cure.</p>
                </div>
                <div class="blog-grid">
                    <div class="blog-left">
                        <div class="img-left">
                            <img src="images/blog1.jpg" alt="" />
                        </div>	
                        <div class="text-right">
                            <h6>March 29, 2014</h6>
                            <h3><a href="#">A NEW INVENTION FOR LOVERS WHO LOVE</a></h3>
                            <img src="images/line.png" alt="" />
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum ....</p>
                            <p><a href="#">MORE</a></p>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="blog-right">
                        <div class="img-left">
                            <img src="images/blog2.jpg" alt="" />
                        </div>	
                        <div class="text-right">
                            <h6>March 29, 2014</h6>
                            <h3><a href="#">A NEW INVENTION FOR LOVERS WHO LOVE</a></h3>
                            <img src="images/line.png" alt="" />
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum ....</p>
                            <p><a href="#">MORE</a></p>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="blog-grid">
                    <div class="blog-left">
                        <div class="img-left">
                            <img src="images/blog3.jpg" alt="" />
                        </div>	
                        <div class="text-right">
                            <h6>March 29, 2014</h6>
                            <h3><a href="#">A NEW INVENTION FOR LOVERS WHO LOVE</a></h3>
                            <img src="images/line.png" alt="" />
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum ....</p>
                            <p><a href="#">MORE</a></p>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="blog-right">
                        <div class="img-left">
                            <img src="images/blog4.jpg" alt="" />
                        </div>	
                        <div class="text-right">
                            <h6>March 29, 2014</h6>
                            <h3><a href="#">A NEW INVENTION FOR LOVERS WHO LOVE</a></h3>
                            <img src="images/line.png" alt="" />
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum ....</p>
                            <p><a href="#">MORE</a></p>
                        </div>
                        <div class="clear"> </div>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
        </div>
        <!----//End-blog----> 
        <div class="pricing s5" id="pricing">
            <div class="wrap"> 																						
                <!-----pop-up-grid---->
                <div id="small-dialog" class="mfp-hide">
                    <div class="pop_up">
                        <div class="payment-online-form-left">
                            <form>
                                <h4><span class="shipping"> </span>Shipping</h4>
                                <ul>
                                    <li><input class="text-box-dark" type="text" value="Frist Name" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Frist Name';
                                            }"></li>
                                    <li><input class="text-box-dark" type="text" value="Last Name" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Last Name';
                                            }"></li>
                                </ul>
                                <ul>
                                    <li><input class="text-box-dark" type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Email';
                                            }"></li>
                                    <li><input class="text-box-dark" type="text" value="Company Name" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Company Name';
                                            }"></li>
                                </ul>
                                <ul>
                                    <li><input class="text-box-dark" type="text" value="Phone" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Phone';
                                            }"></li>
                                    <li><input class="text-box-dark" type="text" value="Address" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Address';}"></li>
                                    <div class="clear"> </div>
                                </ul>
                                <div class="clear"> </div>
                                <ul class="payment-type">
                                    <h4><span class="payment"> </span> Payments</h4>
                                    <li><span class="col_checkbox">
                                            <input id="3" class="css-checkbox1" type="checkbox">
                                            <label for="3" name="demo_lbl_1" class="css-label1"> </label>
                                            <a class="visa" href="#"> </a>
                                        </span>

                                    </li>
                                    <li>
                                        <span class="col_checkbox">
                                            <input id="4" class="css-checkbox2" type="checkbox">
                                            <label for="4" name="demo_lbl_2" class="css-label2"> </label>
                                            <a class="paypal" href="#"> </a>
                                        </span>
                                    </li>
                                    <div class="clear"> </div>
                                </ul>
                                <ul>
                                    <li><input class="text-box-dark" type="text" value="Card Number" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Card Number';
                                            }"></li>
                                    <li><input class="text-box-dark" type="text" value="Name on card" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Name on card';}"></li>
                                    <div class="clear"> </div>
                                </ul>
                                <ul>
                                    <li><input class="text-box-light hasDatepicker" type="text" id="datepicker" value="Expiration Date" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Expiration Date';
                                            }"><em class="pay-date"> </em></li>
                                    <li><input class="text-box-dark" type="text" value="Security Code" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Security Code';
                                            }"></li>
                                    <div class="clear"> </div>
                                </ul>
                                <ul class="payment-sendbtns">
                                    <li><input type="reset" value="Cancel"></li>
                                    <li><input type="submit" value="Process order"></li>
                                </ul>
                                <div class="clear"> </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-----pop-up-grid---->
            </div>
            <div class="clear"> </div>
        </div>
    </div>
    <!-----logos---->	
    <div class="logos"> 
        <div class="wrap"> 
            <ul>
                <li><img src="images/client6.png" alt="" /></li>
                <li><img src="images/client7.png" alt="" /></li>
                <li><img src="images/client8.png" alt="" /></li>
            </ul>
        </div>
    </div>
    <!-----cntact---->	
    <div class="contact s6" id="contact">
        <div class="wrap">
            <h3>CONTACT US</h3>
            <p>Proin iaculis purus consequat sem cure.</p>	
            <div class="contact_form">
                <form method="post" action="contact-post.html">
                    <span><input type="text" value="NAME" onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'NAME';}"><label><img src="images/con1.png" alt="" /></label></span>									    
                    <span class="left"><input type="text" value="EMAIL" onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'EMAIL';}"><label><img src="images/con2.png" alt="" /></label></span>
                    <div class="clear"></div>
                    <span><textarea placeholder="MESSAGE"></textarea><label1><img src="images/con3.png" alt="" /></label1></span>
                    <input type="submit" class="" value="Submit">
                </form>
            </div>
        </div>
    </div>
    <div class="map">
        <iframe width="100%" height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265&amp;output=embed"></iframe><br><small><a href="https://maps.google.co.in/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Lighthouse+Point,+FL,+United+States&amp;aq=4&amp;oq=light&amp;sll=26.275636,-80.087265&amp;sspn=0.04941,0.104628&amp;ie=UTF8&amp;hq=&amp;hnear=Lighthouse+Point,+Broward,+Florida,+United+States&amp;t=m&amp;z=14&amp;ll=26.275636,-80.087265" style="color:#666;text-align:left;font-size:12px"></a></small>
    </div>
    <div class="signup">
        <div class="form">	
            <span><label><img src="images/msg.png" alt="" /></label><input type="text" value="Your E-MAIL Please?" onfocus="this.value = '';" onblur="if (this.value == '') {
                        this.value = 'Your E-MAIL Please?';
                    }"></span>
            <span><input type="submit" value="Sign Up Now" id="submit" name="submit"></span>
            <p>Promise we do not spam : )</p>
            <div class="clear"> </div>
        </div>
    </div>
  
    <!-- scroll_top_btn -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
                jQuery(document).ready(function ($) {
                    $(".scroll").click(function (event) {
                        event.preventDefault();
                        $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                    });
                });
    </script>

    <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
</body>
</html>
