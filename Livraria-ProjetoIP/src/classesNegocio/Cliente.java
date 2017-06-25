package classesNegocio;

import dados.RepositorioEncomendas;
import dados.RepositorioEncomendasTAD;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaJaCanceladaException;
import exceptions.EncomendaNaoEncontradaException;

public class Cliente extends Pessoa {
	private double bonus;
	private RepositorioEncomendas repEncomendasLista = new RepositorioEncomendasTAD();
	private CadastroEncomendas encomendas = new CadastroEncomendas(repEncomendasLista);
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
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public CadastroEncomendas getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(CadastroEncomendas encomendas) {
		this.encomendas = encomendas;
	}

	public boolean isClienteVIP() {
		return clienteVIP;
	}

	public void setClienteVIP(boolean clienteVIP) {
		this.clienteVIP = clienteVIP;
		this.bonusFactor = 0.01;
	}

	// metodos de negocio

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

	public long consultarEncomenda(Encomenda encomenda) throws EncomendaNaoEncontradaException {
		return encomendas.prazoRestante(encomenda);
	}

	public void cancelarEncomenda(Encomenda encomenda)
			throws EncomendaNaoEncontradaException, EncomendaJaCanceladaException {
		encomendas.cancelarEncomenda(encomenda);
	}
}
