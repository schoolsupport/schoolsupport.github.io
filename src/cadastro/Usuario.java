package cadastro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	
	private String senha;
	private String matricula;
	private String email;
	private String username;
	private Perfil perfil;
	
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
	public boolean setMatricula(String matricula) {
		this.matricula = matricula;
		return true;
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		if (validateEmail(email)) {
			this.email = email;
			return true;
		}
		return false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void toCSV() throws IOException {
		if (matricula != null && username != null && email != null && senha != null) {
			
			File dir = new File("Cadastros");
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
						
				File file = new File("Cadastros/" + matricula + ".csv");
				if(file.exists())return;	
				FileWriter writer = new FileWriter(file);
				
				writer.write(builder.toString());
				
				writer.flush();
				writer.close();
				
				addEmailToList();
				
		}
	}

	private void addEmailToList() throws IOException {
		
		File emails = new File("emails.csv");
		if ( ! emails.exists()) { 
			FileWriter e = new FileWriter("emails.csv"); 
			e.flush();
			e.close();
		}	
		
		Scanner scan = new Scanner(emails);
		
		ArrayList<String> lista = new ArrayList<String>();
		
		
		if (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] columns = line.split(";");
			for (int i = 0; i < columns.length; i++) {
			lista.add(columns[i]);
			}
		scan.close();		
		emails.delete();
		
		FileWriter emails2 = new FileWriter("emails.csv");
				
		StringBuilder builder2 = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			builder2.append(lista.get(i));
			
			builder2.append(";");
		}
				
		builder2.append(this.getEmail());
		builder2.append(";");
				
		emails2.write(builder2.toString());
		emails2.flush();
		emails2.close();
	
		}
		else  {
			FileWriter ems = new FileWriter("emails.csv");
			ems.append(email);
			ems.append(";");
			ems.flush();
			ems.close();
			
		}
		
	}
	private boolean validateEmail(String email) {
		
		File emails = new File("emails.csv");
		Scanner scan;
		try {
			scan = new Scanner(emails);
		} catch (FileNotFoundException e) {
			return true;
		}
		ArrayList<String> lista = new ArrayList<String>();
		
		if(scan.hasNextLine()) {
			String line = scan.nextLine();
			scan.close();
			String[] columns = line.split(";");
			for (int i = 0; i < columns.length; i++) {
				lista.add(columns[i]);
			}
		
			for (int i = 0; i < lista.size(); i++) {
				
				lista.get(i);
				
			if(lista.get(i).equals(email)) return false;
			}
		}

		return true;
		
	}
	public boolean procuraCSV(String matricula, String senha2) throws Exception{
		Usuario usuario_matricula = new Usuario();
		File arquivo = new File("Cadastros/" + matricula + ".csv");
		if ( ! arquivo.exists()) { 
			return false;
		}
		Scanner scan = new Scanner(arquivo);
		while(scan.hasNextLine()) {
			String row = scan.nextLine();
			usuario_matricula.fromCSV(row);
		}
		scan.close();
		usuario_matricula.verificaSenha(senha2);
		
		return true;
	}
	
	public void fromCSV(String row) {
		String[] columns = row.split(";");
		this.setMatricula(columns[0]);
		this.setUsername(columns[1]);
		this.setEmail(columns[2]);
		this.setSenha(columns[3]);
	}
	public boolean verificaSenha(String senha2) {
		if(senha2 == senha) {
			return true;
		}
		return false;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Perfil getPerfil() {
		return perfil;
	}
}
