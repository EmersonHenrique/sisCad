<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trocar Senha</title>
</head>
<body>
    <c:import url="cabecalho.jsp"/>
    <c:out value="${msg}"/>
    <a href="cad_menu.jsp">menu</a>
    <hr>
    <table>
    <form action="frmLogin" method="post">
    <tr>
      <td>Usuário:</td><td><input type="text" name="txtusuario"/></td>
    </tr>
    <tr>  
      <td>Senha Atual:</td><td><input type="password" name="txtsenhaAtual"/></td>
    </tr>  
    <tr> 
     <td>Nova Senha:</td><td><input type="password" name="txtSenhaNova"/></td>
    </tr> 
    <tr>                                                       
     <td>Confirmar Senha:</td><td><input type="password" name="txtConfirmarSenhaNova"/></td>
    </tr> 
    <tr> 
     <td><input type="submit" value="confirmar"></td> 
    </tr>         
    </form>
    </table>
</body>
</html>