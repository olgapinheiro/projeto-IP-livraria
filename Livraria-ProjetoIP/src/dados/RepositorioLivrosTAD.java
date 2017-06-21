package dados;

import classesNegocio.Livro;
import exceptions.LivroJaCadastradoException;
import exceptions.LivroNaoEncontradoException;

public class RepositorioLivrosTAD implements RepositorioLivros {
	private Livro livro;
	private RepositorioLivrosTAD proximo;

	public RepositorioLivrosTAD() {
		this.livro = null;
		this.proximo = null;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public RepositorioLivrosTAD getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioLivrosTAD proximo) {
		this.proximo = proximo;
	}

	@Override
	public Livro procurar(String codigo) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		if(this.existe(codigo)){
			if (this.livro.getCodigo().equals(codigo)) {
				return this.livro;
			} else {
				return this.proximo.procurar(codigo);
			}
		} else {
			throw new LivroNaoEncontradoException();
		}
	}

	@Override
	public void inserir(Livro livro) throws LivroJaCadastradoException {
		// TODO Auto-generated method stub
		if (!this.existe(livro.getCodigo())) {
			if (this.proximo == null) {
				this.livro = livro;
				this.proximo = new RepositorioLivrosTAD();
			} else {
				this.proximo.inserir(livro);
			}
		} else {
			throw new LivroJaCadastradoException();

		}
	}

	@Override
	public boolean existe(String codigo) {
		// TODO Auto-generated method stub
		boolean achou = false;
		if (this.livro != null) {
			if (this.livro.getCodigo().equals(codigo)) {
				achou = true;
			} else {
				this.proximo.existe(codigo);
			}
		}
		return achou;
		
	}

	@Override
	public void atualizar(Livro livro, Livro livroAtualizado) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		if(this.existe(livro.getCodigo())){
			if(this.livro.equals(livro)){
				this.livro = livroAtualizado;
			}else {
				this.proximo.atualizar(livro,livroAtualizado);
			}
		}else {
			throw new LivroNaoEncontradoException();
		}
	}

	@Override
	public void remover(String codigo) throws LivroNaoEncontradoException {
		// TODO Auto-generated method stub
		Livro livro = this.procurar(codigo);
		if(this.existe(codigo)){
			if(this.livro.equals(codigo)){
				this.livro = this.proximo.livro;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(codigo);
			}
		}else {
			throw new LivroNaoEncontradoException();
		}
		
	}

}
