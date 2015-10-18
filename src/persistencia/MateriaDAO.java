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
		
//		File arquivo = new File("conteudo" + "-" + m.getTitulo() + ".html"); e por que isso??
//		File padrao = new File("src/pub/conteudo_teste.txt"); ?????????
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(m.getTitulo());
			builder.append(";");
			builder.append(m.getConteudo());
			
			FileWriter writer = new FileWriter(conteudoMateria);
			
			writer.write(builder.toString());
			writer.flush();
			writer.close();	
//			String line = "";
//			Scanner scan = new Scanner(padrao);
//			if (scan.hasNextLine()) {
//				line = scan.nextLine();
//			}
//			scan.close();
//			FileWriter writer2 = new FileWriter(arquivo);
//			writer2.write(line);
//			writer2.flush();
//			writer2.close();	
// Por que isso??		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
