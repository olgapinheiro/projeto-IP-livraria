package classesNegocio;

public class Jogo extends Produto {
	private String plataforma;
	private String genero;

	public Jogo(String nome, String plataforma, double preco, String codigo,  int estoque) {
		super(codigo, preco, nome, estoque);
		this.plataforma = plataforma;
	}

	public String getGenero() {
		return this.genero;
	}

	public String getPlataforma() {
		return this.plataforma;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
}
