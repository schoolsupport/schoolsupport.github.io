package controlador;

import java.util.Map;

import modelo.Perfil;
import modelo.Usuario;
import persistencia.PerfilDAO;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class BarraControlador {
	public static void handle(Request req, Response res, Map dados) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/erro/nulo");
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		Usuario user = usuarioDAO.load(usuario.getMatricula());
		Perfil perfil = perfilDAO.load(usuario);
		user.setPerfil(perfil);
		dados.put("usuario", user);
	}
}
