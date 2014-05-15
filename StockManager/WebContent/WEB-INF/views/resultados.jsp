<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultados</title>
<link rel="stylesheet" href='<c:url value="/resources/css/estilo.css"/>' type="text/css" />
</head>

<body>
	<table>
		<tbody>
			<tr>
				<c:forEach items="${checkedResults}" var="dezena">
				<td class="${dezena.value}" >
					<c:out value="${dezena.key}" />
				</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
<sf:form method="GET">
	<input type="submit" value="Voltar" />
</sf:form>
</html>