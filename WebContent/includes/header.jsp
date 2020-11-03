
<header class="header">
	<div class="header-content">
		<div class="logo">
			<span>Virtual Bookcase</span>
		</div>

		<h3 class="nameUser">	Olá, <%= session.getAttribute("userLogado") %></h3>
		
		<a href="${pageContext.request.contextPath}/pages/logoff.jsp" id="logoff">
			<svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-power" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  <path fill-rule="evenodd" d="M5.578 4.437a5 5 0 1 0 4.922.044l.5-.866a6 6 0 1 1-5.908-.053l.486.875z"/>
			  <path fill-rule="evenodd" d="M7.5 8V1h1v7h-1z"/>
			</svg>
		</a>
	
	</div>
</header>
