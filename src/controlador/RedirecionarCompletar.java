package controlador;

import java.util.HashMap;
import cadastro.*;
import spark.*;

public class RedirecionarCompletar implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		dados.put("perfil", perfil);
		if(perfil == null) {
			return new ModelAndView(dados, "completar.html");
		} else {
			return new ModelAndView(dados, "home.html");
		}
	}

}
