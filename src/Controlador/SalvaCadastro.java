package Controlador;

import java.io.IOException;
import cadastro.Usuario;
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
		try {
			usuario_logado.toCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		req.session().attribute("usuario_logado", usuario_logado);
		
		res.redirect("/completar.html"); return null;
	}

}
