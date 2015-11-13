package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modelo.Perfil;
import modelo.Usuario;

public class PerfilDAO {
	private Perfil perfil = new Perfil();
	public void save(Perfil p) throws IOException {
		
		File dir = new File("banco/perfis");
		if ( ! dir.exists()) { 
			dir.mkdir(); 
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(p.getNome());
		builder.append(";");
		builder.append(p.getSobrenome());
		builder.append(";");
		builder.append(p.getTurma());
		builder.append(";");
		builder.append(p.getCurso());
		builder.append(";");
		builder.append(p.getBio());
		
		
		File file = new File("banco/perfis/" + p.getUsuario().getMatricula() + ".csv");
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(builder.toString());
		
		writer.flush();
		writer.close();
	}
	
	public Perfil load(Usuario user){
		File arquivo = new File("banco/perfis/" + user.getMatricula() + ".csv");
		if ( ! arquivo.exists()) { 
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				perfil.setNome(columns[0]);
				perfil.setSobrenome(columns[1]);
				perfil.setTurma(columns[2]);
				perfil.setCurso(columns[3]);
				perfil.setBio(null);
				if(columns.length == 5){
						perfil.setBio(columns[4]);
				}
			}
			scan.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return perfil;
	}
}
