package exceptions;

public class EventoExistenteException extends Exception{
	
	public EventoExistenteException(){
		super ("EVENTO JA CADASTRADO");
	}

}