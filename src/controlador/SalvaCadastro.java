package controlador;

import java.io.IOException;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.*;

public class SalvaCadastro implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		
		Usuario usuario_logado = new Usuario();
		usuario_logado.setUsername(req.queryParams("user"));
		boolean setE = usuario_logado.setEmail(req.queryParams("email")); 
		if (setE == false) {
			res.redirect("/erro_email.html"); return null;
		}
		usuario_logado.setSenha(req.queryParams("password"));
		boolean setM = usuario_logado.setMatricula(req.queryParams("matricula"));
		if (setM == false) {
			res.redirect("/erro_matricula.html"); return null;
		}
		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.save(usuario_logado);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		req.session().attribute("usuario_logado", usuario_logado);
		
		res.redirect("/home.html"); return null;
	}

}
