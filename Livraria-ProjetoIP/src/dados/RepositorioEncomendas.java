package dados;

import classesNegocio.Encomenda;

public interface RepositorioEncomendas {
	public void inserir(Encomenda encomenda);
	public void atualizar(Encomenda encomenda);
	public void remover(Encomenda encomenda);
	public Encomenda procurar(String numeroPedido);
	public boolean existe(Encomenda encomenda);
}
