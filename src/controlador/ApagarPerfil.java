package controlador;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.io.*;

import modelo.Usuario;

public class ApagarPerfil implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario2 = req.session().attribute("usuario_logado");
		if (usuario2 == null) {
			res.redirect("/erro/nulo");
			return new ModelAndView("", "");
		}
		Usuario usuario = req.session().attribute("usuario_logado");
		File perfis = new File("banco/perfis/" + usuario.getMatricula()
				+ ".csv");
		File cadastros = new File("banco/cadastros/" + usuario.getMatricula()
				+ ".csv");

		if (perfis.exists()) {
			perfis.delete();

		}
		if (cadastros.exists()) {
			cadastros.delete();
		}
		res.redirect("/");
		return new ModelAndView("", "");
	}
}
