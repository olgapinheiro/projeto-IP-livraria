package dados;

import classesNegocio.Encomenda;
import exceptions.EncomendaJaCadastradaException;
import exceptions.EncomendaNaoEncontradaException;

public interface RepositorioEncomendas {
	public void inserir(Encomenda encomenda) throws EncomendaJaCadastradaException;
	public void atualizar(Encomenda encomenda, Encomenda encomendaAtualizada) throws EncomendaNaoEncontradaException;
	public void remover(String numeroPedido) throws EncomendaNaoEncontradaException;
	public Encomenda procurar(String numeroPedido) throws EncomendaNaoEncontradaException;
	public boolean existe(String numeroPedido);
	public Encomenda chamarProximo(String numeroPedido) throws EncomendaNaoEncontradaException;
}
