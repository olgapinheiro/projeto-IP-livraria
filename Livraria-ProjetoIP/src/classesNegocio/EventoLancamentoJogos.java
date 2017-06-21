package classesNegocio;

public class EventoLancamentoJogos extends Evento {

	private String NomeJogo;
	private String TipoJogo;
	private String Plataforma;

	public EventoLancamentoJogos(String nome, String data, String horario, double custo, String NomeJogo,
			String TipoJogo, String Plataforma) {
		super(nome, data, horario, custo);
		this.NomeJogo = NomeJogo;
		this.TipoJogo = TipoJogo;
		this.Plataforma = Plataforma;
	}

	public String getNomeJogo() {
		return NomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		NomeJogo = nomeJogo;
	}

	public String getTipoJogo() {
		return TipoJogo;
	}

	public void setTipoJogo(String tipoJogo) {
		TipoJogo = tipoJogo;
	}

	public String getPlataforma() {
		return Plataforma;
	}

	public void setPlataforma(String plataforma) {
		Plataforma = plataforma;
	}

}
