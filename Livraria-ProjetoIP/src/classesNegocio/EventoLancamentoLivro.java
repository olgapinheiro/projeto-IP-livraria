package classesNegocio;

import classesNegocio.Evento;
import dados.RepositorioEvento;

public class EventoLancamentoLivro extends Evento {

	private String NomeLivro;
	private String NomeAutor;

	public EventoLancamentoLivro(String nome, String data, String horario, double custo, String NomeLivro,
			String NomeAutor) {
		super(nome, data, horario, custo);
		this.NomeLivro = NomeLivro;
		this.NomeAutor = NomeAutor;
	}

	public String getNomeLivro() {
		return NomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		NomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return NomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		NomeAutor = nomeAutor;
	}

}
