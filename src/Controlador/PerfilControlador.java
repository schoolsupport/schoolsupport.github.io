package Controlador;

import java.util.HashMap;

import cadastro.*;
import spark.*;

public class PerfilControlador implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		dados.put("usuario", usuario);
		dados.put("perfil", perfil);
		return new ModelAndView(dados, "home.html");
	}
}
