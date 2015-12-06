package controlador;

import spark.*;

public class NovoCadastro implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		return new ModelAndView("", "index.html");
	}
}