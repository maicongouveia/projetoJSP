package Control;

import BD.AeronaveBD;

public class Aeronave{

	private int codigo;
	private int fileira;
	private int coluna;
	private int quantidade;
	private int[][] localizarAcentos;
	private String nome;
	private String tipo;
	private AeronaveBD bd;	
	
	public Aeronave(int codigo, int fileira, int coluna, String nome,String tipo) {
		setCodigo(codigo);
		setFileira(fileira);
		setColuna(coluna);
		setNome(nome);
		setTipo(tipo);
		this.quantidade = fileira*coluna;
		this.localizarAcentos = new int[fileira][coluna];
		bd = new AeronaveBD();
	}
	
	public Aeronave(int codigo){
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
	
	public void incluir(){
		bd.cadastraAeronave(this);
	}
	
	public void deletar(){
		bd.deletarAeronave(getCodigo());
	}

	public void alterar(Aeronave aero){
		bd.alterarAeronave(aero);
	}
	
	public Aeronave pesquisar(int codigo){
		return bd.consultaAeronave(codigo);
	}
	
	
}