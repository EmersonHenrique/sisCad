<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="contato" class="br.com.siscad.endereco.Endereco"/>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <body>
     <div id="pagina1" align="center">
	    <br>
	    <br>
	    <br>
	    <br>	    
		<form name="frm_cad" action="cad_bairro" method="get">		    			
			Bairro:<input type="text" name="txt_name" size="40"/> <br><br>
                 <input type="submit" value="cadastrar"/>
			</form>		
	 </div>	
	 	 
	 <div id="pagina2" align="center">
	    <br>
	    <br>
	    <br>
	    <br>	    
		<form name="frm_cad" action="Cad_endereco" method="get">		    			
			CEP:<input type="text" name="txt_cep" size="22" />Endereco.:<input type="text" name="txt_name" size="40"/> <br><br>
                 <input type="submit" value="cadastrar"/>
			</form>		
	 </div>	
	 
	 <div id="pagina3" align="center">
	    <br>
	    <br>
	    <br>
	    <br>	    
		<form name="frm_cad" action="Cad_cidade" method="get">		    			
			Cidade:<input type="text" name="txt_name" size="40"/> <br><br>
                 <input type="submit" value="cadastrar"/>
			</form>		
	 </div>	
</body>
</html>