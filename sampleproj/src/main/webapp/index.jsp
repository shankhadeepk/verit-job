<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<title>Veritrans Payment Gateway</title>
<body>
<h2>Veritrans Payment Gateway</h2>
<form method="GET" action="/getpaymentgate">
<ul class="nav nav-tabs">
  <c:forEach var="listValue" items="${listofnames}">   
  	<li><a data-toggle="tab" href="#${listValue}">${listValue}</a></li> 		
  </c:forEach> 
</ul>
<div class="tab-content">
<c:forEach var="paymentObj" items="${listofpayobjs}">
  <div id="${paymentObj.name}" class="tab-pane fade in active">
    <h3>GatewayName: ${paymentObj.name}</h3>
    <p>Image : ${paymentObj.image}</p>
    <p>Description : ${paymentObj.description}</p>
    <p>Branding : ${paymentObj.branding}</p>
    <p>Rating : ${paymentObj.rating}</p>
    <p>SetupFee: ${paymentObj.setup_fee}</p>
    <p>Transaction Fee: ${paymentObj.transaction_fees}</p>
    <p>How to Url : ${paymentObj.how_to_url}</p>
    <p>Currencies: ${paymentObj.currencies}</p>
  </div>  
  </c:forEach>
</div>
</form>
</body>
</html>
