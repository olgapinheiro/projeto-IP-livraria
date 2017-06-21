package dados;

import classesNegocio.Pessoa;
import exceptions.PessoaJaCadastradaException;
import exceptions.PessoaNaoEncontradaException;

public interface RepositorioPessoas {
	public void inserir(Pessoa pessoa) throws PessoaJaCadastradaException;
	public void remover(String cpf) throws PessoaNaoEncontradaException;
	public void atualizar(Pessoa pessoa, Pessoa pessoaAtualizado) throws PessoaNaoEncontradaException;
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException;
	public boolean existe(String cpf);
}