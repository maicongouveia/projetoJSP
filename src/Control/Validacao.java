package Control;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Validacao {
	
	private Scanner entrada;
	private String usuario;
	private String senha;
	private String nome;
	private String permissao;
	private boolean resposta;
	
	public Validacao(String usuario, String senha){	
		
		this.nome = usuario;
		this.usuario = usuario;
		this.senha = senha;		
		
	}
	
	public void abrirArquivo() throws Exception {
		try{
			entrada = new Scanner(new File("src/BD/acessoLogin.txt"));
		} catch (FileNotFoundException exception) {
			System.out.println("Erro ao abrir o arquivo");
			exception.printStackTrace();
			System.exit(1);
		}
	}	
	
	public void fecharArquivo() {
		if (entrada != null) {
			entrada.close();
		}
	}
	
	public String[][] lerRegistro() throws Exception  {
		
		abrirArquivo();
		int cont = 0;
		while(entrada.hasNext()){
			cont++;
			entrada.next();
		}
		fecharArquivo();
		
		cont = cont/3;
		
		String vet[][] = new String[cont][3];
		abrirArquivo();
		for(int i = 0; i < cont; i++){
			vet[i][0] = entrada.next();
			vet[i][1] = entrada.next();
			vet[i][2] = entrada.next();
		}
		fecharArquivo();
		return vet;
	}
	
	public void buscaUsuario(String[][] vet) throws Exception{

		int inicio = 0;
		int fim    = vet.length - 1;
		int meio   = fim/2;
		
		while(fim>inicio){
			
			if(vet[meio][0].equals(usuario)){
				break;
			}
			else{
				if(vet[meio][0].compareTo(usuario) < 0){
					if(meio == inicio)meio++;
					inicio = meio;
					meio = (inicio+fim)/2;
				}
				if(vet[meio][0].compareTo(usuario) > 0){
					fim = meio;
					meio = fim/2;
				}
			}
		}

			if(vet[meio][0].equals(usuario)){
				
				CriptografiaMD5 c = new CriptografiaMD5();
				
				if(c.md5(senha).equals(vet[meio][1])){
					this.resposta = true;
					this.permissao = vet[meio][2];
				}
				else{//o certo é false
					this.resposta = false;	
				}
			}
			else{//o certo é false
				this.resposta = false;
			}
		
	}
	
	public boolean resposta(){
		return resposta;
	}
	
	public String nivelPermissao(){
		return permissao;
	}
	public String getNome(){
		return nome;
	}

}
