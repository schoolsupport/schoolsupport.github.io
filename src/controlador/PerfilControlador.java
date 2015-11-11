package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import spark.*;
import web.*;

public class PerfilControlador implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/");
			return null;
		}
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		dados.put("perfil", perfil);
		dados.put("usuario", usuario);
		return new ModelAndView(dados, "home.html");
	}
}
