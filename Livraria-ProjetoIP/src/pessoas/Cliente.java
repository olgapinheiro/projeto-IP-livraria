package pessoas;
////////////////////////////////////////////editando....
//testando edit
import encomenda.CadastroEncomendas;
import encomenda.Encomenda;
import livro.Livro;

public class Cliente extends Pessoa {
	double bonus;
	CadastroEncomendas encomendas;
	boolean clienteVIP;
	
	// construtores
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		bonus = 0;
		clienteVIP = false;
	}

	public Cliente(String nome, String cpf, String email, Endereco endereco, String telefone) {
		super(nome, cpf, email, endereco, telefone);
		bonus = 0;
		clienteVIP = false;
	}
	
	//getters & setters
	protected double getBonus() {
		return bonus;
	}

	protected void setBonus(double bonus) {
		this.bonus = bonus;
	}

	protected CadastroEncomendas getEncomendas() {
		return encomendas;
	}

	protected void setEncomendas(CadastroEncomendas encomendas) {
		this.encomendas = encomendas;
	}

	protected boolean isClienteVIP() {
		return clienteVIP;
	}

	protected void setClienteVIP(boolean clienteVIP) {
		this.clienteVIP = clienteVIP;
	}
	
	
	// metodos de negocio
	
	public double comprarLivro(String nome, String autor) throws LivroNaoEncontradoException{
		if(CadastroLivros.existe(nome, autor) && livro.getEstoque() > 0){
			Livro livro;
			livro = CadastroLivros.procurar(nome, autor);
			livro.setEstoque(livro.getEstoque()-1);
			return livro.getPreco();
			
		}else if(!CadastroLivros.existe(nome, autor){
			throw new LivroNaoEncontradoException();
		}else{
			throw new LivroFaltaNoEstoqueException();
		}
	}
	
	public void ganharBonus(double valorCompra){
		
	}
	
	public void usarBonus(double valorCompra){
		
	}
	
	public void fazerEncomenda(Encomenda encomenda){
		
	}
	
	public void receberEncomenda(Encomenda encomenda){
		
	}
	
	/*public String consultarEncomenda(Encomenda encomenda){
		
	}*/

}
