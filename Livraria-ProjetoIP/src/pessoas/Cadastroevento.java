package eventos;
import dados.RepositorioEventos;

public class Cadastroevento {
	
	private RepositorioEventos eventos;
	
	public Cadastroevento(RepositorioEventos eventos){
		this.eventos = eventos;
		
	}
	public void cadastrar(Evento evento1) throws EventoExistenteException{
		
		if(!eventos.existe(evento1.getNome())){
			eventos.inserir(evento1);
			throw new EventoExistenteException();
		}
	}
	public void remover(String nome) throws EventoNaoExisteException{
		
		if(eventos.existe(nome)){
			eventos.remover(nome);
		}else {
			throw new EventoNaoExisteException();
		}
	}
	public void atualizar(String nome) throws EventoNaoExisteException{
		
		if(eventos.existe(nome)){
			eventos.atualizar(nome);
		}else {
			throw new EventoNaoExisteException();
		}
	}
	public Evento procurar(String nome) throws EventoNaoExisteException{
		if(eventos.existe(nome)){
			return eventos.procurar(nome);	
		}else {
			throw new EventoNaoExisteException();
		}
		
		
	}

		
}