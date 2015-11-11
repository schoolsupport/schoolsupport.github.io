package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.*;

public class LoginControlador implements TemplateViewRoute{
		
	public ModelAndView handle(Request req, Response res){	
			String matricula = req.queryParams("matricula2");
			String senha = req.queryParams("password2");
			File file = new File("banco/cadastros/" + matricula + ".csv");
				if(! file.exists()){
					res.redirect("/erro_login.html");
					return null;
			}
			boolean TemChar = false; 
			char[] chars = matricula.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if(chars[i] < 48 || chars[i] > 57) {
					TemChar = true;
					res.redirect("/erro_matricula2.html"); return null;
				}
			}	
				
			Scanner scan;
			Usuario user = new Usuario();
			UsuarioDAO dao = new UsuarioDAO();
			user = dao.load(matricula);
			
			if (user == null) res.redirect("/erro_login.html");
			if (!TemChar) {	
			if (user.getSenha().equals(senha)){
				req.session().attribute("usuario_logado", user);
				if(user.getMatricula().equals("11030231") || user.getMatricula().equals("11030234") || user.getMatricula().equals("11030235")){
					res.redirect("/admin");
				}
				res.redirect("/home");
			} else {
				res.redirect("/");
			}
			}
			
			res.redirect("/erro_login.html");
			return null;
		}
}
