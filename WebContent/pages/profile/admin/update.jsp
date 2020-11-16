<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="author" content="Sidney Miranda"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileAdm.css" />
<title>Atualiza��o de dados</title>
</head>
<body>

	<h1 class="title-confirm">Atualiza��o do cadastro</h1>
	
	
	<form class="form" method="post" action="${pageContext.request.contextPath}/crud?action=${param.action}">
		<label for="title">T�tulo</label>
		<input 
			type="text" 
			class="input"
			id="title"
			name="title"
			value="${param.title}"
			readonly
		>
		<label for="author">Nome do autor</label>
		<input 
			type="text" 
			name="author" 
			class="input"
			id="author"
			value="${param.author}"
		>
		
		<div class="content-div">
			<div class="content-div-label">
				<label class="grow" for="year">Ano da Publica��o</label>
				<label class="grow" for="isbn">ISBN</label>
				<label class="grow"	for="edition">Edi��o</label>
			</div>
			<div class="content-div-input">
				<input 
					class="grow" 
					type="text" 
					id="year"
					name="year" 
					value="${param.year}"
				>
				<input 
					class="grow" 
					type="text" 
					id="isbn"
					name="isbn"
					value="${param.isbn}" 
					readonly
				>
				<input 
					class="grow" 
					type="text" 
					id="edition"
					name="edition"
					value="${param.edition}"
				>
			</div>
		</div>
		<div class="content-div">
			<div class="content-div-label">
				<label class="grow" for="idioma">Idioma</label>
				<label class="grow"	for="genre">G�nero</label>
			</div>
			<div class="content-div-label">
				<input 
					class="grow" 
					type="text" 
					id="idioma"
					name="idioma"
					value="${param.idioma != '' ? param.idioma : 'N�O INFORMADO'}" 
					readonly
				>
				<input 
					class="grow" 
					type="text" 
					id="genre"
					name="genre"
					value="${param.genre != '' ? param.genre : 'N�O INFORMADO'}" 
					readonly
				>
			</div>
		</div>
		<label 
			for="sinopse">Sinopse</label>
		<textarea 
			id="sinopse"
			name="sinopse"
		>${param.sinopse != '' ? param.sinopse : 'N�O INFORMADO'}</textarea>
		
		<div class="buttons">
			<input
				class="btn button-submit" 
				type="submit" 
				value="ATUALIZAR"
			>			
			<a 
				class="btn button-cancel"
				href="${pageContext.request.contextPath}/pages/profile/admin/home.jsp"
			>
				CANCELAR
			</a>
		</div>
	</form>

</body>
</html>