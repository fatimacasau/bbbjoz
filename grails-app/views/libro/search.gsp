<div class="scaffold-list" id="listLibros">
	<table>
		<thead>
			<th>Titulo</th>
			<th>Autor</th>
			<th>Categoria</th>
			<th>ISBN</th>
			<th>Acciones</th>
		</thead>
		<tbody>
			<g:each in="${libros}" status="i" var="l">
				<tr>
					<td>${l.titulo}</td>
					<td>${l.autor.nombre} ${l.autor.apellido}</td>
					<td>${l.categoria}</td>
					<td>${l.isbn}</td>
					<td><g:link action="delete" id="${l.id}">Borrar</g:link></td>
				</tr>
			</g:each>
		</tbody>
	</table>
</div>