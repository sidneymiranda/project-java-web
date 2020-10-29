<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileAdm.css" />
<title>Atualização de dados</title>
</head>
<body>

	<h1 class="title-confirm">Atualização do cadastro</h1>
	
	
	<form class="form" method="post" action="${pageContext.request.contextPath}/update-book">
		<label for="title">Título</label>
		<input 
			type="text" 
			class="input"
			id="title"
			name="title"
			value="${param.title}"
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
				<label class="grow" for="year">Ano da Publicação</label>
				<label class="grow" for="isbn">ISBN</label>
				<label class="grow"	for="edition">Edição</label>
			</div>
			<div class="content-div-input">
				<input 
					class="grow" 
					type="text" 
					id="year"
					name="year" 
					value="${param.year}" 
					readonly
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
					type="number" 
					id="edition"
					name="edition"
					value="${param.edition}" 
					readonly
				>
			</div>
		</div>
		<div class="content-div">
			<div class="content-div-label">
				<label class="grow" for="idioma">Idioma</label>
				<label class="grow"	for="genre">Gênero</label>
			</div>
			<div class="content-div-label">
				<input 
					class="grow" 
					type="text" 
					id="idioma"
					name="idioma"
					value="${param.idioma}" 
					readonly
				>
				<input 
					class="grow" 
					type="text" 
					id="genre"
					name="genre"
					value="${param.genre}" 
					readonly
				>
			</div>
		</div>
		<label 
			for="sinopse">Sinopse</label>
		<textarea 
			id="sinopse"
			name="sinopse" 
			readonly
		>${param.sinopse}</textarea>
		
		<div class="buttons">
			<input
				class="btn button-submit" 
				type="submit" 
				value="ATUALIZAR"
			>			
			<input
				class="btn button-cancel" 
				type="button" 
				value="CANCELAR"
			>
		</div>
	</form>

</body>
</html>