<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
  <script type="text/javascript" src="js/validacao.js"></script>
  <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
  <link rel="styleSheet" type="text/css" href="css/style.css"/>
  
    <script type="text/javascript">
    $(document).ready(function(e){
	  $('.pagina').click(function(){
	      $('#modal').fadeIn(500);
          var url = $(this).attr('href');		  
		 $('.modal-box-conteudo').load("pagina.html "+url);
		 });
	      $('.fechar,#modal').click(function(event){
		     if(event.target !== this){
			 return
			 }
		  $('#modal').fadeOut(500);
		  });
	});
  </script>
  
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
	 
	 <!--**********************-->
	<ul>
	 <li><a href="index.html">Cadastro</a>
	 
	 <ul>		  
	    <li><a href="cad_endereco.jsp" target="_blank">Endereco</a>		 
	 	  
	<ul>		  
	 <li><a href="cad_bairro.jsp" target="_blank">Bairro</a>	
	 
	 
	 <ul>		  
	 <li><a href="cad_cidade" target="_blank">Cidade</a>	
	 </ul>
	
	</li>
	</ul>
	</ul>
	</ul>
	<!--**********************-->
	 
	 <ul>		  
	 <li><a href="List_cliente2?numPagina=1">Lista</a></li>	
	 </ul>
	
		
	</div>
	</div>	   
	</div>
	   
	   <div id="conteudo"> 
	    <!-- 
		| <a href="#pagina1" class="pagina">Pagina 1</a>
		| <a href="#pagina2" class="pagina">Pagina 2</a>
		| <a href="#pagina3" class="pagina">Pagina 3</a>
		 -->
		  <div id="modal">
		    <div class="modal-box">
			   <div class="modal-box-conteudo">
			   </div>
			   <div class="fechar">X</div>
			</div>
		  </div>
	      <div id="cliente">
	        <br>
	        <c:out value="${msg}"/>  
	        <table border="0">
	        <form name="frm_cad_cliente" action="Cad_cliente" method="get">
	        <tr>
	            <td>Nome:</td><td><input type="text" name="txt_nome" size="50"></td> 
	        </tr> 
	        
	        <tr>
	            <td>Endereço: <a href="cad_endereco.jsp" target="_blank">...</a></td>
	                <td>
	                <select name="endereco">
	                  <c:forEach items="${end}" var="e">
	                     <option value="${e.logradouro}">${e.logradouro}</option>
	                  </c:forEach> 	                
	                </select>
	                
	        Nº<input type="text" name="txt_num" size="5">        
	        </td>
	        </tr>
	        
	        <tr>
	        	        
	            <td>Bairro:<a href="cad_bairro.jsp" target="_blank">...</a></td>
	            <td>
	              <select name="bairro">
	                <c:forEach items="${bai}" var="b">
	                    <option value="${b.nome}">${b.nome}</option>	                
	                </c:forEach>
	               </select></td>
	        </tr>
	        <tr>       
	            <td>Cidade:<a href="cad_cidade.jsp" target="_blank">...</a></td>
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