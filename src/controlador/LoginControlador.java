package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.*;

public class LoginControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		String matricula = req.queryParams("matricula2");
		String senha = req.queryParams("password2");
		File file = new File("banco/cadastros/" + matricula + ".csv");
		if (!file.exists()) {
			res.redirect("/erro/login");
			return new ModelAndView("", "");
		}
		Usuario user = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		user = dao.load(matricula);
		if (user == null)
			res.redirect("/erro/login");
		if (user.getSenha().equals(senha)) {
			req.session().attribute("usuario_logado", user);
			if (user.getMatricula().equals("11030231")
					|| user.getMatricula().equals("11030234")
					|| user.getMatricula().equals("11030235")) {
				res.redirect("/admin");
			} else {
				res.redirect("/home");
			}
		} else {
			res.redirect("/erro/senha");
		}
		return new ModelAndView("", "");
	}
}