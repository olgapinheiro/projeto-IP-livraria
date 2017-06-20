package exceptions;

public class LivroJaCadastradoException extends Exception {
	public LivroJaCadastradoException(){
		super("Livro Ja cadastrado");
	}
}
