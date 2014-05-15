<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage your stocks here</title>
<link rel="stylesheet" href='<c:url value="/resources/css/estilo.css"/>'
	type="text/css" />
<script src='<c:url value='/resources/js/jquery-2.1.0.min.js'/>' type="text/javascript"></script>
<script src='<c:url value='/resources/js/stocks.js'/>' type="text/javascript"></script>
<script src='<c:url value='/resources/js/jquery.mask.min.js'/>' type="text/javascript"></script>
</head>

<body>
	<sf:form method="POST" modelAttribute="stock">
		<fieldset style="width: -moz-fit-content">
			<table>
					<tr>
						<th><sf:label path="codigo" >Código</sf:label></th>
						<th><sf:label path="quantidade" >Quantidade</sf:label></th>
						<th><sf:label path="valorCompra" >Valor de Compra</sf:label></th>
						<th><sf:label path="valorAtual" >Valor Atual</sf:label></th>
						<th><sf:label path="valorVenda" >Valor de Venda</sf:label></th>
						<th><sf:label path="dataCompra" >Data de Compra</sf:label></th>
						<th><sf:label path="dataVenda" >Data de Venda</sf:label></th>
					</tr>
					<tr>
						<td><sf:input path="codigo" size="6" maxlength="6" /></td>
						<td><sf:input path="quantidade" size="4" maxlength="4" /></td>
						<td><sf:input path="valorCompra" value="0" size="8" maxlength="8" class="money" /></td>
						<td><sf:input path="valorAtual" size="8" maxlength="8" id="valorAtual" class="money" /></td>
						<td><sf:input path="valorVenda" size="8" maxlength="8" class="money" /></td>
						<td><sf:input path="dataCompra" size="10" maxlength="10" /></td>
						<td><sf:input path="dataVenda" size="10" maxlength="10" /></td>
					</tr>
			</table>
		</fieldset>
		<input type="submit" value="Conferir" />
	</sf:form>
</body>
</html>