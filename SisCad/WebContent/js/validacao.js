function confirmacao(id){
       if(confirm("Deseja Excluir Loja " + id + " ? ")){ 
    	   location.href="/rem_cliente?id="+id;
       }else{
    	   return false; 
       }    	  
  }	

