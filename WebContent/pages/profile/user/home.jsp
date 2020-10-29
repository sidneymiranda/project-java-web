<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileDefault.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
      rel="stylesheet"
    />
    <link
      rel="shortcut icon"
      href="${pageContext.request.contextPath}/images/favicon.ico"
      type="image/x-icon"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    />
    <title>Perfil do usuário</title>
  </head>
  <body>

    	<jsp:include page="/includes/isLoggedIn.jsp"/>
			<jsp:include page="/includes/header.jsp"/>
    <section class="form">
      <form action="#" method="post" id="form-search">
        <label class="input" for="input-search">Consulta</label>
        <input type="text" id="input-search" />

        <input type="submit" class="btn btn-primary" value="Pesquisar" />
        <input type="reset" value="Limpar" class="btn btn-secondary" />
      </form>
    </section>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>