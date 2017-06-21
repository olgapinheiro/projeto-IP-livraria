package classeNegocio;

public abstract class Evento {
	
	private String nome;
	private String data;
	private String horario;
	private double custo;
	

	public Evento (String nome,String data,String horario,double custo){
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.custo = custo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}


}