package controlador;

import java.util.HashMap;

import modelo.Perfil;
import modelo.Usuario;
import persistencia.PerfilDAO;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class PerfilControlador implements TemplateViewRoute {

	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/");
			return null;
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		
		Usuario user = usuarioDAO.load(usuario.getMatricula());
		Perfil perfil = perfilDAO.load(user);
		
		
		HashMap dados = new HashMap();
		dados.put("usuario", user);
		dados.put("perfil", perfil);
		return new ModelAndView(dados, "home.html");
	}
}
