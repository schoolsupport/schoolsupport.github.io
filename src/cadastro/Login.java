package cadastro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import spark.*;

public class Login implements TemplateViewRoute{
		public ModelAndView handle(Request req, Response res){	
			String matricula = req.queryParams("matricula2");
			String senha = req.queryParams("password2");
			File file = new File("Cadastros/" + matricula + ".csv");
				if(! file.exists()){
					res.redirect("/erro_login.html");
					return null;
				}
			Scanner scan;
			Usuario user = new Usuario();
			try {
				scan = new Scanner(file);	
				while(scan.hasNextLine()){
					String row = scan.nextLine();
					user.fromCSV(row);
				}
				if (user.getSenha().equals(senha)){
					req.session().attribute("usuario_logado", user);
					res.redirect("/home.html");
				}	
			 else {
					res.redirect("/index.html");
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res.redirect("/erro_login.html");
			return null;
		}
}
