package dados;
import classeNegocio.Evento;
import exceptions.EventoNaoExisteException;
import exceptions.EventoExistenteException;

public class RepositorioEventoTAD implements RepositorioEvento{
	
	private Evento evento; 
	private RepositorioEventoTAD proximo;
	
	public RepositorioEventoTAD(){
		this.evento = null;
		this.proximo = null;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public RepositorioEventoTAD getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioEventoTAD proximo) {
		this.proximo = proximo;
	}

	@Override
	public void inserir(Evento evento) throws EventoExistenteException {
		if(!this.existe(evento.getNome())){
			if(this.proximo == null){
				this.evento = evento;
				this.proximo = new RepositorioEventoTAD();
			}else {
				this.proximo.inserir(evento);
			}
		}else {
				throw new EventoExistenteException();
			}
		}
		

	public void remover(String nome) throws EventoNaoExisteException {
		Evento evento = this.procurar(nome);
		if(this.existe(nome)){
			if(this.evento.equals(nome)){
				this.evento = this.proximo.evento;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(nome);
			}
		}else {
			throw new EventoNaoExisteException();
		}
		
	}

	public void atualizar(Evento novo) throws EventoNaoExisteException{
		if(this.existe(evento.getNome())){
			if(this.evento.equals(evento.getNome())){
				this.evento = novo;
			}else {
				this.proximo.atualizar(novo);
			}
		}else {
			throw new EventoNaoExisteException();
		}
		
	}

	
	public Evento procurar(String nome) throws EventoNaoExisteException {
		if(this.existe(nome)){
			if(this.evento.getNome().equals(nome)){
				return this.evento;
			}else {
				return this.proximo.procurar(nome);
			}
		}else {
			throw new EventoNaoExisteException();
		}
		
	}

	
	public boolean existe(String nome) {
		boolean encontrou = false;
		if(this.evento != null){
			if(this.evento.getNome().equals(nome)){
				encontrou = true;
			}else {
				this.proximo.existe(nome);
			}
		}
		return encontrou;


	}

}
