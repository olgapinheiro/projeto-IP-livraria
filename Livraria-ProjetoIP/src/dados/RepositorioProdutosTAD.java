package dados;

import classesNegocio.Produto;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutosTAD implements RepositorioProdutos {
	private Produto produto;
	private RepositorioProdutosTAD proximo;

	public RepositorioProdutosTAD() {
		this.produto = null;
		this.proximo = null;
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

	@Override
	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
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

	@Override
	public void inserir(Produto produto) throws ProdutoJaCadastradoException {
		// TODO Auto-generated method stub
		if (!this.existe(produto.getCodigo())) {
			if (this.proximo == null) {
				this.produto = produto;
				this.proximo = new RepositorioProdutosTAD();
			} else {
				this.proximo.inserir(produto);
			}
		} else {
			throw new ProdutoJaCadastradoException();

		}
	}

	@Override
	public boolean existe(String codigo) {
		// TODO Auto-generated method stub
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

	@Override
	public void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
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

	@Override
	public void remover(String codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		Produto produto = this.procurar(codigo);
		if(this.existe(codigo)){
			if(this.produto.equals(codigo)){
				this.produto = this.proximo.produto;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(codigo);
			}
		}else {
			throw new ProdutoNaoEncontradoException();
		}
		
	}

}
