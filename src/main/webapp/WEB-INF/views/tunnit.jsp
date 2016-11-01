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
	href="<c:url value="/resources/styles/tyyli.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/styles/datepicker.css"/>">

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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">


			</ul>
			<ul class="nav navbar-nav navbar-middle">
				<li><a href="?lang=en">en</a></li>
				<li><a href="?lang=fi">fi</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						<spring:message code="signup" /></a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						<spring:message code="login" /></a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<form:form modelAttribute="tunnit" method="post"
			class="form-horizontal">


			<fieldset>
				<legend class="col-sm-offset-2">
					<spring:message code="title1" />
				</legend>


				<div class="form-group">
					<label for="valitseKayttaja" class="col-sm-2 control-label"><spring:message
							code="name" />:</label>


					<div class="col-sm-2">
						<select class="form-control" name="kayttajaId"
							id="valitseKayttaja">
							<option selected disabled><spring:message
									code="chooseuser" /></option>
							<option value="4">Daniel</option>
							<option value="2">Janne</option>
							<option value="5">Mira</option>
							<option value="1">Niko</option>
							<option value="3">Tommi</option>
							<option value="6">Testaaja</option>
						</select>
					</div>
					<form:errors path="kayttajaId" style="color:red;" />
				</div>

				<div class="form-group">
					<label path="paivamaara" for="syotaTunnit" class="col-sm-2 control-label"><spring:message
							code="date" />: </label>
					<div class="col-sm-4">
						<div class="input-group date" id="datepicker" data-provide="datepicker" data-date-format="yyyy-mm-dd" data-date-week-start="1" data-date-language="fi">
							<form:input path="paivamaara" type="text" class="form-control" />
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<form:label path="tuntien_maara" for="syotaTunnit"
						class="col-sm-2 control-label">
						<spring:message code="hours" />:</form:label>
					<div class="col-sm-1">
						<form:input path="tuntien_maara" type="number"
							class="form-control" name="tunnit" id="syotaTunnit" />
					</div>
					<form:errors path="tuntien_maara" style="color:red;" />
				</div>
				<div class="form-group">
					<form:label path="kuvaus" for="syotaTunnit"
						class="col-sm-2 control-label">
						<spring:message code="desc" />:</form:label>
					<div class="col-sm-4">
						<form:textarea path="kuvaus" class="form-control" name="kuvaus"
							rows="4"></form:textarea>
					</div>
					<form:errors path="kuvaus" style="color:red;" />
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="savebutton" onclick="myFunction2()" type="submit"
							name="lisaa">
							<spring:message code="save" />
						</button>
					</div>
				</div>
			</fieldset>
		</form:form>

		<fieldset>
			<legend class="col-sm-offset-2">
				<spring:message code="title2" />
			</legend>



			<div class="col-sm-offset-2">
				<c:set var="kaikkiyhteensa" value="${0}" />
				<c:forEach items="${kayttajat}" var="klista">
					<c:set var="yhteensa" value="${0}" />

					<a href="#<c:out value="${klista.etunimi}" />" class="namebutton"
						data-toggle="collapse"><c:out value="${klista.etunimi}" /> <c:out
							value="${klista.sukunimi}" /></a>
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
											<td><c:out value="${tunnit.paivamaara}" /></td>
											<td><c:out value="${tunnit.tuntien_maara}" /> <c:set
													var="yhteensa" value="${yhteensa + tunnit.tuntien_maara}" /></td>
											<td><c:out value="${tunnit.kuvaus}" /></td>
											<td><form:form modelAttribute="kayttaja" method="post"
													action="poista">
													<form:input path="uusitunti.id" type="hidden" value="${id}" />
													<button type="submit" class="btn btn-danger"
														aria-label="Left Align"
														onclick="return confirm('<spring:message code="areusure" />')">
														<span class="glyphicon glyphicon-remove"
															aria-hidden="true"></span>
													</button>
												</form:form></td>
										</tr>
									</c:forEach>

									<tr>
										<td><b><u><spring:message code="total" />:</u> <c:out
													value="${yhteensa}" /></b></td>
										<c:set var="kaikkiyhteensa"
											value="${kaikkiyhteensa + yhteensa}" />
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:forEach>
				<b><u><spring:message code="alltotal" />:</u> <c:out
						value="${kaikkiyhteensa}" /></b>
			</div>
		</fieldset>

	</div>
	<script type="text/javascript"
		src="<c:url value="/webjars/jquery/1.11.1/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/webjars/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>

</body>
</html>