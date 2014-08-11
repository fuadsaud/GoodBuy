<%@ include file="/header.jspf" %>
<form action="<c:url value="/usuario/autenticacao"/>" method="POST">
	<fieldset>
		<legend>Efetue o login</legend>
		<label for="login">Login:</label> <input id="login" type="text"
			name="usuario.username" autofocus="autofocus" /> <label for="senha">Senha:</label> <input
			id="senha" type="password" name="usuario.senha" />
		<button type="submit">Login</button>
	</fieldset>
</form>
<%@ include file="/footer.jspf" %>