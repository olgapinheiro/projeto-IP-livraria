package dados;

import classesNegocio.Produto;
import dados.RepositorioProdutos;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;

public class RepositorioProdutosArray implements RepositorioProdutos {
	private Produto[] produtos;
	private int indice;
	
	public RepositorioProdutosArray(int tamanho){
		produtos=new Produto[tamanho];
		indice=0;
	}

	@Override
	public void inserir(Produto produto) throws ProdutoJaCadastradoException {
		// TODO Auto-generated method stub
		if(!this.existe(produto.getCodigo())){
			this.produtos[indice]=produto;
			this.indice++;
		}else{
			throw new ProdutoJaCadastradoException();
		}
	}

	@Override
	public boolean existe(String codigo) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.indice;i++){
			if(this.produtos[i].getCodigo().equals(codigo)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void remover(String codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		if (this.existe(codigo)){
			this.produtos[this.getIndice(codigo)]=this.produtos[this.indice-1];
			this.indice-=1;
		}else{
			throw new ProdutoNaoEncontradoException();
			
		}
	}
	@Override
	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		return  this.produtos[this.getIndice(codigo)];
	}
	
	@Override
	public void atualizar(Produto produto, Produto produtoAtualizado) throws ProdutoNaoEncontradoException {
		// TODO Auto-generated method stub
		this.produtos[getIndice(produto.getCodigo())]=produtoAtualizado;
	}
	public int getIndice(String codigo) throws ProdutoNaoEncontradoException{
			for(int i=0;i<this.indice;i++){
				if(this.produtos[i].getCodigo().equals(codigo)){
					return i;
				}
			}
			throw new ProdutoNaoEncontradoException();
	}

}
