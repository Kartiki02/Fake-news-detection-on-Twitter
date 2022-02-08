
<!DOCTYPE html>
<html>

<head>
	
<title>Fake News Detection </title>
	<link rel="stylesheet" type="text/css" href="bootloader.css">
	<script type="text/javascript">
		(function() {
	
	var loading = 0;
	var id = setInterval(keepLoading,60);

	function keepLoading()
	{
		if(loading == 100)
		{
			clearInterval(id);
			// alert("Check !!")
			//var MyWindow=window.open("http://localhost:8080/Socio/index.jsp","myAdWin","_self");
			window.location = "http://localhost:8080/Socio/Home.jsp"
		}
		else
		{
			loading = loading +1;
			if(loading == 90)
			{
				document.getElementById('backframe').style.animation = "fadeout 1s ease";
			}
		}
	}

})();3
	</script>
	</head>
<body>

<div id="backframe">
	<div class="title">
		<strong style="font-family:raleway; color: #fff">FAKE 
			<span style="color: #5cb85c;">NEWS DETECTION</span>
		</strong>
	</div>
	
	<div class="preloader">
		<div class="box1"></div>
		<div class="box2"></div>
	</div>
</div>

</body>
</html>