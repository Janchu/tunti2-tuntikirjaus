<%@page import="java.util.ArrayList"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Tunnit"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listaa tunnit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/tyyli.css"/>"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			 <ul class="nav navbar-nav">
				<li ><a href="uusi"><spring:message code="addhours" /></a></li>
				<li class="active"><a href="lista"><spring:message code="listhours" /></a></li>

			</ul>

			</ul>
			<ul class="nav navbar-nav navbar-middle">
				<li><a href="?lang=en">en</a></li>
				<li><a href="?lang=fi">fi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span><spring:message code="signup" /></a></li>
      				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span><spring:message code="login" /></a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<fieldset>
			<legend><spring:message code="title" /></legend>




		<c:set var="kaikkiyhteensa" value="${0}" />
		<c:forEach items="${kayttajat}" var="klista">
			<c:set var="yhteensa" value="${0}" />

			<a href="#<c:out value="${klista.etunimi}" />" class="btn btn-info"
				data-toggle="collapse"><c:out value="${klista.etunimi}" /> <c:out
					value="${klista.sukunimi}" /></a><br><br>
					
		<div id="<c:out value="${klista.etunimi}" />" class="collapse">

			<div class="table-responsive">
				<table class="table table-bordered">

					<thead>
						<tr>
							<th class="col-sm-1"><spring:message code="date" /></th>
							<th class="col-sm-1"><spring:message code="hours" /></th>
							<th class="col-sm-3"><spring:message code="desc" /></th>
							<th class="col-sm-1"><spring:message code="del" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${klista.tunnit}" var="tunnit">
							<c:set var="id" value="${tunnit.id}" />
							<tr>
								<td><c:out value="${tunnit.paivamaara}" /></td>
								<td><c:out value="${tunnit.tuntien_maara}" /> <c:set
										var="yhteensa" value="${yhteensa + tunnit.tuntien_maara}" /></td>
								<td><c:out value="${tunnit.kuvaus}" /></td>
								<td><form:form modelAttribute="kayttaja" method="post">
										<form:input path="uusitunti.id" type="hidden" value="${id}" />
										<button type="submit" class="btn btn-danger"
											aria-label="Left Align" onclick="return confirm('<spring:message code="areusure" />')">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
									</form:form></td>
							</tr>
						</c:forEach>

						<tr>
							<td><spring:message code="total" />: <c:out
									value="${yhteensa}" /></td>
									<c:set var="kaikkiyhteensa" value="${kaikkiyhteensa + yhteensa}" />
						</tr>
					</tbody>
				</table>
			</div>
			</div>
		</c:forEach>
		<b><u><spring:message code="alltotal" />:</u> <c:out value="${kaikkiyhteensa}" /></b>
		</fieldset>
	</div>

</body>
</html>