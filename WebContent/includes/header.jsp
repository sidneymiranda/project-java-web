
<header class="header">
	<div class="header-content">
		<div class="logo">
			<span>Virtual Bookcase</span>
		</div>

		<h3 class="nameUser">	Ol�, <%= session.getAttribute("userLogado") %></h3>
		
		<a href="${pageContext.request.contextPath}/pages/logoff.jsp" id="logoff">Sair</a>
	
	</div>
</header>
