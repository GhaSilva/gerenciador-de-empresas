 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">
<title>Formulário</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"></c:import>
	
	<form action="${linkEntradaServlet}" method="post"> 
		Nome: <input type="text" name="nome"> 
		Data: <input type="text" name="data">
		
		<input type="hidden" name="acao" value="NovaEmpresas">
		
		<input type="submit">
	</form>
</body>
</html>