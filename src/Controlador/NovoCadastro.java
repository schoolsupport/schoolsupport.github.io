package Controlador;

import spark.*;

public class NovoCadastro implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		
		return new ModelAndView(null, "index.html");
	}

}
