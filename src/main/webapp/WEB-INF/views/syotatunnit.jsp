<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	String date = sdf.format(new Date());
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kirjaa tunnit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-sm-offset-1">
			<h1>
				Tuntikirjanpito Spring MVC<a href="lista">Tuntikatselmointiin</a>
			</h1>
		</div>
		<form:form modelAttribute="kayttaja" method="post">
			<div class="form-group">
				<form:label path="etunimi" for="syotaEtunimi"
					class="col-sm-2 control-label">Etunimi: </form:label>
				<div class="col-sm-4">
					<form:input path="etunimi" type="text" class="form-control"
						id="syotaEtunimi" placeholder="Etunimi" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="sukunimi" for="syotaSukunimi"
					class="col-sm-2 control-label">Sukunimi: </form:label>
				<div class="col-sm-4">
					<form:input path="sukunimi" type="text" class="form-control"
						id="syotaSukunimi" placeholder="Sukunimi" />
				</div>
			</div>
			<div class="form-group">
				<label for="syotaTunnit" class="col-sm-2 control-label">Pvm:
				</label>
				<div class="col-sm-10"><%=date%>
				</div>
			</div>
			<div class="form-group">
				<form:label path="uusitunti.tuntien_maara" for="syotaTunnit"
					class="col-sm-2 control-label">Tunnit: </form:label>
				<div class="col-sm-1">
					<form:input path="uusitunti.tuntien_maara" type="number"
						class="form-control" name="tunnit" id="syotaTunnit"
						placeholder="Tunnit" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="uusitunti.kuvaus" for="syotaTunnit"
					class="col-sm-2 control-label">Kuvaus: </form:label>
				<div class="col-sm-4">
					<form:textarea path="uusitunti.kuvaus" class="form-control"
						name="kuvaus" rows="4"></form:textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-success" type="submit">Tallenna</button>
				</div>
			</div>
		</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>