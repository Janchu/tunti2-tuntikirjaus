<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
    <label for="syotaEtunimi" class="col-sm-2 control-label">Etunimi: </label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="syotaEtunimi" placeholder="Etunimi">
    </div>
  </div>
    <div class="form-group">
    <label for="syotaSukunimi" class="col-sm-2 control-label">Sukunimi: </label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="syotaSukunimi" placeholder="Sukunimi">
    </div>
  </div>
<div class="form-group">
    <label for="syotaTunnit" class="col-sm-2 control-label">Pvm: </label>
    <div class="col-sm-10">20.9.2016
    </div>
  </div>
<div class="form-group">
    <label for="syotaTunnit" class="col-sm-2 control-label">Tunnit: </label>
    <div class="col-sm-1">
      <input type="number" class="form-control" id="syotaTunnit" placeholder="Tunnit">
    </div>
  </div>
  <div class="form-group">
    <label for="syotaTunnit" class="col-sm-2 control-label">Kuvaus: </label>
    <div class="col-sm-4">
      <textarea class="form-control" rows="4"></textarea>
    </div>
  </div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
<button class="btn btn-success" type="submit">Tallenna</button>
</div>
</div>
</form>
</div>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>