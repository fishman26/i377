<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<style>
	<%@ include file="/WEB-INF/Style.css"%>
</style>
<title>Search</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/Menu.jsp" %>
	<form method="get" action="Search">
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="object" items="${objects}">
					<tr>
						<td>
							<div id="row_${object.kood}"><c:out value="${object.nimi}"></c:out></div>
						</td>
						<td>${object.kood}</td>
						<td><a href="Search?do=delete&id=${object.id}"
							id="delete_${object.kood}">Kustuta</a></td>
					</tr>
</c:forEach>
</tbody>
</table>
</form>
</body>
</html>