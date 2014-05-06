package Control;

import java.text.DateFormat;

import BD.PassageiroBD;
import BD.PassagemBD;

public class Passagem {
	
	private int codigo;
	private int idPassageiro;
	private int idVoo;
	private int idAcento;
	private DateFormat data;
	private DateFormat hora;
	private PassagemBD bd;
	
	
	public Passagem(int codigo, int idPassageiro, int idVoo, int idAcento,
			DateFormat data, DateFormat hora) {
		
		this.codigo = codigo;
		this.idPassageiro = idPassageiro;
		this.idVoo = idVoo;
		this.idAcento = idAcento;
		this.data = data;
		this.hora = hora;
		bd = new PassagemBD();
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setId(int id) {
		this.codigo = id;
	}
	
	public int getIdPassageiro() {
		return idPassageiro;
	}
	
	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	
	public int getIdVoo() {
		return idVoo;
	}
	
	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}
	
	public int getIdAcento() {
		return idAcento;
	}
	
	public void setIdAcento(int idAcento) {
		this.idAcento = idAcento;
	}
	
	public DateFormat getData() {
		return data;
	}
	
	public void setData(DateFormat data) {
		this.data = data;
	}
	
	public DateFormat getHora() {
		return hora;
	}
	
	public void setHora(DateFormat hora) {
		this.hora = hora;
	}	
	
	public void incluir(){
		bd.incluir(this);
	}
	
	public void deletar(){
		bd.deletar(getCodigo());
	}

	public void alterar(Passagem passagem){
		bd.alterar(passagem);
	}
	
	public Passagem pesquisar(int codigo){
		return null;
//		return bd.pesquisar(codigo);
	}
	
	
}
