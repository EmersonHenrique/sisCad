<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
  <script type="text/javascript" src="js/validacao.js"></script>
  <link rel="styleSheet" type="text/css" href="css/style02.css"/>    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bairro</title>
</head>
<body>
  <c:import url="cabecalho.jsp"/>
  <div id="conteiner">
	 <div id="header"><h1>Bairro</h1> </div>
	   
	 <div id="menu">	   
	               <div id="wrapper">
	 <div id="navMenu">
	 
	
		
	</div>
	</div>	   
	</div>
	   
	   <div id="conteudo"> 	      
	      <div id="cliente">
	        <br>
	        <c:out value="${msg}"/>  
	        <table border="0">
	          <form name="form_cad_bairro" action="cad_bairro" method="get">	       
	            <td>Nome:</td><td><input type="text" name="txt_nome" size="50"></td> 	         	        
	           <td colspan="2"><input type="button" value="cadastrar" onclick="validarBai()"/></td>	           
	        </form>
	       </table>
	       </div>
	   </div>
	   <div id="rodape"></div>
	</div>
</body>
</html>