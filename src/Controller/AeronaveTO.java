package Controller;

public class AeronaveTO{

	private int codigo;
	private int fileira;
	private int coluna;
	private int quantidade;
	private int[][] localizarAcentos;
	private String nome;
	private String tipo;
	
	public AeronaveTO(int codigo, int fileira, int coluna, String nome,String tipo) {
		setCodigo(codigo);
		setFileira(fileira);
		setColuna(coluna);
		setNome(nome);
		setTipo(tipo);
		this.quantidade = fileira*coluna;
		this.localizarAcentos = new int[fileira][coluna];
	}
	
	public AeronaveTO(int codigo){
		setCodigo(codigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getFileira() {
		return fileira;
	}
	
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int[][] getLocalizarAcentos() {
		return localizarAcentos;
	}
	
	public void setLocalizarAcentos(int[][] localizarAcentos) {
		this.localizarAcentos = localizarAcentos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}