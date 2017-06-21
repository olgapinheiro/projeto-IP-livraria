package dados;

import classesNegocio.Livro;
import exceptions.LivroJaCadastradoException;
import exceptions.LivroNaoEncontradoException;

public interface RepositorioLivros {
	Livro procurar(String codigo) throws LivroNaoEncontradoException;

	void inserir(Livro livro) throws LivroJaCadastradoException;

	boolean existe(String codigo);

	void atualizar(Livro livro, Livro livroAtualizado) throws LivroNaoEncontradoException;

	void remover(String codigo) throws LivroNaoEncontradoException;

}
