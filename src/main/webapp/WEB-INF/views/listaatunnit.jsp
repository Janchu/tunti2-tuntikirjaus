<%@page import="java.util.ArrayList"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Kayttaja"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.KayttajaImpl"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.Tunnit"%>
<%@page import="fi.softala.tunti2_tuntikirjaus.luokat.TunnitImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listaa tunnit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>



	<div class="container">
		<div class="col-sm-offset-1">
			<h1>
				Tuntikirjanpito
				<button class="btn btn-default" type="button">Tuntikatselmointiin</button>
			</h1>
		</div>



		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="col-sm-1">Päivämäärä</th>
						<th class="col-sm-1">Tunnit</th>
						<th class="col-sm-3">Kuvaus</th>
						<th class="col-sm-1">Poista</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${kayttajat}" var="klista">
						<c:set var="yhteensa" value="${0}" />

						<tr>
							<td><c:out value="${klista.etunimi}" /> <c:out
									value="${klista.sukunimi}" /> <c:forEach
									items="${klista.tunnit}" var="tunnit">
									<c:set var="id" value="${tunnit.id}" />
									<tr>
										<td><c:out value="${tunnit.paivamaara}" /></td>
										<td><c:out value="${tunnit.tuntien_maara}" /> <c:set
												var="yhteensa" value="${yhteensa + tunnit.tuntien_maara}" /></td>
										<td><c:out value="${tunnit.kuvaus}" /></td>
										<td><form:form modelAttribute="kayttaja" method="post">
												<form:input path="uusitunti.id" type="hidden" value="${id}" />
												<button type="submit" class="btn btn-success"
													aria-label="Left Align">
													<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>-
												</button>
											</form:form></td>
								</c:forEach>
						</tr>
						<tr>
							<td>Yhteensä: <c:out value="${yhteensa}" /></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>

</body>
</html>