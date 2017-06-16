package livro;

public  class Livro {
	private String codigo;
	private String nome;
	private double preco;
	private int estoque;
	private String genero;
	private String numeroEdicao;
	private int paginas;
	private String autor;
	private String editora;
	Livro(){
		this.codigo="";
		this.nome="";
		this.preco=0;
		this.estoque=0;
		this.genero="";
		this.numeroEdicao="";
		this.paginas=0;
		this.editora="";
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	public int getNumeroPaginas() {
		return this.paginas;
	}
	
	public String getNome() {
		return this.codigo;
	}

	
	public double getPreco() {
		return this.preco;
	}

	
	public int getEstoque() {
		return this.estoque;
	}

	
	public String getGenero() {
		return this.genero;
	}
	public String getAutor(){
		return this.autor;
	}
	public String getNumeroEdicao() {
		return this.numeroEdicao;
	}
	public String getEditora(){
		return this.editora;
	}
	public void setCodigo(String cod) {
		this.codigo=cod;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setEstoque(int est) {
		this.estoque=est;
	}
	public void setGenero(String gen) {
		this.genero=gen;
	}
	public void setNumeroEdicao(String numEd){
		this.numeroEdicao=numEd;
	}

	public void setPreco(double prec) {
		this.preco=prec;
	}
	
	public void setNumeroPaginas(int pag) {
		this.paginas=pag;
	}
	public void setAutor(String autor){
		this.autor=autor;
	}
	public void estocar(int est){
		this.estoque=this.estoque+est;
	}
	public void setEditora(String ed){
		this.editora=ed;
	}
}
