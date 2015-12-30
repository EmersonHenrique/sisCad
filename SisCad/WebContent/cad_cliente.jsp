<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script type="text/javascript" src="js/validacao.js"></script>
  <link rel="styleSheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente</title>
</head>
<body>
  <c:import url="cabecalho.jsp"/>
  <div id="conteiner">
	 <div id="header"> </div>
	   
	 <div id="menu">	   
	               <div id="wrapper">
	 <div id="navMenu">
	 
	 <ul>
	 <li><a href="index.html">Home</a>
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
	            <td>Endere�o:</td>
	                <td>
	                <select name="endereco">
	                  <c:forEach items="${end}" var="e">
	                     <option value="${e.logradouro}">${e.logradouro}</option>
	                  </c:forEach> 	                
	                </select>
	                
	        N�<input type="text" name="txt_num" size="5">        
	        </td>
	        </tr>
	        
	        <tr>
	        	        
	            <td>Bairro:</td>
	            <td>
	              <select name="bairro">
	                <c:forEach items="${bai}" var="b">
	                    <option value="${b.nome}">${b.nome}</option>	                
	                </c:forEach>
	               </select></td>
	        </tr>
	        <tr>       
	            <td>Cidade:</td>
	            <td>
	              <select name="cidade">
	                <c:forEach items="${cid}" var="c">
	                   <option value="${c.nome}">${c.nome}</option>
	                </c:forEach>
	               </select></td> 
	        </tr>	        
	        <tr>
	           <td>Tel:</td><td><input type="text" name="txt_tel" size="30"></td>
	        </tr> 
	        <tr>
	           <td colspan="2"><input type="button" value="cadastrar" onclick="validarCad()"/></td>
	        </tr>   
	        </form>
	       </table>
	       </div>
	   </div>
	   <div id="rodape"></div>
	</div>
</body>
</html>