<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileAdm.css" />
<title>Deleção de dados</title>
</head>
<body>

	<h1 class="title-confirm">Tem certeza que deseja remover o cadastro?</h1>
	
	
	<form class="form" method="post" action="${pageContext.request.contextPath}/remove-book">
		<label for="title">Título</label>
		<input 
			type="text" 
			class="input"
			id="title"
			name="title"
			value="${param.title}"
			disabled
		>
		<label for="author">Nome do autor</label>
		<input 
			type="text" 
			name="author" 
			class="input"
			id="author"
			value="${param.author}"
			disabled
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
					disabled
				>
				<input 
					class="grow" 
					type="text" 
					id="isbn"
					name="isbn"
					value="${param.isbn}" 
					disabled
				>
				<input 
					class="grow" 
					type="number" 
					id="edition"
					name="edition"
					value="${param.edition}" 
					disabled
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
					disabled
				>
				<input 
					class="grow" 
					type="text" 
					id="genre"
					name="genre"
					value="${param.genre}" 
					disabled
				>
			</div>
		</div>
		<label 
			for="sinopse">Sinopse</label>
		<textarea 
			id="sinopse"
			name="sinopse" 
			disabled
		>${param.sinopse}</textarea>
		
		<div class="buttons">
			<input
				class="btn button-submit" 
				type="submit" 
				value="CONFIRMAR"
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