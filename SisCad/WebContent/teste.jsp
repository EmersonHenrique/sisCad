<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <form action="VisualisarRelatorio" method="post">
         <input type="submit" value="relatorrio" name="btVisualizar"/>
      </form>
      <br>
      
      <a href="VisualisarRelatorio?relat=cliente">clintes</a>
      <br>
      
      <br>
            
      <form action="GerarPDF" method="post">
         <input type="submit" value="Gerar PDF" name="btVisualizar"/>
      </form>
      <br>
      
      <form action="GerarHTML" method="post">
         <input type="submit" value="Gerar HTML" name="btVisualizar"/>
      </form>
</body>
</html>