package dados;

import classesNegocio.Evento;

public interface RepositorioEventos {

	void inserir(Evento evento);
	void remover(String nome);
	void atualizar(String nome);
	Evento procurar(String nome);
	boolean existe(String nome);
}