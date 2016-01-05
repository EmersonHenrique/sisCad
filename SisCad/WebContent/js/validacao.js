function validarLogin(){
	if(document.formLogin.txtUsuario.value==""){
		alert("Campo Usuário Não Informado");  
		return false;
	} 
	if(document.formLogin.txtSenha.value==""){ 
		alert("Campo Senha Não Informado");
		return false;
	} 
	
	document.formLogin.submit();
  }


function validarCad(){
	if(document.frm_cad_cliente.txt_nome.value==""){
		alert("Campo Nome Não Informado");  
		return false;
	} 
	if(document.frm_cad_cliente.txt_num.value==""){ 
		alert("Campo Número Não Informado");
		return false;
	}
	
	if(document.frm_cad_cliente.txt_tel.value==""){ 
		alert("Campo Telefone Não Informado");
		return false;
	}
	
	document.frm_cad_cliente.submit();
  }

function validarPesq(){
	
	if(document.pesquisa_cliente.txt_pesq.value==""){ 
		alert("Campo Pesquisa Não Informado");
		return false;
	}
	
	document.pesquisa_cliente.submit();
 }

function validarBai(){
	
	if(document.form_cad_bairro.txt_nome.value==""){ 
		alert("Campo Pesquisa Não Informado");
		return false;
	}
	
	document.form_cad_bairro.submit();
 }

function validarEnd(){
	
	if(document.frm_cad_endereco.txt_nome.value==""){ 
		alert("Campo Pesquisa Não Informado");
		return false;
	}
	
	document.frm_cad_endereco.submit();
 }

function validarCid(){
	
	if(document.frm_cad_cidade.txt_nome.value==""){ 
		alert("Campo Pesquisa Não Informado");
		return false;
	}
	
	document.frm_cad_cidade.submit();
 }

function confirmacao(id){
       if(confirm("Deseja Excluir Loja " + id + " ? ")){ 
    	   location.href="/rem_cliente?id="+id;
       }else{
    	   return false; 
       }    	  
  }	

