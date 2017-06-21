package classesNegocio;

public class Jogo extends Produto {
	private String plataforma;
	private String genero;

	public Jogo(String codigo, double preco, String nome, int estoque) {
		super(codigo, preco, nome, estoque);
	}

	public String getGenero() {
		return this.genero;
	}

	public String getPlataforma() {
		return this.plataforma;
	}

	public void setGenero(String gen) {
		this.genero = gen;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}
