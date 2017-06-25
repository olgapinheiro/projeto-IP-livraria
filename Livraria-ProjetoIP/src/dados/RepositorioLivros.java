package dados;

import classesNegocio.Livro;

public interface RepositorioLivros {
	Livro procurar(String codigo);
	void inserir(Livro livro);
	void remover(Livro livro);
	void atualizar(Livro livro);
	boolean existe (Livro livro);
}
