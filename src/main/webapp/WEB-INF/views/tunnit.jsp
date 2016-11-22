<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Tunnit"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>

<!-- Metatiedot -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Kirjaa tunnit</title>


<!-- Tyylitiedostot -->

<link rel="stylesheet" type="text/css"
	href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/timepicker.min.css"/>">
<script type="text/javascript"
	src="<c:url value="/webjars/jquery/1.11.1/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/webjars/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-timepicker.min.js" />"></script>


<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/tyyli.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/datepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/bootstrap-timepicker.min.css"/>">

<style>
a:hover, a:visited, a:link, a:active
{
    text-decoration: none;
    color:white;}
    </style>

<!-- Skriptit -->

<script>
	$('.input-group date').datepicker({
		language : 'fi',
		format : 'dd.MM.yyyy',
		weekStart : 1
	});
</script>
<script>
	function myFunction() {
		alert("Tunnit lisätty");
	}
</script>
</head>


<body>


	<!-- Yläpalkki & navigointi -->

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <spring:message code="greeting" />
				<sec:authentication property="principal.username" />
			</a>

			<ul class="nav navbar-nav navbar-left">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</ul>


			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a href="?lang=en">en</a></li>
					<li class="nav-item"><a href="?lang=fi">fi</a></li>
				
					<li class="nav-item"><form:form
							action="${pageContext.request.contextPath}/logout" method="POST">
							<button id="logout" type="submit">
								<i class="glyphicon glyphicon-log-out"></i>
								<spring:message code="logout" />
							</button>
						</form:form></li>
				</ul>
			</div>
		</div>
	</nav>



	<!----- Syöttökentät ------>

	<div class="container">

		<sec:authorize access="hasRole('ROLE_KAYTTAJA')">  <!-- Normaalikäyttäjän näkymät luodaan tästä alaspäin -->
			<form:form modelAttribute="tunnit" method="post"
				class="form-horizontal">

				<fieldset>
					<legend class="col-sm-offset-2">
						<spring:message code="title1" />
					</legend>


					<!-- Käyttäjän ID -->

					<form:input path="kayttajaId" type="hidden" value="${kayttaja.id}" />


					<!-- Päivämäärän valitseminen -->

					<div class="form-group">
						<form:label path="paivamaara" for="syotaPaivamaara"
							class="col-sm-2 control-label">
							<spring:message code="date" />:</form:label>
						<div class="col-sm-2">
							<div class="input-group date" id="datepicker"
								data-provide="datepicker" data-date-format="yyyy-mm-dd"
								data-date-week-start="1">
								<form:input path="paivamaara" type="text" id="syotaPaivamaara"
									class="form-control" />
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-calendar"></i></span>
							</div>
						</div>
					</div>


					<!------ Tuntien määrä ------>

					<div class="form-group">
						<form:label path="tuntien_maara" for="syotaTunnit"
							class="col-sm-2 control-label">
							<spring:message code="hours" />:</form:label>
						<div class="col-sm-2">
							<div class="input-group bootstrap-timepicker timepicker">
								<form:input path="tuntien_maara" type="text" id="syotaTunnit"
									class="form-control" />
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-time"></i></span>
							</div>
						</div>
					</div>



					<!----- Kuvaus ------->

					<div class="form-group">
						<form:label path="kuvaus" for="syotaTunnit"
							class="col-sm-2 control-label">
							<spring:message code="desc" />:</form:label>
						<div class="col-sm-4">
							<form:textarea path="kuvaus" class="form-control" rows="4"></form:textarea>
						</div>
						<form:errors path="kuvaus" style="color:red;" />
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button class="savebutton" onclick="myFunction2()" type="submit" name="lisaa">
								<spring:message code="save" />
							</button>
						</div>
					</div>
				</fieldset>
			</form:form>


			<!------ Tuntitaulukot ------>

			<fieldset>
				<legend class="col-sm-offset-2">
					<spring:message code="title2" />
				</legend>

				<sec:authentication var="principal" property="principal" />
				<div class="col-sm-offset-2">
					<c:set var="kaikkiyhteensa" value="${0}" />
					<c:forEach items="${kayttajat}" var="klista">
						<c:set var="yhteensa" value="${0}" />
						
						<c:forEach items="${klista.tunnit}" var="tunnit">
						<c:set var="tuntienmaara" value="${tunnit.tuntien_maara}"/>
						<c:set var="yhteensa" value="${yhteensa + tunnit.tuntien_maara}"/>
						</c:forEach>
						
						
						<!--  wrapper laittaa käyttäjän nimen ja tämän tunnit kiinni toisiinsa -->
						
						

						<div class="wrapper"><div class="left"><a href="#<c:out value="${klista.etunimi}" />" class="namebutton"
							data-toggle="collapse"><c:out value="${klista.etunimi}" />
							<c:out value="${klista.sukunimi}"/></a></div><div class="right"><div id="kayttajantunnit">
							
							<fmt:formatNumber type="number" pattern="###.00" value="${yhteensa}" />
												</div></div></div>
						<br>

						<div id="<c:out value="${klista.etunimi}" />" class="collapse">
						
						<!----- Tuntitaulukko ----->

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
											
											<!-- Käyttäjän pvm, tunnit, kuvaus, ja poistanappi tr -->
											
											<tr>
												<fmt:parseDate value="${tunnit.paivamaara}" pattern="yyyy-MM-dd" var="paivamaara" />
												<td><fmt:formatDate value="${paivamaara}" pattern="dd.MM.yyyy" /></td>
												<td><c:set var="tuntienmaara"
														value="${tunnit.tuntien_maara}" /> <fmt:formatNumber
														type="number" pattern="##.00" value="${tuntienmaara}" />
													
												<td><c:out value="${tunnit.kuvaus}" /></td>

												<c:if test="${klista.kayttajatunnus == principal.username}">
													<td><form:form modelAttribute="kayttaja" method="post" action="poista">
															<form:input path="uusitunti.id" type="hidden" value="${id}" />
															<button type="submit" class="btn btn-danger" aria-label="Left Align"
																onclick="return confirm('<spring:message code="areusure" />')">
																<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
															</button>
														</form:form></td>
												</c:if>
											</tr>
										</c:forEach>

										<!-- Yhteistunnit tr -->

										<tr>
											<td><p class="bold">
													<spring:message code="total" />
													:
													<fmt:formatNumber type="number" pattern="###.00" value="${yhteensa}" />
												</p></td>
											<c:set var="kaikkiyhteensa" value="${kaikkiyhteensa + yhteensa}" />
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</c:forEach>
					<p class="bold">
						<spring:message code="alltotal" />
						:			

						<fmt:formatNumber type="number" pattern="###.00" value="${kaikkiyhteensa}" />
					</p>
				</div>
			</fieldset>
		</sec:authorize>
		
		
		<!-- Tästä eteenpäin ADMININ näkymät -->
		
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">

			<fieldset>
				<legend class="col-sm-offset-2">
					<spring:message code="title2" />
				</legend>

				<div class="col-sm-offset-2">
					<c:set var="kaikkiyhteensa" value="${0}" />
					<c:forEach items="${kayttajat}" var="klista">
						<c:set var="yhteensa" value="${0}" />

						<a href="#<c:out value="${klista.etunimi}" />" class="namebutton"
							data-toggle="collapse"><c:out value="${klista.etunimi}" />
							 <c:out value="${klista.sukunimi}" /></a>
						<br>
						<br>

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
												<fmt:parseDate value="${tunnit.paivamaara}" pattern="yyyy-MM-dd" var="paivamaara" />
												<td><fmt:formatDate value="${paivamaara}" pattern="dd.MM.yyyy" /></td>
												<td><c:set var="tuntienmaara"
														value="${tunnit.tuntien_maara}" /> <fmt:formatNumber
														type="number" pattern="00.00" value="${tuntienmaara}" />
													<c:set var="yhteensa" value="${yhteensa + tunnit.tuntien_maara}" /></td>
												<td><c:out value="${tunnit.kuvaus}" /></td>
												<td><form:form modelAttribute="kayttaja" method="post" action="poista">
														<form:input path="uusitunti.id" type="hidden" value="${id}" />
														<button type="submit" class="btn btn-danger"
															aria-label="Left Align"
															onclick="return confirm('<spring:message code="areusure" />')">
															<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
														</button>
													</form:form></td>
											</tr>
										</c:forEach>
										<tr>
											<td><p class="bold">
													<spring:message code="total" />
													:
													<fmt:formatNumber type="number" pattern="###.00"
														value="${yhteensa}" />
													<!-- <c:out value="${yhteensa}" /> -->
												</p></td>
											<c:set var="kaikkiyhteensa"	value="${kaikkiyhteensa + yhteensa}" />

										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</c:forEach>
					
					<!-- Koko projektin yhteistunnit -->
					
					<p class="bold">
						<spring:message code="alltotal" />
						:						
						<fmt:formatNumber type="number" pattern="###.00"
							value="${kaikkiyhteensa}" />
					</p>

				</div>
			</fieldset>
		</sec:authorize>
	</div>

<!---- Scriptit ----->

	<script type="text/javascript">
		$('#syotaTunnit').timepicker({
			showMeridian : false,
			maxHours : 13,
			defaultTime : '00:00'

		});
	</script>

</body>
</html>