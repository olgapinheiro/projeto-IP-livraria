package classesNegocio;

import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaJaCanceladaException;
import exceptions.EncomendaNaoEncontradaException;
import exceptions.ProdutoFaltandoNoEstoqueException;
import exceptions.ProdutoNaoEncontradoException;

public class Cliente extends Pessoa {
	private double bonus;
	private CadastroEncomendas encomendas;
	private boolean clienteVIP;
	private double bonusFactor;

	// construtores
	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		this.bonus = 0;
		this.clienteVIP = false;
		this.bonusFactor = 0.005;
	}

	public Cliente(String nome, String cpf, String email, Endereco endereco, String telefone) {
		super(nome, cpf, email, endereco, telefone);
		this.bonus = 0;
		this.clienteVIP = false;
		this.bonusFactor = 0.01;
	}

	// getters & setters
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
		this.bonusFactor = 0.01;
	}

	// metodos de negocio

	/*public double comprarProduto(String nome, String autor, CadastroProdutos produtos)
			throws ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException {
		if (produtos.existe(nome, autor)) {
			Produto produto;
			produto = produtos.procurar(nome, autor);
			if (produto.getEstoque() > 0) {
				produto.setEstoque(produto.getEstoque() - 1);
				return produto.getPreco();
			} else {
				throw new ProdutoFaltandoNoEstoqueException();
			}

		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}*/

	public void ganharBonus(double valorCompra) {
		this.bonus += valorCompra * this.bonusFactor;
		if (!this.isClienteVIP() && this.bonus >= 100) {
			this.setClienteVIP(clienteVIP);
		}
	}

	public double usarBonus(double valorCompra) {
		double bonusUsado;
		if (valorCompra >= this.bonus) {
			bonusUsado = this.bonus;
			this.bonus = 0;
		} else {
			bonusUsado = valorCompra;
			this.bonus -= bonusUsado;
		}
		return bonusUsado;
	}

	public void fazerEncomenda(Encomenda encomenda) throws EncomendaJaCadastradaException {
		encomendas.novaEncomenda(encomenda);
	}

	public void receberEncomenda(Encomenda encomenda) throws EncomendaNaoEncontradaException {
		encomendas.entregarEncomenda(encomenda);
	}

	public String consultarEncomenda(Encomenda encomenda) throws EncomendaNaoEncontradaException {
		return encomendas.prazoRestante(encomenda);
	}

	public void cancelarEncomenda(Encomenda encomenda)
			throws EncomendaNaoEncontradaException, EncomendaJaCanceladaException {
		encomendas.cancelarEncomenda(encomenda);
	}
}
