package dados;

import classesNegocio.Produto;
import dados.RepositorioProdutos;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] produtos;
	private int indice;

	public RepositorioProdutosArray() {
		produtos = new Produto[100];
		indice = 0;
	}

	public void inserir(Produto produto) throws ProdutoJaCadastradoException {
		if (!this.existe(produto.getCodigo())) {
			this.produtos[indice] = produto;
			if (this.indice >= this.produtos.length - 1) {
				Produto[] produtosNovo = new Produto[2 * this.produtos.length];
				for (int i = 0; i < produtosNovo.length; i++) {
					produtosNovo[i] = this.produtos[i];
				}
			}
			this.indice++;
		} else {
			throw new ProdutoJaCadastradoException();
		}
	}

	public boolean existe(String codigo) {
		for (int i = 0; i < this.indice; i++) {
			if (this.produtos[i].getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}

	public void remover(String codigo) throws ProdutoNaoEncontradoException {
		if (this.existe(codigo)) {
			this.produtos[this.getIndice(codigo)] = this.produtos[this.indice - 1];
			this.indice -= 1;
		} else {
			throw new ProdutoNaoEncontradoException();

		}
	}

	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException {
		return this.produtos[this.getIndice(codigo)];
	}

	public void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException {
		this.produtos[getIndice(produto.getCodigo())] = produtoAtualizado;
	}

	public int getIndice(String codigo) throws ProdutoNaoEncontradoException {
		for (int i = 0; i < this.indice; i++) {
			if (this.produtos[i].getCodigo().equals(codigo)) {
				return i;
			}
		}
		throw new ProdutoNaoEncontradoException();
	}

	public int getIndice() {
		return this.indice;
	}

}
