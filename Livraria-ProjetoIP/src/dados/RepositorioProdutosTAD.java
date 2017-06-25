package dados;

import classesNegocio.Produto;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutosTAD implements RepositorioProdutos {
	private Produto produto;
	private RepositorioProdutosTAD proximo;
	private int indice;

	public RepositorioProdutosTAD() {
		this.produto = null;
		this.proximo = null;
		this.indice = 0;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public RepositorioProdutosTAD getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioProdutosTAD proximo) {
		this.proximo = proximo;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException {
		if(this.existe(codigo)){
			if (this.produto.getCodigo().equals(codigo)) {
				return this.produto;
			} else {
				return this.proximo.procurar(codigo);
			}
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public void inserir(Produto produto) throws ProdutoJaCadastradoException {
		if (!this.existe(produto.getCodigo())) {
			if (this.proximo == null) {
				this.produto = produto;
				this.proximo = new RepositorioProdutosTAD();
				this.indice++;
			} else {
				this.proximo.inserir(produto);
			}
		} else {
			throw new ProdutoJaCadastradoException();

		}
	}

	public boolean existe(String codigo) {
		boolean achou = false;
		if (this.produto != null) {
			if (this.produto.getCodigo().equals(codigo)) {
				achou = true;
			} else {
				this.proximo.existe(codigo);
			}
		}
		return achou;
		
	}

	public void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException {
		if(this.existe(produto.getCodigo())){
			if(this.produto.equals(produto)){
				this.produto = produtoAtualizado;
			}else {
				this.proximo.atualizar(produto,produtoAtualizado);
			}
		}else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public void remover(String codigo) throws ProdutoNaoEncontradoException {
		if(this.existe(codigo)){
			if(this.produto.equals(codigo)){
				this.produto = this.proximo.produto;
				this.proximo = this.proximo.proximo;
				this.indice--;
			}else {
				this.proximo.remover(codigo);
			}
		}else {
			throw new ProdutoNaoEncontradoException();
		}
		
	}
	
	public Produto chamarProximo(String codigo) throws ProdutoNaoEncontradoException{
		if (codigo.equals("")) {
			return this.produto;
		} else {
			if (this.proximo.produto == null) {
				return null;
			} else if (this.produto.getCodigo().equals(codigo)) {
				return this.proximo.produto;
			} else {
				return this.proximo.chamarProximo(produto.getCodigo());
			}
		}
	}

}
