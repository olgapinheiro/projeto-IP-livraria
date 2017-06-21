package dados;

import classesNegocio.Livro;
import dados.RepositorioLivros;
import exceptions.LivroJaCadastradoException;
import exceptions.LivroNaoEncontradoException;

public class RepositorioLivrosArray implements RepositorioLivros {
	private Livro[] livros;
	private int indice;
	
	public void RepositorioContasArray(int tamanho){
		livros=new Livro[tamanho];
		indice=0;
	}

	@Override
	public void inserir(Livro livro) throws LivroJaCadastradoException {
		// TODO Auto-generated method stub
		if(!this.existe(livro.getCodigo())){
			this.livros[indice]=livro;
			this.indice++;
		}else{
			throw new LivroJaCadastradoException();
		}
	}

	@Override
	public boolean existe(String codigo) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.indice;i++){
			if(this.livros[i].getCodigo().equals(codigo)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void remover(String codigo) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		if (this.existe(codigo)){
			this.livros[this.getIndice(codigo)]=this.livros[this.indice-1];
			this.indice-=1;
		}else{
			throw new LivroNaoEncontradoException();
			
		}
	}
	@Override
	public Livro procurar(String codigo) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		return  this.livros[this.getIndice(codigo)];
	}
	
	@Override
	public void atualizar(Livro livro, Livro livroAtualizado) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		this.livros[getIndice(livro.getCodigo())]=livroAtualizado;
	}
	public int getIndice(String codigo) throws LivroNaoEncontradoException{
			for(int i=0;i<this.indice;i++){
				if(this.livros[i].getCodigo().equals(codigo)){
					return i;
				}
			}
			throw new LivroNaoEncontradoException();
	}

}
