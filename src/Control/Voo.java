package Control;

import java.sql.Time;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import BD.VooBD;

public class Voo {
	
	private DateFormat formato;
	private int codigo;
	private String origem;
	private String destino;
	private Date data ;
	private Time hora;
	private String status;
	private String valor;
	private int aero;
	private VooBD bd;
	
	
	public Voo(
			String origem, String destino, 
			Date data, Time hora, String status, String valor, int aero) {
		
		setOrigem(origem);
		setDestino(destino);
		setData(data);
		setHora(hora);
		setStatus(status);
		setValor(valor);
		setAero(aero);
		bd = new VooBD();	
	}
	
	public Voo(
			int codigo,String origem, String destino, 
			Date data, Time hora, String status, String valor, int aero) {
		
		setCodigo(codigo);
		setOrigem(origem);
		setDestino(destino);
		setData(data);
		setHora(hora);
		setStatus(status);
		setValor(valor);
		setAero(aero);
		
	}
	
	public Voo(int codigo){
		setCodigo(codigo);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public Date getData() {
		return data;
	}
	
	public String data(){
		formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(data);
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public String hora(){
		formato = new SimpleDateFormat("HH:mm");
		return formato.format(hora);
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setValor(String valor){		
		this.valor = valor;
	}
	
	public String getValor(){
		return valor;
	}
	
	public void setAero(int aero){
		this.aero = aero;
	}
	
	public int getAero(){
		return aero;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void incluir(){
		bd.cadastraVoo(this);
	}
	
	public void deletar(){
		bd.deletarAeronave(getCodigo());
	}

	public void alterar(Voo voo){
		bd.alterarVoo(voo);
	}
	
	public Voo pesquisar(int codigo){
		return bd.consultaVoo(codigo);
	}
	
}