package exceptions;

public class EncomendaJaCanceladaException extends Exception {
	
	public EncomendaJaCanceladaException(){
		super("Encomenda ja foi cancelada");
	}
}
