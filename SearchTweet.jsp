<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="twitter4j.QueryResult"%>
<%@page import="twitter4j.Query"%>
<%@page import="java.util.List"%>
<%@page import="twitter4j.Status"%>
<%@page import="twitter4j.TwitterFactory"%>
<%@page import="twitter4j.Twitter"%>
<%@page import="twitter4j.conf.ConfigurationBuilder"%>
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
                                <li class="menu__item menu__item--current"><a href="AdminHome.jsp" class="menu__link">Home</a></li>
                                <li><a class="active" href="#" data-toggle="modal" data-target="#myModal7"><i class="fa fa-sign-in" aria-hidden="true"></i>Search Tweet's</a></li>
                                <!--                                <li class="menu__item"><a href="AdminViewDRInfo.jsp" class="menu__link">Search Tweet's</a></li>-->
                                <li class="menu__item"><a href="AdminViewInfo.jsp" class="menu__link">View Analysis</a></li>
                                <li class="menu__item"><a href="AdminViewUser.jsp" class="menu__link">View User</a></li>
                                <li class="menu__item"><a href="Logout" class="menu__link">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </nav>
            </div>
        </div>
        <!-- banner -->
        <!--        <div class="banner-silder">
                    <div id="JiSlider" class="jislider">
                        <ul>
                            <li>
                                <div class="w3layouts-banner-top">
        
                                    <div class="container">
                                                
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="w3layouts-banner-top w3layouts-banner-top1">
                                    <div class="container">
                                                
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="w3layouts-banner-top w3layouts-banner-top2">
                                    <div class="container">
                                                
        
                                    </div>
                                </div>
                            </li>
        
                        </ul>
                    </div>
                </div>-->
        
       

        <div class="modal fade" id="myModal7" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">Search Tweet's</h3>	
                            <div class="login-form">
                                <form action="SearchTweet.jsp" autocomplete="off">
                                    Search Tweet:- &nbsp;<input type="text" name="stweet" placeholder="Search Tweet" required="">
                                    
                                    <input type="submit" value="Search">
                                    <input type="reset" value="Reset">
                                </form>
                            </div>
                            <p><a href="#"> By clicking register, I agree to your terms</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //banner -->
        <!-- Modal1 -->
        


<!-- //Modal2 -->	

<!-- bootstrap-pop-up -->
<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
    <div class="modal-dialog" role="document">
        <div class="post_section">

                                    <%
                                        String query = request.getParameter("stweet");
                                        System.out.print("Query="+query);
                                        session.setAttribute("search_query", query);
                                        String tweet, clean_tweet;
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/social", "root", "system");
                                    %>
                                 
                                </div>
    </div>
</div>
<!-- //bootstrap-pop-up -->
<!-- banner-bottom -->
<!--<br><h3 class="w3l_header w3_agileits_header">WELCOME <% out.println(session.getAttribute("uname"));%> <span></span></h3>-->
<!-- //services -->

<!-- blog -->
<div class="blog" id="blog">
    <div class="container">

        <h3 class="w3l_header w3_agileits_header"> Search Results for  <span>  <%out.println(query);%></span></h3>
        <div class="agile_inner_w3ls-grids">
            <div>
  

                <a href="Predict"><h3>Click Here To Know Predictions Of:: <%out.println(query);%></h3></a><br>

                                    <% ConfigurationBuilder cb = new ConfigurationBuilder();
                                        cb.setDebugEnabled(true)
                                                .setOAuthConsumerKey("MpFkaTo09lcaViPXhhVSerB9J")
                                                .setOAuthConsumerSecret("4rYYSSLeqXTbxOW4iu4IJNRJ7VlmTvFGvze2w5yT5LDGEBFm9q")
                                                .setOAuthAccessToken("1064413053612187654-I15f71ops5sWd48WbBblKrm7VnmhPS")
                                                .setOAuthAccessTokenSecret("eaD6DdwZcT6rbVZvgmDCDqZEMiovOdjNE7c3aK7LDJ7KW");
                                        // .setOAuthConsumerKey("6ECBhguW5yvexhr8YGqWtnWVX")
                                        //.setOAuthConsumerSecret("vEe6Cf77n0ZyEMd25uy2EX5TfVKLo5omVFgqDxrCciWOsYl7SE")
                                        //.setOAuthAccessToken("2374984802-kjKt3HzMVO7RzmDOfnXVSD3Qj3G47VAUQOQkabg")
                                        //.setOAuthAccessTokenSecret("wIAk3MGqQyHpjar1li3o4KoiJ9fCKEA7XnVChWNP9O64F");

                                        TwitterFactory tf = new TwitterFactory(cb.build());
                                        Twitter twitter = tf.getInstance();
                                        List<Status> statuses = twitter.getHomeTimeline();
                                        Query query1 = new Query(query);
                                        QueryResult result = twitter.search(query1);
                                        for (Status status : result.getTweets()) {

                                    %>
                                    <p>
                                        <p><b><%out.println(status.getUser().getName() + ":");%>
                                            </b><%out.println(status.getText());%></p><br>

                                            <h2> &nbsp;</h2>
                                    </p>
                                    <%
                                            tweet = status.getText();
                                            clean_tweet = tweet.replaceAll("[^A-Z a-z]", "");
                                            System.out.println("preprocessed tweet:" + clean_tweet);
                                            PreparedStatement ps = cn.prepareStatement("insert into tweettab values(?,?)");

                                            ps.setString(1, status.getUser().getScreenName().toString());
                                            ps.setString(2, clean_tweet);
                                            ps.execute();
                                            String[] token = clean_tweet.split(" ");
                                            for (int i = 0; i < token.length; i++) {
                                                System.out.println(token[i].toString().trim());
                                            }

                                        }
                                    %>   
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //blog -->
<!-- stats -->

<!-- //stats -->

<!-- testimonials -->		


<!-- //testimonials -->	

<!-- footer -->

    <center>  <p><b>© 2020 Fake News Detection Project. All Rights Reserved.</b> <a href="https://.com/" target="_blank"></a></p></center>

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