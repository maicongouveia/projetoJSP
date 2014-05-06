package Control;

import BD.PassageiroBD;

public class Passageiro {

		private int 	codigo;
		private String 	nome;
		private String 	sobrenome;
		private String  dataNascimento;
		private String 	formaTratamento;
		private int 	tipoPassageiro;
		private PassageiroBD bd;
		
		public Passageiro(int codigo, String nome, String sobrenome,
				String dataNascimento, String formaTratamento,
				int tipoPassageiro) {
			
			setCodigo(codigo);
			setNome(nome);
			setSobrenome(sobrenome);
			setDataNascimento(dataNascimento);
			setFormaTratamento(formaTratamento);
			setTipoPassageiro(tipoPassageiro);
			bd = new PassageiroBD();
		}
		
		public void setCodigo(int codigo){
			this.codigo = codigo;
		}
		
		public int getCodigo(){
			return codigo;
		}

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getSobrenome() {
			return sobrenome;
		}
		
		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}
		
		public String getDataNascimento() {
			return dataNascimento;
		}
		
		public void setDataNascimento(String dateFormat) {
			this.dataNascimento = dateFormat;
		}
		
		public String getFormaTratamento() {
			return formaTratamento;
		}
		
		public void setFormaTratamento(String formaTratamento) {
			this.formaTratamento = formaTratamento;
		}
		
		public int getTipoPassageiro() {
			return tipoPassageiro;
		}
		
		public void setTipoPassageiro(int tipoPassageiro) {
			this.tipoPassageiro = tipoPassageiro;
		}
		
		public void incluir(){
			bd.cadastraPassageiro(this);
		}
		
		public void deletar(){
			bd.deletarPassageiro(getCodigo());
		}

		public void alterar(Passageiro passageiro){
			bd.alterarPassageiro(passageiro);
		}
		
		public Voo pesquisar(int codigo){
			return null;
//			return bd.consultaPassageiro(codigo);
		}
		
		

}
