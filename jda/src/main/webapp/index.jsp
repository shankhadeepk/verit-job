<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
* {
	margin: 2;
	padding: 2;
}

div {
	margin: 20px;
}

ul {
	list-style-type: none;
	width: 500px;
}

h3 {
	font: bold 20px/1.5 Helvetica, Verdana, sans-serif;
}

li img {
	float: left;
	margin: 0 15px 0 0;
}

li p {
	font: 200 12px/1.5 Georgia, Times New Roman, serif;
}

li {
	padding: 10px;
	overflow: auto;
}

li:hover {
	background: #eee;
	cursor: pointer;
}

td, th {
	border: 1px solid #fff;
	padding: 10px;
	text-align: left;
	border-spacing: 10px;
	border-collapse: separate;
}

.blue {
	font-style: normal;
	color: blue;
}

.red {
	font-style: normal;
	color: red;
}

.cyan {
	font-style: oblique;
	color: #4682B4;
	font-size: 20px;
}

.greenbold {
	font-style: oblique;
	color: green;
	font-size: 20px;
	font-weight: bold;
}

.redbold {
	font-style: oblique;
	color: red;
	font-size: 20px;
	font-weight: bold;
}

img-my {
	width: 20px;
	height: 20px;
}
.tdtop{
	valign:"top";
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<title>Jda</title>
<body>
	<h2>
		<font class="blue">Jda.</font><font class="red">CodeHub</font>
	</h2>
	<form method="GET" action="/getsubmissions">
		<table>
			<tr>
				<td valign="top">
					<div class="tab-content">
						<c:forEach var="submission" items="${listOfSubmission}">
							<div id="${submission.submissionId}"
								class="tab-pane fade in active">
								<ul>
									<li>
										<table width="100%" border="0">
											<tr>
												<td colspan="2"><font class="cyan">${submission.title}</font></td>
												<td><c:if test="${submission.status eq 'Accepted'}">
														<font class="greenbold">${submission.status}</font>
													</c:if> <c:if test="${submission.status ne 'Accepted'}">
														<font class="redbold">${submission.status}</font>
													</c:if> | ${submission.language}</td>
												<td></td>
											</tr>
											<tr>
												<td colspan="3">${submission.source}</td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</table>
									</li>
								</ul>
							</div>
						</c:forEach>
					</div>
				</td>
				<td valign="top">Total Count : ${totalCount}</td>
			</tr>
		</table>
	</form>
</body>
</html>