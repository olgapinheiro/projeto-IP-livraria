package dados;

import classesNegocio.Produto;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public interface RepositorioProdutos {
	Produto procurar(String codigo) throws ProdutoNaoEncontradoException;

	void inserir(Produto produto) throws ProdutoJaCadastradoException;

	boolean existe(String codigo);

	void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException;

	void remover(String codigo) throws ProdutoNaoEncontradoException;

}
