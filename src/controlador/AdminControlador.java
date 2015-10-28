package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class AdminControlador implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		dados.put("perfil", perfil);
		dados.put("usuario", usuario);
		return new ModelAndView(dados, "admin.html");
	}

}
