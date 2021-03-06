<%@page import="br.com.siscad.conexao.CriarConexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="br.com.siscad.endereco.EnderecoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/validacao.js"></script>
    <script type="text/javascript">
  function confirmacao(id){
       if(confirm("Deseja Excluir id " + id + " ? ")){ 
    	   location.href="rem_cliente?num="+id;
       }else{
    	   return false; 
       }    	  
  }	
</script>

<link rel="styleSheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>listar clientes</title>
</head>
<body>  
    <c:import url="cabecalho.jsp"/> 
    <div id="conteiner">
	   <div id="header">  </div>
	   <c:out value="${msg}"/>	   
	   <div id="menu">	   
	               <div id="wrapper">
	 <div id="navMenu">
	 
	 <ul>
	 <li><a href="cad_menu.jsp">In�cio</a>
	 <ul>		  
	 <li></li>	
	 </ul>	
	 </li>	
	 </ul>
	 <!--********************* -->
	 <ul>
	 <li><a href="VisualisarRelatorio?relat=clientes">Relat�rio</a>
	 <ul>		  
	 <li></li>	
	 </ul>	
	 </li>	
	 </ul>
	<!--**********************-->
	<ul>
	 <li><a href="index.html">Cadastro</a>
	 <ul>		  
	 <li><a href="cad_cliente">Cliente</a></li>	
	 </ul>
	
	</li>	
	</ul>	
		
	 </div>
	 </div>	   
	 </div>
	   
	   <div id="conteudo">
	      <div id="lista">
	      <center>
	      <br/>
	      <form name="pesquisa_cliente" action="pesquisa_cliente" method="get">
	          <input type="text" size="50" name="txt_pesq"/>
	          <input type="button" value=".:Pesquisa" onclick="validarPesq()"/>
	      </form>
	      <br/>
	   <table>
	      <tr>
	         <th>Id</th><th>Nome</th><th>Telefone</th><th colspan="3"></th>
	      </tr>
	      <c:forEach var="li" items="${list}" varStatus="id">	      
	     <tr bgcolor="#${id.count % 2 == 0 ? '#F0E68C' : 'ffffff' }" >	      
	          <td>${li.id}</td> <td>${li.nome}</td> <td>${li.telefone}</td> 
	       
	          <td><a href="rem_cliente?num=${li.id}"><img src="img/6239_32x32.png" onclick="confirmacao(${li.id})"/></a> </td>
	          <td><a href="atu_Cliente?num=${li.id}"><img src="img/package_editors.png"/></a></td>
	          <td><a href="VisualisarRelatorio?relat=${li.id}"><img src="img/printer1.png"/></a></td>
	      </tr>
	      </c:forEach> 
	   </table>
	     <%
	     Object object = request.getAttribute("totalRegistros");
	     int totalRegistros = Integer.parseInt(object.toString());
	     
	     String numPagina = request.getParameter("numPagina");
	     if(numPagina==null){
	    	// String string = String.valueOf(totalRegistros);
	    	 numPagina="1";
	      }	      
	        
	        for(int i = 1; i<=totalRegistros; i++)
	        	  if(i==Integer.parseInt(numPagina)) 
	        		  out.println(i);
	        	  else 
	        	     out.println("<a href=List_cliente2?numPagina="+i+">"+i+"</a>"); 	                 
	      %>
	   </center>
	   
	   </div>
	   </div>
	   <div id="rodape"></div>
	</div>
</body>
</html>