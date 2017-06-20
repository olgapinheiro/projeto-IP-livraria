package classesNegocio;

import dados.RepositorioEncomendas;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaJaCanceladaException;
import exceptions.EncomendaNaoEncontradaException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;;

public class CadastroEncomendas {
	private static final TemporalUnit DAYS = null;
	private RepositorioEncomendas encomendas;

	public CadastroEncomendas(RepositorioEncomendas encomendas) {
		this.encomendas = encomendas;
	}

	public void novaEncomenda(Encomenda encomenda) throws EncomendaJaCadastradaException {
		if (encomendas.existe(encomenda)) {
			throw new EncomendaJaCadastradaException();
		} else {
			encomendas.inserir(encomenda);
		}
	}

	public void entregarEncomenda(Encomenda encomenda) throws EncomendaNaoEncontradaException {
		if (encomendas.existe(encomenda)) {
			encomenda.setStatusEntrega("entregue");
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public void cancelarEncomenda(Encomenda encomenda) throws EncomendaNaoEncontradaException, EncomendaJaCanceladaException {
		if (encomendas.existe(encomenda) && !encomenda.getStatusEntrega().equals("cancelada")) {
			encomenda.setStatusEntrega("cancelada");
			encomenda.setPrazoEntrega(-1);
		} else if(encomenda.getStatusEntrega().equals("cancelada")){
			throw new EncomendaJaCanceladaException();
		}else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public String prazoRestante(Encomenda encomenda) throws EncomendaNaoEncontradaException {
		// datas
		long diasPassados;
		long  diasRestantes;
		String data;
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataPedido;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if (encomendas.existe(encomenda)) {
			
			data = encomenda.getDataPedido();
			dataPedido = LocalDate.parse(data, dtf);
					
			// Cálculo dos dias que faltam para completar o prazo:
			
			if (dataPedido.isBefore(dataAtual) && !encomenda.getStatusEntrega().equals("cancelada")) {
				diasPassados = dataPedido.until(dataAtual, DAYS);
				diasRestantes = encomenda.getPrazoEntrega()-diasPassados;
				encomenda.setStatusEntrega("a caminho");
				return "Encomenda será entregue em " + diasRestantes + " dias";
			} else if(!encomenda.getStatusEntrega().equals("cancelada")){
				encomenda.setStatusEntrega("entregue");
				return "Encomenda já entregue";
			} else{
				return "Encomenda cancelada";
			}
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}
}
