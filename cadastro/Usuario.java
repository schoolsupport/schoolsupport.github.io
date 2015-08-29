package cadastro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Usuario {
	
	private String senha;
	private String matricula;
	private String email;
	private String username;
	
	public Usuario() {
		
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String string) {
		this.matricula = string;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void toCSV() throws IOException {
		
		File dir = new File(matricula);
		if ( ! dir.exists()) { 
			dir.mkdir(); // make directory;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(matricula);
		builder.append(";");
		builder.append(username);
		builder.append(";");
		builder.append(email);
		builder.append(";");
		builder.append(senha);
		
		
		File file = new File(matricula + "/" + "dados_basicos" + ".csv");
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(builder.toString());
		
		writer.flush();
		writer.close();
		
		
	}
	
	
	
	
}
