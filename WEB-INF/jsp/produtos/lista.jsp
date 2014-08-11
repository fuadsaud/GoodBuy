<%@ include file="/header.jspf" %>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Comprar</th>
			<c:if test="${sessaoUsuario.logado}">
				<th>Editar</th>
				<th>Remover</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="produto" items="${produtoList}">
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>${produto.preco}</td>
				<td>
					<form action="<c:url value="/carrinho"/>" method="post">
						<input type="hidden" name="item.produto.id" value="${produto.id}"/>
						<input class="qtde" name="item.quantidade" value="1"/>
						<button type="submit">Comprar</button>
					</form>
				</td>
				<c:if test="${sessaoUsuario.logado}">
					<td><a href="produtos/${produto.id}">Editar</a></td>
					<td>
						<form action="<c:url value="/produtos/${produto.id}"/>" method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="/footer.jspf" %>