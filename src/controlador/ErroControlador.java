package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ErroControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		return new ModelAndView("", "erro.html");
	}

}
