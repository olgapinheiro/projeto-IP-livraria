package exceptions;

public class ProdutoNaoEncontradoException extends Exception{
	public ProdutoNaoEncontradoException() {
		super("Produto nao encontrado");
	}
}
