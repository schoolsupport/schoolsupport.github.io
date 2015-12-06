package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class Logout implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		req.session().attribute("usuario_logado", null);
		res.redirect("/");
		return new ModelAndView("", "");
	}
}