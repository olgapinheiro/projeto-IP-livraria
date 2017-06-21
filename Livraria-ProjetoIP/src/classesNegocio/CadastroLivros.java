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
			livros.inserir1(livro);
		}else{
			throw new LivroJaCadastradoException();
		}
	}
	public void remover(String codigo) throws LivroNaoEncontradoException{
		livros.remover(codigo);
	}
	public void atualizar(Livro livro,Livro livroAtualizado) throws LivroNaoEncontradoException{
		if(livros.existe(livro.getCodigo())){
			livros.atualizar1(livro, livroAtualizado);
		}else{
			throw new LivroNaoEncontradoException();
		}
	}
	public Livro procurar(String codigo) throws LivroNaoEncontradoException{
		if(livros.existe(codigo)){
			return livros.procurar1(codigo);
		}else{
			throw new LivroNaoEncontradoException();
		}
	}
}
