package controlador;

import cadastro.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class Fisica2Controlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("index.html");
			return null;
		}
		return new ModelAndView(null, "fisica2.html");
	}

}
