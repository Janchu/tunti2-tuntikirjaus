<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kirjaa tunnit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<form class="form-horizontal">
  <div class="form-group">
    <label for="syotaEtunimi" class="col-sm-2 control-label">Etunimi</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="syotaEtunimi" placeholder="Etunimi">
    </div>
  </div>
    <div class="form-group">
    <label for="syotaSukunimi" class="col-sm-2 control-label">Sukunimi</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="syotaSukunimi" placeholder="Sukunimi">
    </div>
  </div>
<p><label>Pvm: </label>8.9.2016</p>
<div class="form-group">
    <label for="syotaTunnit" class="col-sm-2 control-label">Tunnit</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="syotaTunnit" placeholder="Tunnit">
    </div>
  </div>
  <div class="form-group">
    <label for="syotaTunnit" class="col-sm-2 control-label">Tunnit</label>
    <div class="col-sm-10">
      <textarea class="form-control" rows="3"></textarea>
    </div>
  </div>
<button class="btn btn-success" type="submit">Tallenna</button>
</form>
</div>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>