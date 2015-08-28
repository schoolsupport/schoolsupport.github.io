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
	
	public Usuario(String email, String matricula, String username, String senha) {
		this.email = email;
		this.username = username;
		this.senha = senha;
		this.matricula = matricula;
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
		
		File dir = new File("Cadastros");
		if ( ! dir.exists() ) { 
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
		
		
		File file = new File("Cadastros/" + matricula + ".csv");
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(builder.toString());
		writer.flush();
		writer.close();
			
	}
}
