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
<script>

	function myFunction() {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar")

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
	}

</script>

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
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/styles/tyyli.css"/>"/>
</head>
<body>
	<div class="container" style="border: 2px solid black">
		<div class="col-sm-offset-1">
			<h1>
				Tuntikirjanpito Spring MVC<a href="lista"><button class="btn btn-default" type="button">Tuntikatselmointiin</button></a>
			</h1>
		</div>
		<form:form modelAttribute="kayttaja" method="post" class="form-horizontal">
			<div class="form-group">
<label for="syotaEtunimi" class="col-sm-2 control-label">Nimi:</label>
<label class="col-sm-2"><select class="form-control" name="etunimi" id="syotaEtunimi">
  <option>Daniel</option>
  <option>Janne</option>
  <option>Mira</option>
  <option>Niko</option>
  <option>Tommi</option>
  <option>Testaaja</option>
</select>
</label>
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
					<button class="btn btn-success" onclick="myFunction()" type="submit">Tallenna</button>
				</div>
			</div>
		</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<div id="snackbar">Some text some message..</div>
</body>
</html>