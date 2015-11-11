package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modelo.Materia;

public class MateriaDAO {
	
	public void save (Materia m) {
		
		File materias = new File("banco/materias");
		if ( ! materias.exists()) { 
			materias.mkdir();
		}
		File disciplina = new File ("banco/materias/" + m.getDisciplina());
		if ( ! disciplina.exists()) { 
			disciplina.mkdir();
		}
		File conteudoMateria = new File("banco/materias/" + m.getDisciplina() + "/" + m.getTitulo() + ".csv");
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(m.getTitulo());
			builder.append(";");
			builder.append(m.getConteudo());
			
			FileWriter writer = new FileWriter(conteudoMateria);
			
			writer.write(builder.toString());
			writer.flush();
			writer.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}