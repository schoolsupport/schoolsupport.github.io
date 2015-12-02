package controlador;

import java.util.HashMap;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ApresentaCadastrarE implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/erro/nulo");
			return new ModelAndView("", "");
		}
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "/cadastrar_exercicio.html");
	}

}
