package classePrograma;

import classeFachada.Livraria;
import classesNegocio.CadastroEventos;
import classesNegocio.CadastroPessoas;
import classesNegocio.CadastroProdutos;
import classesNegocio.Cliente;
import classesNegocio.Funcionario;
import classesNegocio.Jogo;
import classesNegocio.Livro;
import classesNegocio.Produto;
import dados.RepositorioEventos;
import dados.RepositorioEventosArray;
import dados.RepositorioEventosTAD;
import dados.RepositorioInvalidoException;
import dados.RepositorioPessoas;
import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasTAD;
import dados.RepositorioProdutos;
import dados.RepositorioProdutosArray;
import dados.RepositorioProdutosTAD;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;
import exceptions.ProdutoFaltandoNoEstoqueException;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

import java.util.Scanner;

public class ClassePrograma {

	public static void main(String[] args) throws ProdutoNaoEncontradoException, ProdutoFaltandoNoEstoqueException,
			PessoaNaoEncontradaException, ProdutoJaCadastradoException, PessoaJaCadastradaException {
		RepositorioPessoas repClientesArray = new RepositorioPessoasArray();
		RepositorioPessoas repClientesTAD = new RepositorioPessoasTAD();
		RepositorioPessoas repFuncionariosArray = new RepositorioPessoasArray();
		RepositorioPessoas repFuncionariosTAD = new RepositorioPessoasTAD();
		RepositorioEventos repEventosArray = new RepositorioEventosArray();
		RepositorioEventos repEventosTAD = new RepositorioEventosTAD();
		RepositorioProdutos repLivrosArray = new RepositorioProdutosArray();
		RepositorioProdutos repLivrosTAD = new RepositorioProdutosTAD();
		RepositorioProdutos repJogosArray = new RepositorioProdutosArray();
		RepositorioProdutos repJogosTAD = new RepositorioProdutosTAD();
		CadastroPessoas clientes;
		CadastroPessoas funcionarios;
		CadastroEventos eventos;
		CadastroProdutos livros;
		CadastroProdutos jogos;
		Livraria livraria;
		Scanner in = new Scanner(System.in);

		String teste = in.nextLine(); // aqui será usado o arquivo config.txt

		// criação de vários objetos "livro" para cadastrar no acervo
		// (repositorio)
		Livro livro1 = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "91001", 5);
		Livro livro2 = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "91002", 5);
		Livro livro3 = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "91003", 5);
		Livro livro4 = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "91004", 5);
		Livro livro5 = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "91005", 5);

		// criação de vários objetos "jogo" para cadastrar no acervo
		// (repositorio)
		Jogo jogo1 = new Jogo("Jogo irado", "PS4", 79.90, "92001", 5);
		Jogo jogo2 = new Jogo("Jogo irado", "PS4", 79.90, "92002", 5);
		Jogo jogo3 = new Jogo("Jogo irado", "PS4", 79.90, "92003", 5);
		Jogo jogo4 = new Jogo("Jogo irado", "PS4", 79.90, "92004", 5);
		Jogo jogo5 = new Jogo("Jogo irado", "PS4", 79.90, "92005", 5);

		// criação de vários objetos "cliente" para cadastrar no sistema
		Cliente cliente1 = new Cliente("Jose", "123.456.789-10");
		Cliente cliente2 = new Cliente("Jose", "321.654.987-01");
		Cliente cliente3 = new Cliente("Jose", "456.123.987-11");
		Cliente cliente4 = new Cliente("Jose", "789.456.123-10");
		Cliente cliente5 = new Cliente("Jose", "789.123.456-15");

		// criação de vários objetos "funcionário" para cadastrar no sistema
		Funcionario funcionario1 = new Funcionario("Joana", "123.456.789-22");
		Funcionario funcionario2 = new Funcionario("Joana", "321.654.987-56");
		Funcionario funcionario3 = new Funcionario("Joana", "456.123.987-53");
		Funcionario funcionario4 = new Funcionario("Joana", "789.456.123-21");
		Funcionario funcionario5 = new Funcionario("Joana", "789.123.456-76");

		if (teste.equalsIgnoreCase("Array")) {
			clientes = new CadastroPessoas(repClientesArray);
			funcionarios = new CadastroPessoas(repFuncionariosArray);
			eventos = new CadastroEventos(repEventosArray);
			livros = new CadastroProdutos(repLivrosArray);
			jogos = new CadastroProdutos(repJogosArray);
			livraria = new Livraria(clientes, funcionarios, eventos, livros, jogos);
		} else {
			clientes = new CadastroPessoas(repClientesTAD);
			funcionarios = new CadastroPessoas(repFuncionariosTAD);
			eventos = new CadastroEventos(repEventosTAD);
			livros = new CadastroProdutos(repLivrosTAD);
			jogos = new CadastroProdutos(repJogosTAD);
			livraria = new Livraria(clientes, funcionarios, eventos, livros, jogos);
		} /*
			 * else { throw new RepositorioInvalidoException(); }
			 */

		try {
			livros.cadastrar(livro1);
			livros.cadastrar(livro2);
			livros.cadastrar(livro3);
			livros.cadastrar(livro4);
			livros.cadastrar(livro5);

			jogos.cadastrar(jogo1);
			jogos.cadastrar(jogo2);
			jogos.cadastrar(jogo3);
			jogos.cadastrar(jogo4);
			jogos.cadastrar(jogo5);

			clientes.cadastrar(cliente1);
			clientes.cadastrar(cliente2);
			clientes.cadastrar(cliente3);
			clientes.cadastrar(cliente4);
			clientes.cadastrar(cliente5);

			funcionarios.cadastrar(funcionario1);
			funcionarios.cadastrar(funcionario2);
			funcionarios.cadastrar(funcionario3);
			funcionarios.cadastrar(funcionario4);
			funcionarios.cadastrar(funcionario5);

		} catch (ProdutoJaCadastradoException e) {
			System.out.println(e.getMessage());
		} catch (PessoaJaCadastradaException e){
			System.out.println(e.getMessage());
		} 
		
		try {
			double result = livraria.venderProduto(livro1, cliente1, funcionario1);
			System.out.println(result);
			System.out.println(livro1.getEstoque());
		} catch (ProdutoNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoFaltandoNoEstoqueException e) {
			System.out.println(e.getMessage());
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}

	}

}
