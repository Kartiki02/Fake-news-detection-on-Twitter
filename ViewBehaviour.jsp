
<%@page import="java.sql.ResultSet"%>
<%@page import="util.DbUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

    <%
        String pt1 = session.getAttribute("pt").toString();
        String nt1 = session.getAttribute("nt").toString();
        String tt1 = session.getAttribute("tt").toString();
        String rt1 = session.getAttribute("rt").toString();

        String happy = session.getAttribute("happy").toString();
        String anger = session.getAttribute("anger").toString();
        String neutral = session.getAttribute("neutral").toString();
        String disgust = session.getAttribute("disgust").toString();
        String hate = session.getAttribute("hate").toString();
        String sadness = session.getAttribute("sadness").toString();
        String surprise = session.getAttribute("surprise").toString();

        int pt2 = Integer.parseInt(pt1);
        int nt2 = Integer.parseInt(nt1);
        int tt2 = Integer.parseInt(tt1);
        int rt2 = Integer.parseInt(rt1);
        String iname = null;
        String total = null;
        Gson gsonObj = new Gson();
        Map<Object, Object> map = null;
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();

        try
        {
            map = new HashMap<Object, Object>();
            map.put("label", "Positive Tweets");
            map.put("y", pt2);
            list.add(map);
            map = new HashMap<Object, Object>();
            map.put("label", "Negative Tweets");
            map.put("y", nt2);
            list.add(map);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        String dataPoints = gsonObj.toJson(list);
    %>

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
                                <li class="menu__item"><a href="AdminHome.jsp" class="menu__link">Home</a></li>
                                <li><a class="active" href="#" data-toggle="modal" data-target="#myModal7"><i class="fa fa-sign-in" aria-hidden="true"></i>Search Tweet's</a></li>
                                <li class="menu__item"><a href="AdminViewInfo.jsp" class="menu__link">View Analysis</a></li>
                                <li class="menu__item"><a href="AdminViewTweetStatus.jsp" class="menu__link">Tweet Status</a></li>
                                <li class="menu__item menu__item--current"><a href="AdminViewUser.jsp" class="menu__link">View User</a></li>
                                <li class="menu__item"><a href="Home.jsp" class="menu__link">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </nav>
            </div>
        </div>
        <!-- banner -->
        <script type="text/javascript">
            window.onload = function () 
            {

                var chart = new CanvasJS.Chart("chartContainer", {
                    theme: "light2",
                    animationEnabled: true,
                    exportFileName: "Tweets Analysis",
                    exportEnabled: true,
                    title:
                    {
                        text: "NLP Prediction"
                    },
                    data: [{
                            type: "pie",
                            showInLegend: true,
                            legendText: "{label}",
                            toolTipContent: "{label}: <strong>{}</strong>",
                            indexLabel: "{label} {(}",
                            dataPoints: <%out.print(dataPoints);%>
                        }]
                });
                var chart1 = new CanvasJS.Chart("chartContainer1", {
                    theme: "light2",
                    animationEnabled: true,
                    exportFileName: "Fake Tweets Analysis",
                    exportEnabled: true,
                    title:
                    {
                        text: "Fake Tweets Prediction"
                    },
                    data: [{
                            type: "bar",
                            dataPoints: 
                            [
                                {label: "total tweets", y: <%=tt2%>},
                                {label: "rumors", y:<%=rt2%>}
                            ]
                        }]

                });
                var chart2 = new CanvasJS.Chart("chartContainer2", {
                    theme: "light2",
                    animationEnabled: true,
                    exportFileName: "Fake Tweets Analysis",
                    exportEnabled: true,
                    title:
                    {
                        text: "Sentiment Classification Of Tweets"
                    },
                    data: [{
                            type: "column",
                            dataPoints: [
                                {label: "Total Tweets", y: <%=tt2%>},
                                {label: "Happy", y:<%=happy%>},
                                {label: "Anger", y:<%=anger%>},
                                {label: "Neutral", y:<%=neutral%>},
                                {label: "Disgust", y:<%=disgust%>},
                                {label: "Hate", y:<%=hate%>},
                                {label: "Sadness", y:<%=sadness%>},
                                {label: "Surprise", y:<%=surprise%>}
                            ]
                        }]

                });
                chart.render();
                chart1.render();
                chart2.render();
            }
        </script>

        <!-- //banner -->
        
        <div class="modal fade" id="myModal7" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <div class="signin-form profile">
                            <h3 class="agileinfo_sign">Search Tweet's</h3>	
                            <div class="login-form">
                                <form action="SearchTweet.jsp"  autocomplete="off">
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
        <!-- Modal1 -->
        
        <!-- //Modal2 -->	

        <!-- bootstrap-pop-up -->
        <div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">

                </div>
            </div>
        </div>
        <!-- //bootstrap-pop-up -->
        <!-- banner-bottom -->
        
        <!-- //services -->

        <!-- blog -->
        <div class="blog" id="blog">
            <div class="container">

                <h3 class="w3l_header w3_agileits_header"> View  <span>  Graph</span></h3>
                <div class="agile_inner_w3ls-grids">
            <script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
            <center><div id="chartContainer" style="width: 45%; height: 300px;display: inline-block;"></div><br><br></br>
                    <div id="chartContainer1" style="width: 45%; height: 300px;display: inline-block;"></div><br/><br></br>
                                <div id="chartContainer2" style="width: 45%; height: 300px;display: inline-block;"></div><br/>
                    <div class="clearfix"> </div>
            </center>
                </div>
            </div>
        </div>
        
        <%           
                    // String email = (String) session.getAttribute("email");
                    Connection cn = DbUtil.getConnection();
                    PreparedStatement ps1 = cn.prepareStatement("select * from severity ORDER BY id DESC LIMIT 1");
                    ResultSet rs1 = ps1.executeQuery();

        %>
                <center>
                <table border="0" cellspacing="10" cellpadding="10">
                    <thead>
                        <tr>
                            <th><h1>Severity Of Rumors : </h1></th>
                            <%                          
                    
                                while (rs1.next()) {

                            %> 
                            <th><h1><%out.println(rs1.getString("cat"));%></h1></th>
                        <%}%>
                        </tr>
                    </thead>
                    <tbody>
                        
                    </tbody>
                </table>
                </center>
                        <center><br><table border="3" cellspacing="10" cellpadding="10">
                    <tbody>
                         
                        <tr>
                            <td><h2>Accuracy</h2></td>
                            <td><h2>Precision</h2></td>
                            <td><h2>Recall</h2></td>
                        </tr>
                        <tr>
                            <td><h2><%out.println(session.getAttribute("acc")+"%");%></h2></td>
                            <td><h2><%out.println(session.getAttribute("prec")+"%");%></h2></td>
                            <td><h2><%out.println(session.getAttribute("rec")+"%");%></h2></td>
                        </tr>
                        
                    </tbody>
                </table>
                        </center>
  
        <br>
            <center> <b> <p>© 2020 Fake News Detection Project. All Rights Reserved.</p> <a href="https://.com/" target="_blank"></a></p></center>

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