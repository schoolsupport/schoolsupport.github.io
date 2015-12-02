package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import spark.*;

public class HomeControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "home.html");
	}
}
