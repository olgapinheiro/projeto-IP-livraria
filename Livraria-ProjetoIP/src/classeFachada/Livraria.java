package classeFachada;

import classesNegocio.CadastroEventos;
import classesNegocio.CadastroPessoas;
import classesNegocio.CadastroProdutos;
import classesNegocio.Cliente;
import classesNegocio.Funcionario;
import classesNegocio.Produto;
import exceptions.PessoaNaoEncontradaException;
import exceptions.ProdutoFaltandoNoEstoqueException;
import exceptions.ProdutoNaoEncontradoException;
import classesNegocio.CadastroEncomendas;

public class Livraria {
	private CadastroPessoas clientes;
	private CadastroPessoas funcionarios;
	private CadastroEventos eventos;
	private CadastroProdutos livros;
	private CadastroProdutos jogos;
	// private CadastroProdutos produtos;
	// private CadastroAdministradores administradores;

	private int itensVendidosMes; // quantidade de itens vendidos no mês
	private double receitaMes; // dinheiro arrecadado com as vendas do mês, em
								// reais
	private double custosMes;
	private double lucroMes; // receitas menos custos

	public Livraria(CadastroPessoas clientes, CadastroPessoas funcionarios, CadastroEventos eventos,
			CadastroProdutos livros, CadastroProdutos jogos) {
		this.clientes = clientes;
		this.funcionarios = funcionarios;
		this.eventos = eventos;
		this.livros = livros;
		this.jogos = jogos;
		this.itensVendidosMes = 0;
		this.receitaMes = 0;
		this.custosMes = 0;
		this.custosMes = 0;
		this.lucroMes = 0;
	}

	protected CadastroPessoas getClientes() {
		return clientes;
	}

	protected void setClientes(CadastroPessoas clientes) {
		this.clientes = clientes;
	}

	protected CadastroPessoas getFuncionarios() {
		return funcionarios;
	}

	protected void setFuncionarios(CadastroPessoas funcionarios) {
		this.funcionarios = funcionarios;
	}

	protected CadastroEventos getEventos() {
		return eventos;
	}

	protected void setEventos(CadastroEventos eventos) {
		this.eventos = eventos;
	}

	protected CadastroProdutos getJogos() {
		return jogos;
	}

	protected void setJogos(CadastroProdutos jogos) {
		this.jogos = jogos;
	}

	protected void setLivros(CadastroProdutos livros) {
		this.livros = livros;
	}

	// Métodos de Negócio

	// Venda de Livro

	public double venderProduto(Produto produto, Cliente cliente, Funcionario funcionario)
			throws ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException, PessoaNaoEncontradaException {

		produto = this.livros.procurar(produto.getCodigo());
		cliente = (Cliente) this.clientes.procurar(cliente.getCpf());
		funcionario = (Funcionario) this.funcionarios.procurar(funcionario.getCpf());
		if(produto.getEstoque()>0){
			produto.setEstoque(produto.getEstoque()-1);
			return produto.getPreco();
		}else {
			throw new ProdutoFaltandoNoEstoqueException();
		}
	}

}
