package dados;

import classesNegocio.Encomenda;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaNaoEncontradaException;

public class RepositorioEncomendasArray implements RepositorioEncomendas {
	private Encomenda[] encomendas;
	private int tamanho;

	public RepositorioEncomendasArray() {
		encomendas = new Encomenda[100];
		tamanho = 0;
	}

	public void inserir(Encomenda encomenda) throws EncomendaJaCadastradaException {

		if (!this.existe(encomenda.getNumeroPedido())) {
			this.encomendas[tamanho] = encomenda;
			if (this.tamanho >= this.encomendas.length - 1) {
				Encomenda[] encomendasNovo = new Encomenda[2 * this.encomendas.length];
				for (int i = 0; i < encomendasNovo.length; i++) {
					encomendasNovo[i] = this.encomendas[i];
				}
				this.encomendas = encomendasNovo;
			}
			this.tamanho++;
		} else {
			throw new EncomendaJaCadastradaException();
		}
	}

	public void remover(String numeroPedido) throws EncomendaNaoEncontradaException {
		if (this.existe(numeroPedido)) {
			this.encomendas[this.getIndice(numeroPedido)] = this.encomendas[this.tamanho - 1];
			this.tamanho -= 1;
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public void atualizar(Encomenda encomenda, Encomenda encomendaAtualizado) throws EncomendaNaoEncontradaException {
		this.encomendas[getIndice(encomenda.getNumeroPedido())] = encomendaAtualizado;
	}

	public Encomenda procurar(String numeroPedido) throws EncomendaNaoEncontradaException {
		return this.encomendas[this.getIndice(numeroPedido)];
	}

	public boolean existe(String numeroPedido) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.encomendas[i].getNumeroPedido().equals(numeroPedido)) {
				return true;
			}
		}
		return false;
	}

	public int getIndice(String numeroPedido) throws EncomendaNaoEncontradaException {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.encomendas[i].getNumeroPedido().equals(numeroPedido)) {
				return i;
			}
		}
		throw new EncomendaNaoEncontradaException();
	}

	public Encomenda chamarProximo(String numeroPedido) throws EncomendaNaoEncontradaException {
		if (numeroPedido.equals("")) {
			return this.encomendas[0];
		} else {
			int posicaoEncomenda = this.getIndice(numeroPedido);
			if (posicaoEncomenda + 1 < this.tamanho) {
				return this.encomendas[posicaoEncomenda + 1];
			} else {
				return null;
			}
		}
	}

}
