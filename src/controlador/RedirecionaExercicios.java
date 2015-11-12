package controlador;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class RedirecionaExercicios implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/");
			return null;
		}
		return new ModelAndView(null, "/pagina_exercicios.html");
	}

}
