package dados;

import classesNegocio.Encomenda;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaNaoEncontradaException;

public class RepositorioEncomendasTAD implements RepositorioEncomendas {
	private Encomenda encomenda;
	private RepositorioEncomendasTAD proximo;

	public RepositorioEncomendasTAD() {
		this.encomenda = null;
		this.proximo = null;
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public RepositorioEncomendasTAD getProximo() {
		return proximo;
	}

	public void setProximo(RepositorioEncomendasTAD proximo) {
		this.proximo = proximo;
	}

	public void inserir(Encomenda encomenda) throws EncomendaJaCadastradaException {
		if (!this.existe(encomenda.getNumeroPedido())) {
			if (this.proximo == null) {
				this.encomenda = encomenda;
				this.proximo = new RepositorioEncomendasTAD();
			} else {
				this.proximo.inserir(encomenda);
			}
		} else {
			throw new EncomendaJaCadastradaException();
		}
	}

	public void remover(String numeroPedido) throws EncomendaNaoEncontradaException {
		Encomenda encomenda = this.procurar(numeroPedido);
		//if (this.existe(encomenda.getNumeroPedido())) {
			if (this.encomenda.equals(encomenda)) {
				this.encomenda = this.proximo.encomenda;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(numeroPedido);
			}
		/*} else {
			throw new EncomendaNaoEncontradaException();
		}*/
	}

	
	public void atualizar(Encomenda encomenda, Encomenda encomendaAtualizada) throws EncomendaNaoEncontradaException {
		if (this.existe(encomenda.getNumeroPedido())) {
			if (this.encomenda.equals(encomenda)) {
				this.encomenda = encomendaAtualizada;
			} else {
				this.proximo.atualizar(encomenda, encomendaAtualizada);
			}
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public Encomenda procurar(String numeroPedido) throws EncomendaNaoEncontradaException {
		if (this.existe(numeroPedido)) {
			if (this.encomenda.getNumeroPedido().equals(numeroPedido)) {
				return this.encomenda;
			} else {
				return this.proximo.procurar(numeroPedido);
			}
		} else {
			throw new EncomendaNaoEncontradaException();
		}
	}

	public boolean existe(String numeroPedido) {
		boolean achou = false;
		if (this.encomenda != null) {
			if (this.encomenda.getNumeroPedido().equals(numeroPedido)) {
				achou = true;
			} else {
				this.proximo.existe(numeroPedido);
			}
		}
		return achou;
	}

	public Encomenda chamarProximo(String numeroPedido) {
		if (numeroPedido.equals("")) {
			return this.encomenda;
		} else {
			if (this.proximo.encomenda == null) {
				return null;
			} else if (this.encomenda.getNumeroPedido().equals(numeroPedido)) {
				return this.proximo.encomenda;
			} else {
				return this.proximo.chamarProximo(encomenda.getNumeroPedido());
			}
		}
	}



}
