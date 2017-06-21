package dados;

import eventos.Evento;
import eventos.EventoExistenteException;
import eventos.EventoNaoExisteException;

public interface RepositorioEvento {
	
	void inserir(Evento evento) throws EventoExistenteException;
	void remover (String nome) throws EventoNaoExisteException;
	void atualizar (String nome);
	Evento procurar(String nome) throws EventoNaoExisteException;
    boolean existe(String nome);
}
