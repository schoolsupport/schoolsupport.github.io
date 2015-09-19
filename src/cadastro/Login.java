package cadastro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

public class Login implements TemplateViewRoute{
		public ModelAndView handle(Request req, Response res){
			
			String matricula = req.queryParams("matricula2");
			String senha = req.queryParams("password2");
			
			//Usuario usuarioLogado = req.session().attribute("usuario_logado");
			File file = new File("Cadastros/" + matricula + ".csv");
				if(! file.exists()){
					res.redirect("/erro_login.html");
					return null;
				}
			Scanner scan;
			Usuario a = new Usuario();
			try {
				scan = new Scanner(file);
				
				while(scan.hasNextLine()){
					String row = scan.nextLine();
					a.fromCSV(row);
				}
				if (a.getSenha().equals(senha)){
					req.session().attribute("usuario_logado", a);
					res.redirect("/home.html");
				}	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res.redirect("/erro_login.html");
			return null;
			
		}
}	
