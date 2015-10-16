package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CadastrarConteudo implements TemplateViewRoute{
	public ModelAndView handle(Request req, Response res) {
		
		String materia = req.queryParams("disciplina");
		String titulo = req.queryParams("titulo");
		String conteudo = req.queryParams("conteudo");
		
		File materias = new File("Materias");
		if ( ! materias.exists()) { 
			materias.mkdir();
		}
		File disciplina = new File ("Materias/" + materia);
		if ( ! disciplina.exists()) { 
			disciplina.mkdir();
		}
		File conteudoMateria = new File("Materias/" + materia + "/" + titulo + ".csv");
		
		File arquivo = new File("conteudo" + "-" + titulo + ".html");
		File padrao = new File("src/pub/conteudo_teste.txt");
		
		try {
			
			StringBuilder builder = new StringBuilder();
			builder.append(titulo);
			builder.append(";");
			builder.append(conteudo);
			
			FileWriter writer = new FileWriter(conteudoMateria);
			
			writer.write(builder.toString());
			writer.flush();
			writer.close();	
			String line = "";
			Scanner scan = new Scanner(padrao);
			if (scan.hasNextLine()) {
				line = scan.nextLine();
			}
			scan.close();
			FileWriter writer2 = new FileWriter(arquivo);
			writer2.write(line);
			writer2.flush();
			writer2.close();	
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		res.redirect("/conteudo_teste.html");
		return null;
	}

}
