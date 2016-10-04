<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	String date = sdf.format(new Date());
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kirjaa tunnit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

</head>
<body>
	<div class="container" style="border: 2px solid black">
		<div class="col-sm-offset-1">
			<h1>
				Tuntikirjanpito Spring MVC<a href="lista"><button
						class="btn btn-default" type="button">Tuntikatselmointiin</button></a>
			</h1>
		</div>
		<form:form modelAttribute="tunnit" method="post"
			class="form-horizontal">


			<div class="form-group">
				<label for="valitseKayttaja" class="col-sm-2 control-label">Nimi:</label>


				<label class="col-sm-2"><select class="form-control"
					name="kayttajaId" id="valitseKayttaja">
						<option selected disabled>Valitse Käyttäjä</option>
						<option value="4">Daniel</option>
						<option value="2">Janne</option>
						<option value="5">Mira</option>
						<option value="1">Niko</option>
						<option value="3">Tommi</option>
						<option value="6">Testaaja</option>
				</select> </label>
				<form:errors path="kayttajaId" style="color:red;" />
			</div>

			<div class="form-group">
				<label for="syotaTunnit" class="col-sm-2 control-label">Pvm:
				</label>
				<div class="col-sm-10"><%=date%>
				</div>
			</div>
			<div class="form-group">
				<form:label path="tuntien_maara" for="syotaTunnit"
					class="col-sm-2 control-label">Tunnit: </form:label>
				<div class="col-sm-1">
					<form:input path="tuntien_maara" type="number" class="form-control"
						name="tunnit" id="syotaTunnit" placeholder="Tunnit" />
				</div>
				<form:errors path="tuntien_maara" style="color:red;" />
			</div>
			<div class="form-group">
				<form:label path="kuvaus" for="syotaTunnit"
					class="col-sm-2 control-label">Kuvaus: </form:label>
				<div class="col-sm-4">
					<form:textarea path="kuvaus" class="form-control" name="kuvaus"
						rows="4"></form:textarea>
				</div>
				<form:errors path="kuvaus" style="color:red;" />
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