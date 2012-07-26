<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  	<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
	</g:if>
  <div id="searchDiv">
	  <g:form action="search">
	  		<table>
	  			<tbody>
	  				<tr>
	  					<td>
	  						<label for="titulo"></label>
	  						<g:textField id="titulo" name="titulo"/>
	  					</td>
	  					<td>
	  						<label for="categoria"></label>
	  						<g:select id="categoria" name="categoria" noSelection="${['':' -- Seleccionar --']}" from="${categorias}">
	  						</g:select>
	  					</td>
	  				</tr>
	  			</tbody>
	  		</table>
	  		<g:submitToRemote url="['action':'search']" value="Buscar" update="listDiv"/>
	  	</g:form>
  	</div>
  	<div id="listDiv">
  		<g:include view="libro/search.gsp"/>
  	</div>
  </div>
</body>
</html>