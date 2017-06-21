package classesNegocio;

import exceptions.MetaNaoAtingidaException;

public class Funcionario extends Pessoa {
	double salario;
	double comissao;
	int vendasMes;
	// CadastroLivros livros;
	// int funcionarioDestaque;

	// construtor
	public Funcionario(String nome, String cpf) {
		super(nome, cpf);
	}

	// getters & setters
	protected double getSalario() {
		return salario;
	}

	protected void setSalario(double salario) {
		this.salario = salario;
	}

	protected double getComissao() {
		return comissao;
	}

	protected void setComissao(double comissao) {
		this.comissao = comissao;
	}

	protected int getVendasMes() {
		return vendasMes;
	}

	protected void setVendasMes(int vendasMes) {
		this.vendasMes = vendasMes;
	}

	// metodos especificos

	/*public void venderLivro(Livro livro) throws ProdutoFaltandoNoEstoqueException {
		if (livro.getEstoque() > 0) {
			this.vendasMes += 1;
		} else {
			throw new ProdutoFaltandoNoEstoqueException();
		}
	}*/

	public void renderComissao(double valorVenda) {
		this.comissao += valorVenda * 0.01;
	}

	public double receberComissao() {
		double comissaoTotal = this.comissao;
		this.comissao = 0;
		return comissaoTotal;
	}

	public double aumentarSalario(int metaVendas) throws MetaNaoAtingidaException {
		if (this.vendasMes > metaVendas) {
			this.salario *= 1.05;
			return this.salario;
		} else {
			throw new MetaNaoAtingidaException();
		}
	}

}
