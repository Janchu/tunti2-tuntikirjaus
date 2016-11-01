<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<sec:authorize access="isAuthenticated()">
<c:redirect url="tunnit/lista"/>
</sec:authorize>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tervetuloa tuntikirjaukseen</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/tyyli.css"/>" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">

			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
       				<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>                        
      			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">			
			<ul class="nav navbar-nav navbar-middle">
				<li><a href="?lang=en">en</a></li>
				<li><a href="?lang=fi">fi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li></li>
      				<li></li>
			</ul>
		</div>
</nav>
	
	<c:if test="${not empty loginerror}">
		Sisäänkirjautuminen epäonnistui. Käyttäjätunnus tai salasana on syötetty väärin.
	</c:if>	

	<c:if test="${not empty loggedout}">
		Uloskirjautuminen onnistui
	</c:if>
		<c:if test="${empty loggedin && empty loggedout && empty loginerror}">
	<form:form action="tunnit/j_spring_security_check" method="post">
	<fieldset>
	<table>
		
		<tr><td>Käyttäjänimi:</td><td><input type='text' name='kayttajatunnus' value=''> 
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/></td></tr>
		<tr><td>Salasana:</td><td><input type='password' name='salasana' /></td></tr>
		 
		<tr><td>&nbsp;</td><td><button type="submit">Kirjaudu</button></td></tr>
		</table>
	</fieldset>
	</form:form>
	</c:if>
	<c:if test="${loggedout || loginerror}">
	<form:form action="j_spring_security_check" method="post">
	<fieldset>
	<table>
		
		<tr><td>Käyttäjänimi:</td><td><input type='text' name='kayttajatunnus' value=''> 
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/></td></tr>
		<tr><td>Salasana:</td><td><input type='password' name='salasana' /></td></tr>
		 
		<tr><td>&nbsp;</td><td><button type="submit">Kirjaudu</button></td></tr>
		</table>
	</fieldset>
	</form:form>
	</c:if>	
	
		<h1><spring:message code="timetrackapp" /></h1>
		
	
</body>
</html>