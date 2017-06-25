package classesNegocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Encomenda {
	private Produto produto;
	private boolean opcaoEntrega; // true -> entrega em casa; false -> entrega
									// na loja.
	private Endereco enderecoEntrega;
	private int prazoEntrega; // prazo de entrega em dias corridos
	private String dataPedido; // data em que o pedido foi realizado, no formado
								// "dd/mm/aaaa"
	private String statusEntrega; // "a caminho", "entregue" ou "cancelado"
	private double valorFrete;
	private String numeroPedido; // não será inicializado no construtor, e sim
									// no método "novaEncomenda" do
									// CadastroEncomendas

	public Encomenda(Produto produto, boolean opcaoEntrega, Endereco enderecoEntrega, String numeroPedido) {
		super();
		this.produto = produto;
		this.opcaoEntrega = opcaoEntrega;
		this.enderecoEntrega = enderecoEntrega;
		this.statusEntrega = "a caminho"; // no momento em que uma encomenda eh
											// criada, considera-se que o pedido
											// esta a caminho
		this.numeroPedido = numeroPedido;

		if (!enderecoEntrega.getPais().equals("Brasil")) {
			// entrega internacional (e' mais cara e custa mais)
			this.prazoEntrega = 30;
			this.valorFrete = 50;	
		} else if (!enderecoEntrega.getEstado().equals("Pernambuco")) {
			// entrega nacional, porem fora do estado de origem
			this.prazoEntrega = 15;
			this.valorFrete = 30;
		} else {
			// entrega no estado de origem (mais rapida e mais barata)
			this.prazoEntrega = 7;
			this.valorFrete = 15;
		}
		
		// se for buscar a encomenda na livraria, o frete e' gratis
		// (opcaoEntrega = false)
		if(!opcaoEntrega){
			valorFrete = 0;
		}

		// A data do pedido é a data do sistema no momento de criação de uma
		// nova encomenda:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAtual = LocalDate.now();
		this.dataPedido = dtf.format(dataAtual);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public boolean isOpcaoEntrega() {
		return opcaoEntrega;
	}

	public void setOpcaoEntrega(boolean opcaoEntrega) {
		this.opcaoEntrega = opcaoEntrega;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public int getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

}
