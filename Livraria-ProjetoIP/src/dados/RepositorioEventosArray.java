package dados;

import dados.RepositorioEventos;
import classesNegocio.Evento;
import exceptions.EventoExistenteException;
import exceptions.EventoNaoExisteException;

public class RepositorioEventosArray implements RepositorioEventos {

	private Evento[] eventos;
	private int indice;

	public RepositorioEventosArray() {
		eventos = new Evento[100];
		indice = 0;
	}

	public void inserir(Evento evento) throws EventoExistenteException {
		if (!this.existe(evento.getNome())) {
			this.eventos[indice] = evento;
			if (this.indice >= this.eventos.length - 1) {
				Evento[] eventosNovo = new Evento[2 * this.eventos.length];
				for (int i = 0; i < this.eventos.length; i++) {
					eventosNovo[i] = this.eventos[i];
				}
				this.eventos = eventosNovo;
			}
			this.indice++;
		} else {
			throw new EventoExistenteException();
		}
	}

	public void remover(String nome) throws EventoNaoExisteException {
		if (this.existe(nome)) {
			this.eventos[this.indice] = this.eventos[this.indice - 1];
			this.indice = this.indice - 1;
		} else {
			throw new EventoNaoExisteException();
		}
	}

	public void atualizar(Evento eventoNovo) throws EventoNaoExisteException {
		this.eventos[getIndice(eventoNovo.getNome())] = eventoNovo;
	}

	public Evento procurar(String nome) throws EventoNaoExisteException {
		return this.eventos[this.getIndice(nome)];

	}

	public boolean existe(String nome) {
		for (int i = 0; i < this.indice; i++) {
			if (this.eventos[i].getNome().equals(nome)) {
				return true;
			}
		}

		return false;
	}

	public int getIndice(String nome) throws EventoNaoExisteException {
		for (int i = 0; i < this.indice; i++) {
			if (this.eventos[i].getNome().equals(nome)) {
				return i;
			}
		}
		throw new EventoNaoExisteException();
	}

}