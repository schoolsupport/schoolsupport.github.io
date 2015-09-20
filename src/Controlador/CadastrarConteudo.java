package Controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CadastrarConteudo implements TemplateViewRoute{

	@Override
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
		
//		if(conteudoMateria.exists()){
//			res.redirect("/erro_nteudoCadastrado.html");
//		}	
		try {
			FileWriter writer = new FileWriter(conteudoMateria);
			writer.write(conteudo);
			writer.flush();
			writer.close();	
			res.redirect("/home.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
