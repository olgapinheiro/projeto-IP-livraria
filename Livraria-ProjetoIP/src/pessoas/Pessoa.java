package pessoas;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private String email;
	private Endereco endereco;
	private String telefone;
	
	
	// construtores
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	public Pessoa(String nome, String cpf, String email, Endereco endereco, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	
	// getters & setters
	
	protected String getNome() {
		return nome;
	}
	protected String getCpf() {
		return cpf;
	}
	protected String getEmail() {
		return email;
	}
	protected Endereco getEndereco() {
		return endereco;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	protected String getTelefone() {
		return telefone;
	}


	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
