package eventos;

public class Evento {
	
	private String nome;
	private String data;
	private String horario;
	
	
	public Evento (String nome,String data,String horario,double preco){
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		
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


}