
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Fake News Detection</title>
        <!-- custom-theme -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Mastering Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //custom-theme -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/JiSlider.css" rel="stylesheet"> 
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />

        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
        <!-- font-awesome-icons -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome-icons -->
        <link href="//fonts.googleapis.com/css?family=Raleway:400,400i,500,500i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
    </head>

    <body>
        <!-- banner -->
        <div class="main_section_agile">
            <div class="w3_agile_banner_top">
                <div class="agile_phone_mail">
                    <ul class="agile_forms">
                    </ul>
                    <ul>
                        <li><i class="fa fa-phone" aria-hidden="true"></i>+91 8805559131</li>
                        <li><i class="fa fa-envelope" aria-hidden="true"></i><a href="gmail.com">Education@gmail.com</a></li>
                    </ul>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="agileits_w3layouts_banner_nav">
                <nav class="navbar navbar-default">
                    <div class="navbar-header navbar-left">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <h1><a class="navbar-brand" href="index.jsp"><i>Fake</i><span> News Detection</span></a></h1>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
                        <nav class="menu--iris">
                            <ul class="nav navbar-nav menu__list">
                                <li class="menu__item menu__item--current"><a href="index.jsp" class="menu__link">Home</a></li>
                                <li><a class="active" href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-sign-in" aria-hidden="true"></i> Admin Login</a> </li>
                                <li><a class="active" href="#" data-toggle="modal" data-target="#myModal3"><i class="fa fa-sign-in" aria-hidden="true"></i> user Login</a></li>
                                <li><a href="#" data-toggle="modal" data-target="#myModal5"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> User Registration</a> </li>
                            </ul>
                        </nav>
                    </div>
                </nav>
            </div>
        </div>
        <!-- banner -->
        <div class="banner-silder">
            <div id="JiSlider" class="jislider">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>

                                <div class="signin-form profile">
                                    <h3 class="agileinfo_sign">Update Password</h3>	
                                    <div class="login-form">
                                        <form action="UpdatePass" method="post">
                                            <input type="email" name="email" placeholder="Enter Your Email" required="">
                                            <input type="password" name="pass" placeholder="Enter Your Password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers.">
                                            <div class="tp">
                                                <input type="submit" value="Submit">
                                                <input type="reset" value="Reset">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>

        <!-- //banner -->
        <!-- Modal1 -->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>

                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">Admin Login</h3>	
                            <div class="login-form">
                                <form action="AdminLogin" method="post">
                                    <input type="text" name="name" placeholder="Admin Name" required="">
                                    <input type="password" name="pass" placeholder="Password" required="">
                                    <div class="tp">
                                        <input type="submit" value="Sign In">
                                        <input type="reset" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModal3" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>

                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">User Login</h3>	
                            <div class="login-form">
                                <form action="UserLogin" method="post">
                                    <input type="text" name="uname" placeholder="Username" required="">
                                    <input type="password" name="pass" placeholder="Password" required="">
                                    <div class="tp">
                                        <input type="submit" value="Sign In">
                                        <input type="reset" value="Reset">
                                    </div>
                                </form>
                            </div>
                            <div class="login-social-grids">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-rss"></i></a></li>
                                </ul>
                            </div>
                            <p><a href="#" data-toggle="modal" data-target="#myModa21" > Forgot Password?</a></p>
                            <p><a href="#" data-toggle="modal" data-target="#myModal5" > Don't have an account?</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModa21" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>

                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">Forgot Password</h3>	
                            <div class="login-form">
                                <form action="SendOTP" method="post">
                                    <input type="email" name="email" placeholder="Please Enter Mail Address" required="">
                                    <div class="tp">
                                        <input type="submit" value="Submit">
                                        <input type="reset" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="myModal5" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">User Registration</h3>	
                            <div class="login-form">
                                <form action="Reg" method="post">
                                    <input type="text" name="fname" placeholder="First Name" required="">
                                    <input type="text" name="lname" placeholder="Last Name" required="">
                                    <input type="email" name="email" placeholder="Email" required pattern="[a-z]+.[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter Valid Email Address.">
                                    <input type="text" name="mob" placeholder="Mobile Number" required pattern="[7-9]{1}[0-9]{9}" title="Phone number with 7-9 and remaing 9 digit with 0-9">
                                    <input type="text" name="tid" placeholder="Twitter Id" required="">
                                    <input type="text" name="username" placeholder="Username" required="">
                                    <input type="password" name="pass" placeholder="Password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers.">
                                    <input type="submit" value="Sign Up">
                                    <input type="reset" value="Reset">
                                </form>
                            </div>
                            <p><a href="#"> By clicking register, I agree to your terms</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                </div>
            </div>
        </div>



        <!-- //stats -->

        <!-- testimonials -->		


        <!-- //testimonials -->	

        <!-- footer -->

    <center>  <p>© 2020 Fake News Detection Project. All Rights Reserved. <a href="https://.com/" target="_blank"></a></p></center>

    <!-- //footer -->
    <!-- start-smoth-scrolling -->
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <script src="js/JiSlider.js"></script>
    <script>
        $(window).load(function () {
            $('#JiSlider').JiSlider({color: '#fff', start: 3, reverse: true}).addClass('ff')
        })
    </script><script type="text/javascript">

        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-36251023-1']);
        _gaq.push(['_setDomainName', 'jqueryscript.net']);
        _gaq.push(['_trackPageview']);

        (function () {
            var ga = document.createElement('script');
            ga.type = 'text/javascript';
            ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0];
            s.parentNode.insertBefore(ga, s);
        })();

    </script>
    <!-- stats -->
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.countup.js"></script>
    <script>
        $('.counter').countUp();
    </script>
    <!-- //stats -->
    <!-- //footer -->
    <!-- flexSlider -->
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            $('.flexslider').flexslider({
                animation: "slide",
                start: function (slider) {
                    $('body').removeClass('loading');
                }
            });
        });
    </script>
    <!-- //flexSlider -->


    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <!-- for bootstrap working -->
    <script src="js/bootstrap.js"></script>
    <!-- //for bootstrap working -->
    <!-- here stars scrolling icon -->
    <script type="text/javascript">
        $(document).ready(function () {
            /*
             var defaults = {
             containerID: 'toTop', // fading element id
             containerHoverID: 'toTopHover', // fading element hover id
             scrollSpeed: 1200,
             easingType: 'linear' 
             };
             */

            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <!-- //here ends scrolling icon -->
</body>
</html>