package dados;

import classesNegocio.Encomenda;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaNaoEncontradaException;

public class RepositorioEncomendasArray implements RepositorioEncomendas {
	private Encomenda[] encomendas;
	private int indice;

	public RepositorioEncomendasArray() {
		encomendas = new Encomenda[100];
		indice = 0;
	}

	public void inserir(Encomenda encomenda) throws EncomendaJaCadastradaException {
		
		if (!this.existe(encomenda.getNumeroPedido())) {
			this.encomendas[indice] = encomenda;
			if(this.indice >= this.encomendas.length-1){
				Encomenda[] encomendasNovo = new Encomenda[2*this.encomendas.length];
				for(int i =0; i<encomendasNovo.length; i++){
					encomendasNovo[i] = this.encomendas[i];
				}
				this.encomendas = encomendasNovo;
			}
			this.indice++;
		} else {
			throw new EncomendaJaCadastradaException();
		}
	}

	public void remover(String numeroPedido) throws EncomendaNaoEncontradaException {
		if (this.existe(numeroPedido)) {
			this.encomendas[this.getIndice(numeroPedido)] = this.encomendas[this.indice-1];
			this.indice -= 1;			
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public void atualizar(Encomenda encomenda, Encomenda encomendaAtualizado) throws EncomendaNaoEncontradaException{
		this.encomendas[getIndice(encomenda.getNumeroPedido())] = encomendaAtualizado;
	}

	public Encomenda procurar(String numeroPedido) throws EncomendaNaoEncontradaException {
		return this.encomendas[this.getIndice(numeroPedido)];
	}

	public boolean existe(String numeroPedido) {
		for (int i = 0; i < this.indice; i++) {
			if (this.encomendas[i].getNumeroPedido().equals(numeroPedido)) {
				return true;
			}
		}
		return false;
	}

	public int getIndice(String numeroPedido) throws EncomendaNaoEncontradaException {
		for (int i = 0; i < this.indice; i++) {
			if (this.encomendas[i].getNumeroPedido().equals(numeroPedido)) {
				return i;
			}
		}
		throw new EncomendaNaoEncontradaException();
	}


}
