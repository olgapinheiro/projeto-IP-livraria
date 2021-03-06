package classeFachada;

import classesNegocio.CadastroEventos;
import classesNegocio.CadastroPessoas;
import classesNegocio.CadastroProdutos;
import classesNegocio.Cliente;
import classesNegocio.Encomenda;
import classesNegocio.Evento;
import classesNegocio.Funcionario;
import classesNegocio.Jogo;
import classesNegocio.Livro;
import classesNegocio.Produto;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaNaoEncontradaException;
import exceptions.EventoExistenteException;
import exceptions.EventoNaoExisteException;
import exceptions.MetaNaoAtingidaException;
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

	private Livro[] livrosMaisVendidos = new Livro[3];
	private Jogo[] jogosMaisVendidos = new Jogo[3];
	private int itensVendidosMes; // quantidade de itens vendidos no m�s
	private double receitaMes; // dinheiro arrecadado com as vendas do m�s, em
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
		this.setItensVendidosMes(0);
		this.setReceitaMes(0);
		this.setCustosMes(0);
		this.setLucroMes(0);
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

	// Cadastros

	// Cadastra

	public Livro[] getLivrosMaisVendidos() {
		return livrosMaisVendidos;
	}

	public void setLivrosMaisVendidos(Livro[] livrosMaisVendidos) {
		this.livrosMaisVendidos = livrosMaisVendidos;
	}

	public Jogo[] getJogosMaisVendidos() {
		return jogosMaisVendidos;
	}

	public void setJogosMaisVendidos(Jogo[] jogosMaisVendidos) {
		this.jogosMaisVendidos = jogosMaisVendidos;
	}

	public int getItensVendidosMes() {
		return itensVendidosMes;
	}

	public void setItensVendidosMes(int itensVendidosMes) {
		this.itensVendidosMes = itensVendidosMes;
	}

	public double getReceitaMes() {
		return receitaMes;
	}

	public void setReceitaMes(double receitaMes) {
		this.receitaMes = receitaMes;
	}

	public double getCustosMes() {
		return custosMes;
	}

	public void setCustosMes(double custosMes) {
		this.custosMes = custosMes;
	}

	public double getLucroMes() {
		return lucroMes;
	}

	public void setLucroMes(double lucroMes) {
		this.lucroMes = lucroMes;
	}

	public void CadastrarCliente(Cliente cliente) throws PessoaJaCadastradaException {
		this.clientes.cadastrar(cliente);
	}

	public void CadastrarFuncionarios(Funcionario funcionario) throws PessoaJaCadastradaException {
		this.funcionarios.cadastrar(funcionario);
	}

	public void CadastrarEventos(Evento evento) throws EventoExistenteException {
		this.eventos.cadastrar(evento);
	}

	public void CadastrarLivro(Livro livro) throws ProdutoJaCadastradoException {
		this.livros.cadastrar(livro);
	}

	public void CadastrarJogo(Jogo jogo) throws ProdutoJaCadastradoException {
		this.jogos.cadastrar(jogo);
	}
	// Remover

	public void RemoverCliente(String cpf) throws PessoaNaoEncontradaException {
		this.clientes.remover(cpf);
	}

	public void RemoverFuncionario(String cpf) throws PessoaNaoEncontradaException {
		this.funcionarios.remover(cpf);
	}

	public void RemoverEvento(String nome) throws EventoNaoExisteException {
		this.eventos.remover(nome);
	}

	public void RemoverLivro(String codigo) throws ProdutoNaoEncontradoException {
		this.livros.remover(codigo);
	}

	public void Removerjogo(String codigo) throws ProdutoNaoEncontradoException {
		this.jogos.remover(codigo);
	}
	// Atualizar

	public void AtualizarCliente(Cliente cliente, Cliente clienteAtualizado) throws PessoaNaoEncontradaException {
		this.clientes.atualizar(cliente, clienteAtualizado);
	}

	public void AtualizarFuncionario(Funcionario funcionario, Funcionario funcionarioAtualizado)
			throws PessoaNaoEncontradaException {
		this.funcionarios.atualizar(funcionario, funcionarioAtualizado);
	}

	public void AtualizarEvento(String nome, Evento evento) throws EventoNaoExisteException {
		this.eventos.atualizar(nome, evento);
	}

	public void AtualizarLivro(Livro livro, Livro livroAtualizado) throws ProdutoNaoEncontradoException {
		this.livros.atualizar(livro, livroAtualizado);
	}

	public void AtualizarJogo(Jogo jogo, Jogo jogoAtualizado) throws ProdutoNaoEncontradoException {
		this.jogos.atualizar(jogo, jogoAtualizado);
	}

	// Procurar

	public Cliente procurarCliente(String cpf) throws PessoaNaoEncontradaException {
		return (Cliente) this.clientes.procurar(cpf);

	}

	public Funcionario procurarFuncionario(String cpf) throws PessoaNaoEncontradaException {
		return (Funcionario) this.funcionarios.procurar(cpf);
	}

	public Evento procurarEvento(String nome) throws EventoNaoExisteException {
		return this.eventos.procurar(nome);
	}

	public Livro procurarLivro(String codigo) throws ProdutoNaoEncontradoException {
		return (Livro) this.livros.procurar(codigo);
	}

	public Jogo procurarJogo(String codigo) throws ProdutoNaoEncontradoException {
		return (Jogo) this.jogos.procurar(codigo);
	}

	// ----- M�todos de Neg�cio ------

	// Venda de produto

	// Venda atribuida a um funcionario:
	public double venderProduto(Produto produto, Cliente cliente, Funcionario funcionario)
			throws ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException, PessoaNaoEncontradaException {

		produto = this.livros.procurar(produto.getCodigo());
		cliente = (Cliente) this.clientes.procurar(cliente.getCpf());
		funcionario = (Funcionario) this.funcionarios.procurar(funcionario.getCpf());
		if (produto.getEstoque() > 0) {
			produto.setEstoque(produto.getEstoque() - 1);
			cliente.ganharBonus(produto.getPreco());
			funcionario.renderComissao(produto.getPreco());
			funcionario.setVendasMes(funcionario.getVendasMes() + 1);
			this.setItensVendidosMes(this.getItensVendidosMes() + 1);
			this.setReceitaMes(this.getReceitaMes() + produto.getPreco());
			return produto.getPreco();
		} else {
			throw new ProdutoFaltandoNoEstoqueException();
		}
	}

	// Venda realizada sem participacao de funcionario:
	public double venderProduto(Produto produto, Cliente cliente)
			throws ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException, PessoaNaoEncontradaException {

		produto = this.livros.procurar(produto.getCodigo());
		cliente = (Cliente) this.clientes.procurar(cliente.getCpf());
		if (produto.getEstoque() > 0) {
			produto.setEstoque(produto.getEstoque() - 1);
			cliente.ganharBonus(produto.getPreco());
			this.setItensVendidosMes(this.getItensVendidosMes() + 1);
			this.setReceitaMes(this.getReceitaMes() + produto.getPreco());
			return produto.getPreco();
		} else {
			throw new ProdutoFaltandoNoEstoqueException();
		}
	}

	public void fazerEncomenda(Cliente cliente, Encomenda encomenda)
			throws PessoaNaoEncontradaException, EncomendaJaCadastradaException {
		cliente = (Cliente) this.clientes.procurar(cliente.getCpf());
		cliente.fazerEncomenda(encomenda);
	}

	public void fecharMesFuncionarios(int metaVendasIndividual, CadastroPessoas funcionarios)
			throws PessoaNaoEncontradaException {
		Funcionario funcionario = (Funcionario) funcionarios.proximaPessoa("");
		while (funcionario != null) {
			/* boolean salarioAumentou = */funcionario.aumentarSalario(metaVendasIndividual);
			/* double comissaoTotal = */funcionario.receberComissao();
			funcionario = (Funcionario) funcionarios.proximaPessoa(funcionario.getCpf());
		}
		// lembrar de incluir na ClassePrograma a impressao dos dados em um
		// relatorio
	}

	// verificar entrega das encomendas
	public void fecharMesClientes(CadastroPessoas clientes) throws PessoaNaoEncontradaException,
			EncomendaNaoEncontradaException, ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException {
		Cliente cliente = (Cliente) clientes.proximaPessoa("");
		while (cliente != null) {
			Encomenda encomenda = cliente.getEncomendas().proximaEncomenda("");
			while (cliente.getEncomendas().proximaEncomenda(encomenda.getNumeroPedido()) != null) {
				if (encomenda.getPrazoEntrega() == 0) {
					cliente.getEncomendas().entregarEncomenda(encomenda);
					this.venderProduto(encomenda.getProduto(), cliente);
				}
			}
		}
	}


	public void fecharMesProdutos(CadastroProdutos produtos) throws ProdutoNaoEncontradoException {
		int estoqueMaximo = 5;
		Produto produto = produtos.proximoProduto("");

		Produto[] maisVendidos = new Produto[3];
		maisVendidos[0] = produto; // 1� produto mais vendido
		maisVendidos[1] = produto; // 2� produto mais vendido
		maisVendidos[2] = produto; // 3� produto mais vendido

		while (produto != null) {

			// renovacao do estoque:
			if (produto.getEstoque() == 0) {
				produto.setEstoque(estoqueMaximo);
				this.setCustosMes(this.getCustosMes() + estoqueMaximo * produto.getPreco());
			}

			// verificacao dos mais vendidos
			if (produto.getVendasMes() >= maisVendidos[0].getVendasMes()) {
				maisVendidos[2] = maisVendidos[1];
				maisVendidos[1] = maisVendidos[0];
				maisVendidos[0] = produto;
			} else if (produto.getVendasMes() >= maisVendidos[1].getVendasMes()) {
				maisVendidos[2] = maisVendidos[1];
				maisVendidos[1] = produto;
			} else if (produto.getVendasMes() >= maisVendidos[2].getVendasMes()) {
				maisVendidos[2] = produto;
			}

			// chamar o proximo produto do repositorio
			produto = produtos.proximoProduto(produto.getCodigo());
		}

		// armazenar os mais vendidos na variavel adequada, dependendo do
		// repositorio de entrada:
		if (produto instanceof Livro) {
			this.setLivrosMaisVendidos((Livro[]) maisVendidos);
		} else if (produto instanceof Jogo) {
			this.setJogosMaisVendidos((Jogo[]) maisVendidos);
		}
	}

	public void fecharMesGeral(int metaVendasIndividual) throws ProdutoNaoEncontradoException, PessoaNaoEncontradaException, EncomendaNaoEncontradaException, ProdutoFaltandoNoEstoqueException {
		fecharMesProdutos(livros);
		fecharMesProdutos(jogos);
		fecharMesFuncionarios(metaVendasIndividual, funcionarios);
		fecharMesClientes(clientes);
	}

}
