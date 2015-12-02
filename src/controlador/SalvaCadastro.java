package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SalvaCadastro implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {

		Usuario usuario_logado = new Usuario();
		boolean setU = usuario_logado.setUsername(req.queryParams("user"));
		if (setU == false) {
			res.redirect("/erro_username.html");
			return new ModelAndView("", "");
		}
		boolean setE = usuario_logado.setEmail(req.queryParams("email"));
		usuario_logado.setEmail(req.queryParams("email"));
		if (setE == false) {
			res.redirect("/erro_email.html");
			return new ModelAndView("", "");
		}
		usuario_logado.setSenha(req.queryParams("password"));

		String matricula = req.queryParams("matricula");
		boolean TemChar = false;
		char[] chars = matricula.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] < 48 || chars[i] > 57) {
				TemChar = true;
				res.redirect("/erro_matricula2.html");
				return new ModelAndView("", "");
			}
		}
		File file = new File("banco/cadastros/" + matricula + ".csv");
		if (file.exists()) {
			res.redirect("/erro_matricula.html");
			return new ModelAndView("", "");
		} else {
			usuario_logado.setMatricula(req.queryParams("matricula"));
		}

		UsuarioDAO dao = new UsuarioDAO();			
		
		try {
				if (!TemChar) 
					dao.save(usuario_logado);
		} catch (IOException e) {
			res.redirect("/index.html");
			e.printStackTrace();
		}

		req.session().attribute("usuario_logado", usuario_logado);
		
		if(usuario_logado.getMatricula().equals("11030231") ||
		   usuario_logado.getMatricula().equals("11030234") || 
		   usuario_logado.getMatricula().equals("11030235")) {
			res.redirect("/admin");
		}else{
			res.redirect("/home");
		}

		return null;
	}
}
