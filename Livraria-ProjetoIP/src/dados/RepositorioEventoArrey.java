package dados;
import dados.RepositorioEvento;
import classesNegocio.Evento;
import exceptions.EventoExistenteException;
import exceptions.EventoNaoExisteException;

public class RepositorioEventoArrey implements RepositorioEvento{
	
	private Evento[] eventos;
	private int indice;
	
	public RepositorioEventoArrey(int tamanho){
		eventos = new Evento[tamanho];
		indice = 0;
	}
	public void inserir(Evento evento) throws EventoExistenteException{
		if(!this.existe(evento.getNome())){
			this.eventos[indice] = evento;
			this.indice++;	
		}else {
			throw new EventoExistenteException();
		}
	}

	public void remover(String nome) throws EventoNaoExisteException{
		if(this.existe(nome)){
			this.eventos[this.indice] = this.eventos[this.indice-1];
			this.indice = this.indice - 1;
		}else {
			 throw new EventoNaoExisteException();
		}
	}

	public void atualizar(Evento eventoNovo) throws EventoNaoExisteException{
		this.eventos[getIndice(eventoNovo.getNome())] = eventoNovo;
	}

	public Evento procurar(String nome) throws EventoNaoExisteException{
		return this.eventos[this.getIndice(nome)];
	
		
	}

	public boolean existe(String nome) {
		for(int i = 0;i <this.indice;i++){
			if(this.eventos[i].getNome().equals(nome)){
				return true;
			}
		}
		
		return false;
	}
	public int getIndice(String nome)	throws EventoNaoExisteException{
		for(int i = 0;i < this.indice;i++){
			if(this.eventos[i].getNome().equals(nome)){
				return i;
			}
		}
		throw new EventoNaoExisteException();
	}
	

}