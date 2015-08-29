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
	public boolean setEmail(String email) {
		if (validateEmail()) {
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
				
		emails.delete();
		
		FileWriter emails2 = new FileWriter("emails.csv");
				
		StringBuilder builder2 = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			builder2.append(lista.get(i));
			System.out.println(lista.get(i));
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
	
	private boolean validateEmail() {
		
		File emails = new File("emails.csv");
		Scanner scan;
		try {
			scan = new Scanner(emails);
		} catch (FileNotFoundException e) {
			System.out.println("olá");
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
				System.out.println("oizinho");
				lista.get(i);
				
				if(lista.get(i).equals(this.email)) return false;
			}
		}

		return true;
		
	}
	
}
