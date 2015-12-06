package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EsqueceuSenha implements TemplateViewRoute{
	@Override
	public ModelAndView handle(Request req, Response res) {
		return new ModelAndView("","esqueceu_senha.html");
	}

}
