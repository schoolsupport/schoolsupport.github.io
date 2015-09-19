package Controlador;

import cadastro.*;
import spark.*;

public class RedirecionarCompletar implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil perfil = usuario.getPerfil();
		if(perfil == null) {
			return new ModelAndView(null, "completar.html");
		} else {
			res.redirect("home.html");
			return null;
		}
	}

}
