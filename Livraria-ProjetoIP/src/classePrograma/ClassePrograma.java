package classePrograma;

import classeFachada.Livraria;
import classesNegocio.CadastroEventos;
import classesNegocio.CadastroPessoas;
import classesNegocio.CadastroProdutos;
import classesNegocio.Cliente;
import classesNegocio.Funcionario;
import classesNegocio.Livro;
import classesNegocio.Produto;
import dados.RepositorioEventos;
import dados.RepositorioEventosArray;
import dados.RepositorioPessoas;
import dados.RepositorioPessoasArray;
import dados.RepositorioPessoasTAD;
import dados.RepositorioProdutos;
import dados.RepositorioProdutosArray;
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
		RepositorioProdutos repLivrosArray = new RepositorioProdutosArray();
		RepositorioProdutos repJogosArray = new RepositorioProdutosArray();
		Scanner in = new Scanner(System.in);

		String teste = in.nextLine(); // aqui será usado o arquivo config.txt

		Livro produto = new Livro("Livro Legal", "Autor Incrivel", "EDITOR4", 50.0, "123", 5);
		Cliente cliente = new Cliente("Jose", "4561234568");
		Funcionario funcionario = new Funcionario("Joana", "456823147");

		if (teste.equalsIgnoreCase("Array")) {
			CadastroPessoas clientes = new CadastroPessoas(repClientesArray);
			CadastroPessoas funcionarios = new CadastroPessoas(repFuncionariosArray);
			CadastroEventos eventos = new CadastroEventos(repEventosArray);
			CadastroProdutos livros = new CadastroProdutos(repLivrosArray);
			CadastroProdutos jogos = new CadastroProdutos(repJogosArray);
			Livraria livraria = new Livraria(clientes, funcionarios, eventos, livros, jogos);

			livros.cadastrar(produto);
			clientes.cadastrar(cliente);
			funcionarios.cadastrar(funcionario);
			try {
				double result = livraria.venderProduto(produto, cliente, funcionario);
				System.out.println(result);
				System.out.println(produto.getEstoque());
			} catch (ProdutoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} catch (ProdutoFaltandoNoEstoqueException e) {
				System.out.println(e.getMessage());
			} catch (PessoaNaoEncontradaException e){
				System.out.println(e.getMessage());
			}

		}

	}

}
