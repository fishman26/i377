<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset=utf-8>
<style>
	<%@ include file="/WEB-INF/Style.css"%>
</style>
<title>Add</title>
</head>
<body>

	<%@ include file="/WEB-INF/jsp/Menu.jsp" %>
	<form method="post" action="Add">

		<table class="formTable" id="formTable">
			<tbody>
				<tr>
					<td>Nimi:</td>
					<td><input name="name" id="nameBox" /></td>
				</tr>
				<tr>
					<td>Kood:</td>
					<td><input name="code" id="codeBox" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><br /> <input type="submit"
						value="Lisa" id="addButton" /></td>
				</tr>
</tbody>
</table>
</form>
</body>
</html>