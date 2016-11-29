<!DOCTYPE html>
<html>
<head>

<sec:authorize access="isAuthenticated()">
	<c:redirect url="tunnit/lista" />
</sec:authorize>


<!-- Metatiedot -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Virhe - Tuntikirjanpito</title>


<!-- Tyylitiedostot -->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/tyyli.css"/>">


<!-- Skriptit -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div id="greeting">
				<a class="navbar-brand" style="margin-top: 3px;"> <spring:message
						code="greeting" />
				</a>
			</div>

			<ul class="nav navbar-nav navbar-left">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</ul>

			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a href="?lang=fi"><spring:url
								value="/resources/images" var="images" /><img
							src="${images}/finflag.png" class="finflag" width="28"
							height="auto" /></a></li>
					<li class="nav-item"><a href="?lang=en"><spring:url
								value="/resources/images" var="images" /><img
							src="${images}/ukflag.png" class="ukflag" width="28"
							height="auto" /></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<h3>Tapahtui virhe!</h3>


	<a href="index">Takaisin etusivulle</a>


	<script type="text/javascript"
		src="<c:url value="/webjars/jquery/1.11.1/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/webjars/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>

</body>
</html>