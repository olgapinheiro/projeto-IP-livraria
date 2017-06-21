package classesNegocio;
import classesNegocio.Evento;
import dados.RepositorioEventos;

public class EventoTeatro extends Evento{
	
	private double precoIngresso;
	private int quantidade;

	public EventoTeatro(String nome, String data, String horario, double custo,double precoIngresso,int quantidade) {
		super(nome, data, horario, custo);
		this.precoIngresso = precoIngresso;
		this.quantidade = quantidade;
		
	}

	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(double precoIngresso) {
		this.precoIngresso = precoIngresso;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

}