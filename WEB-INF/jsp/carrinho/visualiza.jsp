<%@ include file="/header.jspf"%>
<h3>Itens do seu carrinho de compras</h3>
<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descri��o</th>
			<th>Pre�o</th>
			<th>Quantidade</th>
			<th>Total</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrinho.itens}" var="item" varStatus="i">
			<tr>
				<td>${item.produto.nome}</td>
				<td>${item.produto.descricao}</td>
				<td><fmt:formatNumber type="currency"
						value="${item.produto.preco}" /></td>
				<td>${item.quantidade }</td>
				<td><fmt:formatNumber type="currency"
						value="${item.quantidade * item.produto.preco}" />
				</td>
				<td>
					<form action="<c:url value="/carrinho/${i.index}" />" method="post">
						<button class="link" name="_method" value="delete">Remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2"></td>
			<th colspan="2">Total:</th>
			<th><fmt:formatNumber type="currency" value="${carrinho.total}" /></th>
		</tr>
	</tfoot>
</table>
<%@ include file="/footer.jspf"%>