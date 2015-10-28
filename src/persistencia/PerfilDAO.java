package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Perfil;

public class PerfilDAO {
	
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
}
