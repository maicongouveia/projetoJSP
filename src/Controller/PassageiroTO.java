package Controller;

import Model.PassageiroDAO;

public class PassageiroTO {

		private int 	codigo;
		private String 	nome;
		private String 	sobrenome;
		private String  dataNascimento;
		private String 	formaTratamento;
		private int 	tipoPassageiro;
		private PassageiroDAO bd;
		
		public PassageiroTO(int codigo, String nome, String sobrenome,
				String dataNascimento, String formaTratamento,
				int tipoPassageiro) {
			
			setCodigo(codigo);
			setNome(nome);
			setSobrenome(sobrenome);
			setDataNascimento(dataNascimento);
			setFormaTratamento(formaTratamento);
			setTipoPassageiro(tipoPassageiro);
			bd = new PassageiroDAO();
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

}
