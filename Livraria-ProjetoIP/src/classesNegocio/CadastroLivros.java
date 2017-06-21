package classesNegocio;
import dados.RepositorioLivros;
import exceptions.LivroJaCadastradoException;
import exceptions.LivroNaoEncontradoException;
public class CadastroLivros {
	private RepositorioLivros livros;
	public CadastroLivros(RepositorioLivros livros){
		this.livros=livros;
	}
	public void cadastrar(Livro livro) throws LivroJaCadastradoException{
		if(!livros.existe(livro.getCodigo())){
			livros.inserir(livro);
		}else{
			throw new LivroJaCadastradoException();
		}
	}
	public void remover(String codigo) throws LivroNaoEncontradoException{
		livros.remover(codigo);
	}
	public void atualizar(Livro livro,Livro livroAtualizado) throws LivroNaoEncontradoException{
		if(livros.existe(livro.getCodigo())){
			livros.atualizar(livro, livroAtualizado);
		}else{
			throw new LivroNaoEncontradoException();
		}
	}
	public Livro procurar(String codigo) throws LivroNaoEncontradoException{
		if(livros.existe(codigo)){
			return livros.procurar(codigo);
		}else{
			throw new LivroNaoEncontradoException();
		}
	}
}
