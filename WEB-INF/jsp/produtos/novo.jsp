<%@ include file="/header.jspf" %>
<form id="produto" action="<c:url value="/produtos" />" method="post">
	<fieldset>
		<legend>Adicionar Produto</legend>
		<label for="nome">Nome:</label>
		<input id="nome" type="text" name="produto.nome" value="${produto.nome}" class="required" minLength="2" />
		
		<label for="descricao">Descrição:</label>
		<textarea id="descricao" name="produto.descricao" class="required" maxLength="40">${produto.descricao}</textarea>
		
		<label for="preco">Preço:</label>
		<input id="preco" type="text" name="produto.preco" value="${produto.preco}" min="0" />
		
		<button type="submit">Enviar</button>
	</fieldset>
</form>

<script type="text/javascript">
	$("#produto").validate();
</script>
<%@ include file="/footer.jspf" %>