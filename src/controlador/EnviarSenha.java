package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EnviarSenha implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		
		String matricula = req.queryParams("matricula");
		String email = "";
		File dir = new File("banco/cadastros/" + matricula + ".csv");
		if(!dir.exists()){
			res.redirect("/erro/matricula");
		}
		Scanner scan;
		try {
			scan = new Scanner(dir);
			String row = scan.nextLine();
			String[] columns = row.split(";");
			email = columns[2];		
			//falta so enviar email
			//criar pagina de erro caso matricula nao exista
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		res.redirect("index.html");	
		
		
		
		
		
		
		
		
		
		return new ModelAndView("","index.html");
	}

}
