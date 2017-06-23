package classeFachada;

import classesNegocio.CadastroEventos;
import classesNegocio.CadastroPessoas;
import classesNegocio.CadastroProdutos;
import classesNegocio.Cliente;
import classesNegocio.Evento;
import classesNegocio.Funcionario;
import classesNegocio.Jogo;
import classesNegocio.Livro;
import classesNegocio.Produto;
import exceptions.EventoExistenteException;
import exceptions.EventoNaoExisteException;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;
import exceptions.ProdutoFaltandoNoEstoqueException;
import exceptions.ProdutoJaCadastradoException;
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
	//Cadastra
	
	public void CadastroCliente(Cliente cliente) throws PessoaJaCadastradaException{
		this.clientes.cadastrar(cliente);
	}
	public void CadastroFuncionarios(Funcionario funcionario) throws PessoaJaCadastradaException{
		this.funcionarios.cadastrar(funcionario);
	}
	public void CadastroEventos(Evento evento) throws EventoExistenteException{
		this.eventos.cadastrar(evento);;
	}
	public void CadastroLivro(Livro livro) throws ProdutoJaCadastradoException{
		this.livros.cadastrar(livro);;
	}
	public void CadastroJogo(Jogo jogo) throws ProdutoJaCadastradoException{
		this.jogos.cadastrar(jogo);
	}
	//Remover
	
	public void RemoverCliente(String cpf) throws PessoaNaoEncontradaException{
		this.clientes.remover(cpf);
	}
	public void RemoverFuncionario(String cpf) throws PessoaNaoEncontradaException{
		this.funcionarios.remover(cpf);
	}
	public void RemoverEvento(String nome) throws EventoNaoExisteException{
		this.eventos.remover(nome);
	}
	public void RemoverLivro(String codigo) throws ProdutoNaoEncontradoException{
		this.livros.remover(codigo);
	}
	public void Removerjogo(String codigo) throws ProdutoNaoEncontradoException{
		this.jogos.remover(codigo);
	}
	//Atualizar
	
	public void AtualizerCliente(Cliente cliente, Cliente clienteAtualizado) throws PessoaNaoEncontradaException{
		this.clientes.atualizar(cliente, clienteAtualizado);
	}
	public void AtualizerFuncionario(Funcionario funcionario,Funcionario funcionarioAtualizado) throws PessoaNaoEncontradaException{
		this.funcionarios.atualizar(funcionario, funcionarioAtualizado);
	}
	public void AtualizerEvento(String nome,Evento evento) throws EventoNaoExisteException {
		this.eventos.atualizar(nome,evento);
	}
	public void AtualizerLivro(Livro livro, Livro livroAtualizado) throws ProdutoNaoEncontradoException {
		this.livros.atualizar(livro, livroAtualizado);
	}
	public void AtualizerJogo(Jogo jogo , Jogo jogoAtualizado) throws ProdutoNaoEncontradoException {
		this.jogos.atualizar(jogo, jogoAtualizado);
	}
	//Procurar
	
	public Cliente procurarCliente(String cpf) throws PessoaNaoEncontradaException{
		return (Cliente) this.clientes.procurar(cpf);
		
	}
	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoEncontradaException{
		return (Funcionario) this.funcionarios.procurar(cpf);
	}
	public Evento procurarEvento(String nome) throws EventoNaoExisteException{
		return this.eventos.procurar(nome);
	}
	public Livro procurarLivro(String codigo) throws ProdutoNaoEncontradoException{
		return (Livro) this.livros.procurar(codigo);
	}
	public Jogo procurarJogo(String codigo) throws ProdutoNaoEncontradoException{
		return (Jogo) this.jogos.procurar(codigo);
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
