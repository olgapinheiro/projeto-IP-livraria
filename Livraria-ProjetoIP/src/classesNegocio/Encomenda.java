package classesNegocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Encomenda {
	private Livro livro;
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

	public Encomenda(Livro livro, boolean opcaoEntrega, Endereco enderecoEntrega, int prazoEntrega, double valorFrete) {
		super();
		this.livro = livro;
		this.opcaoEntrega = opcaoEntrega;
		this.enderecoEntrega = enderecoEntrega;
		this.statusEntrega = "a caminho"; // no momento em que uma encomenda eh
											// criada, considera-se que o pedido
											// esta a caminho
		this.valorFrete = valorFrete;

		if (!enderecoEntrega.getPais().equals("Brasil")) {
			this.prazoEntrega = 30;
		} else if (!enderecoEntrega.getEstado().equals("Pernambuco")) {
			this.prazoEntrega = 15;
		} else {
			this.prazoEntrega = 7;
		}

		// A data do pedido é a data do sistema no momento de criação de uma
		// nova encomenda:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAtual = LocalDate.now();
		this.dataPedido = dtf.format(dataAtual);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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
