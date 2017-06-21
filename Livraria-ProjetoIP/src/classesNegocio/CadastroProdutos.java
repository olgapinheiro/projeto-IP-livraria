package classesNegocio;
import dados.RepositorioProdutos;
import exceptions.ProdutoJaCadastradoException;
import exceptions.ProdutoNaoEncontradoException;
public class CadastroProdutos {
	private RepositorioProdutos produtos;
	public CadastroProdutos(RepositorioProdutos produtos){
		this.produtos=produtos;
	}
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException{
		if(!produtos.existe(produto.getCodigo())){
			produtos.inserir(produto);
		}else{
			throw new ProdutoJaCadastradoException();
		}
	}
	public void remover(String codigo) throws ProdutoNaoEncontradoException{
		produtos.remover(codigo);
	}
	public void atualizar(Produto produto,Produto produtoAtualizado) throws ProdutoNaoEncontradoException{
		if(produtos.existe(produto.getCodigo())){
			produtos.atualizar(produto, produtoAtualizado);
		}else{
			throw new ProdutoNaoEncontradoException();
		}
	}
	public Produto procurar(String codigo) throws ProdutoNaoEncontradoException{
		if(produtos.existe(codigo)){
			return produtos.procurar(codigo);
		}else{
			throw new ProdutoNaoEncontradoException();
		}
	}
}
