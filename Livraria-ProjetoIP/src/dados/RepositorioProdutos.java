package dados;

import classesNegocio.Produto;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public interface RepositorioProdutos {

	public void inserir(Produto produto) throws ProdutoJaCadastradoException;
	public void remover(String codigo) throws ProdutoNaoEncontradoException;
	public void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException;
	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException;
	public boolean existe(String codigo);
	public Produto chamarProximo(String codigo) throws ProdutoNaoEncontradoException;

	public int getIndice();




}
