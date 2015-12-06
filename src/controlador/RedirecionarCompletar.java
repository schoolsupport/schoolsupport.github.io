package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import spark.*;
import web.*;

public class RedirecionarCompletar implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		if(perfil == null) {
			return new ModelAndView(dados, "completar.html");
		} else {
			return new ModelAndView(dados, "home.html");
		}
	}
}