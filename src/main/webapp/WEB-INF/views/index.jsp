<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>

<sec:authorize access="isAuthenticated()">
	<c:redirect url="tunnit/lista" />
</sec:authorize>


<!-- Metatiedot -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tervetuloa tuntikirjaukseen</title>


<!-- Tyylitiedostot -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/tyyli.css"/>" />


<!-- Skriptit -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div id="greeting"><a class="navbar-brand" style="margin-top:3px;"> <spring:message code="greeting" />
			</a></div>

			<ul class="nav navbar-nav navbar-left">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</ul>

		<div class="collapse navbar-collapse" id="myNavbar">
					
			<ul class="nav navbar-nav navbar-right">
				<li class="nav-item"><a href="?lang=fi"><spring:url value="/resources/images" var="images" /><img src="${images}/finflag.png" class="finflag" width="28" height="auto"/></a></li>
				<li class="nav-item"><a href="?lang=en"><spring:url value="/resources/images" var="images" /><img src="${images}/ukflag.png" class="ukflag" width="28" height="auto"/></a></li>
			</ul>
		</div>
		</div>
	</nav>

	<c:if test="${empty loggedin && empty loggedout && empty loginerror}">
		<div class="container">
			<form:form action="tunnit/j_spring_security_check" method="post"
				class="form-horizontal">
				<fieldset>
					<legend class="col-sm-offset-2">
						<spring:message code="timetrackapp" />
					</legend>
					<div class="form-group">
						<label class="control-label col-sm-2" for="kayttajatunnus"><spring:message
								code="username" /></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="kayttajatunnus"
								name='kayttajatunnus' value='' required> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd"><spring:message
								code="password" /></label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="salasana"
								name='salasana' required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">
								<spring:message code="login" />
							</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</c:if>

	<c:if test="${loggedout || loginerror}">
		<div class="container">

			<c:if test="${not empty loginerror}">
				<div class="panel panel-danger">
					<div class="panel-heading">
						<spring:message code="loginfail" />
					</div>
				</div>
			</c:if>

			<c:if test="${not empty loggedout}">
				<div class="panel panel-success">
					<div class="panel-heading">
						<spring:message code="logoutsuc" />
					</div>
				</div>
			</c:if>

			<form:form action="j_spring_security_check" method="post"
				class="form-horizontal">
				<fieldset>
					<legend class="col-sm-offset-2">
						<spring:message code="timetrackapp" />
					</legend>
					<div class="form-group">
						<label class="control-label col-sm-2" for="kayttajatunnus"><spring:message
								code="username" /></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="kayttajatunnus"
								name='kayttajatunnus' value=''> <input type="hidden"
								name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd"><spring:message
								code="password" /></label>
						<div class="col-sm-4">
							<input type="password" class="form-control" id="salasana"
								name='salasana'>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">
								<spring:message code="login" />
							</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</c:if>



</body>
</html>