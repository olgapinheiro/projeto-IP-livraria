package dados;

import classesNegocio.Evento;
import exceptions.EventoExistenteException;
import exceptions.EventoNaoExisteException;

public interface RepositorioEventos {
	
	void inserir(Evento evento) throws EventoExistenteException;
	void remover (String nome) throws EventoNaoExisteException;
	void atualizar (Evento evento) throws EventoNaoExisteException;
	Evento procurar(String nome) throws EventoNaoExisteException;
    boolean existe(String nome);
}