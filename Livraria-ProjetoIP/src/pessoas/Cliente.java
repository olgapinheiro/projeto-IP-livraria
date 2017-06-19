package pessoas;

import encomenda.CadastroEncomendas;
import encomenda.Encomenda;
import encomenda.EncomendaJaCadastradaException;
import encomenda.EncomendaJaCanceladaException;
import encomenda.EncomendaNaoEncontradaException;
import livro.Livro;

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

	public double comprarLivro(String nome, String autor, CadastroLivros livros)
			throws LivroNaoEncontradoException, LivroFaltaNoEstoqueException {
		if (livros.existe(nome, autor)) {
			Livro livro;
			livro = livros.procurar(nome, autor);
			if (livro.getEstoque() > 0) {
				livro.setEstoque(livro.getEstoque() - 1);
				return livro.getPreco();
			} else {
				throw new LivroFaltaNoEstoqueException();
			}

		} else {
			throw new LivroNaoEncontradoException();
		}
	}

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
