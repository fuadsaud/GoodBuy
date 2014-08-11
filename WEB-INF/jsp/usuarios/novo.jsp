<%@ include file="/header.jspf" %>
<form id="usuariosForm" action="<c:url value="/usuario"/>" method="POST">
	<fieldset>
		<legend>Criar novo usu�rio</legend>
		<label for="nome">Nome:</label> <input id="nome" class="required"
			type="text" name="usuario.nome" value="${usuario.nome }" autofocus="autofocus"> <label
			for="login">Login:</label> <input id="login" class="required"
			type="text" name="usuario.username" value="${usuario.username}" /> <label
			for="senha">Senha:</label> <input id="senha" class="required"
			type="password" name="usuario.senha" /> <label for="confirmacao">Confirme a
			senha:</label> <input id="confirmacao" equalTo="#senha" type="password" />
		<button type="submit">Enviar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$("#usuariosForm").validate();
</script>
<%@ include file="/footer.jspf" %>