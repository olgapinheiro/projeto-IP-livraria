package exceptions;

public class EventoNaoExisteException extends Exception{
	
	public EventoNaoExisteException(){
		super("EVENTO NAO EXISTE");
	}

}