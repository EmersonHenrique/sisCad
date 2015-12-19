package br.com.siscad.cliente;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private int endereco;
    private int bairro;
    private int cidade;
    private String UF; 
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	public int getBairro() {
		return bairro;
	}
	public void setBairro(int bairro) {
		this.bairro = bairro;
	}
	public int getCidade() {
		return cidade;
	}
	public void setCidade(int cidade) {
		this.cidade = cidade;
	}
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	
	
}
