package controlador;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class Logout implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario u = null;
		req.session().attribute("usuario_logado", u);
		res.redirect("index.html");

		return null;
	}

}
