function validarLogin(){
	if(document.formLogin.txtUsuario.value==""){
		alert("Campo Usu�rio N�o Informado");  
		return false;
	} 
	if(document.formLogin.txtSenha.value==""){ 
		alert("Campo Senha N�o Informado");
		return false;
	} 
	
	document.formLogin.submit();
  }


function validarCad(){
	if(document.frm_cad_cliente.txt_nome.value==""){
		alert("Campo Nome N�o Informado");  
		return false;
	} 
	if(document.frm_cad_cliente.txt_num.value==""){ 
		alert("Campo N�mero N�o Informado");
		return false;
	}
	
	if(document.frm_cad_cliente.txt_tel.value==""){ 
		alert("Campo Telefone N�o Informado");
		return false;
	}
	
	document.frm_cad_cliente.submit();
  }

function validarPesq(){
	
	if(document.pesquisa_cliente.txt_pesq.value==""){ 
		alert("Campo Pesquisa N�o Informado");
		return false;
	}
	
	document.pesquisa_cliente.submit();
 }

function confirmacao(id){
       if(confirm("Deseja Excluir Loja " + id + " ? ")){ 
    	   location.href="/rem_cliente?id="+id;
       }else{
    	   return false; 
       }    	  
  }	

