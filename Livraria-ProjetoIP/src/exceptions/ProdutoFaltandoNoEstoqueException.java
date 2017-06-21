package exceptions;

public class ProdutoFaltandoNoEstoqueException extends Exception {
	public ProdutoFaltandoNoEstoqueException(){
		super("Produto faltando no estoque");
	}
}
