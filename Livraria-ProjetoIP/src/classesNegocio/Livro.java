package classesNegocio;

public class Livro extends Produto {
	private String genero;
	private String numeroEdicao;
	private int paginas;
	private String autor;
	private String editora;

	public Livro(String nome, String autor, String Editora, double preco, String codigo,  int estoque) {
		super(codigo, preco, nome, estoque);
		this.autor = autor;
		
	}

	public String getGenero() {
		return this.genero;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getNumeroEdicao() {
		return this.numeroEdicao;
	}

	public String getEditora() {
		return this.editora;
	}

	public void setGenero(String gen) {
		this.genero = gen;
	}

	public void setNumeroEdicao(String numEd) {
		this.numeroEdicao = numEd;
	}

	public void setNumeroPaginas(int pag) {
		this.paginas = pag;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setEditora(String ed) {
		this.editora = ed;
	}
}
