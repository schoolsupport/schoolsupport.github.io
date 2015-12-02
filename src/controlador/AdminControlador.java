package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class AdminControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/erro");
			return new ModelAndView("", "");
		}
		Perfil perfil = usuario.getPerfil();
		HashMap dados = new HashMap();
		dados.put("perfil", perfil);
		dados.put("usuario", usuario);
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "admin.html");
	}
}