<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="styleSheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente</title>
</head>
<body>
  <c:import url="cabecalho.jsp"/>
  <div id="conteiner">
	 <div id="header">header</div>
	   
	 <div id="menu">	   
	               <div id="wrapper">
	 <div id="navMenu">
	 
	 <ul>
	 <li><a href="index.html">Home</a>
	 </ul>
	 <ul>		  
	 <li><a href="cad_cliente.jsp">Novo</a></li>	
	 </ul>
	 
	 <ul>		  
	 <li><a href="List_cliente2?numPagina=1">Lista</a></li>	
	 </ul>
	
		
	</div>
	</div>	   
	</div>
	   
	   <div id="conteudo"> 
	      <div id="cliente">
	        <br>
	        <c:out value="${msg}"/>  
	        <table>
	        <form name="frm_cad_cliente" action="Cad_cliente" method="get">
	        <tr>
	            <td>Nome:</td><td><input type="text" name="txt_nome" size="50"></td>
	        </tr> 
	        <tr>
	           <td colspan="2"><input type="submit" value="cadastrar"/></td>
	        </tr>   
	        </form>
	       </table>
	       </div>
	   </div>
	   <div id="rodape"></div>
	</div>
</body>
</html>