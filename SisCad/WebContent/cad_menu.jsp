<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
  <script type="text/javascript" src="js/validacao.js"></script>
  <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
  <link rel="styleSheet" type="text/css" href="css/style.css"/>   
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
  <c:import url="cabecalho.jsp"/>  
  <div id="conteiner">
	 <div id="header"> </div>
	  <c:out value="${msg}"/> 
	 <div id="menu">	   
	               <div id="wrapper">
	 <div id="navMenu">
		 
	 <!--**********************-->
	<ul>
	 <li><a href="#">Cadastro</a>
	 
	 <ul>		  
	    <li><a href="cad_cliente">Cliente</a>
	 
	 <ul>		  
	    <li><a href="cad_endereco.jsp">Endereco</a>		 
	 	  
	<ul>		  
	 <li><a href="cad_bairro.jsp">Bairro</a>	
	 
	 
	 <ul>		  
	 <li><a href="cad_cidade.jsp">Cidade</a>	
	 </ul>
	
	</li>
	</ul>
	</ul>
	</ul>
	</ul>
	<!--**********************-->
	
	 <ul>		  
	 <li><a href="List_cliente2">Lista</a></li>	
	 </ul>
	
	<ul>		  
	 <li><a href="#">Configuração</a>		 
	 <ul>	  
	 <li><a href="trocarsenha.jsp">Trocar Senha</a>	
	 </ul>	 
	 </ul>
	
		
	</div>
	</div>	   
	</div>
	   
	   <div id="conteudo"> 
	    
	      <div id="cliente">
	      
	       <center>
	           <br>
	           <br>
	           <br>
	           <br>
	            <form name="pesquisa_cliente" action="pesquisa_cliente" method="get">
	             <input type="text" size="50" name="txt_pesq"/>
	             <input type="button" value=".:Pesquisa" onclick="validarPesq()"/>	             
	      </form>
	             </center>    
	       </div>
	   </div>
	   <div id="rodape"></div>
	</div>
</body>
</html>