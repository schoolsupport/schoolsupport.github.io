package controlador;

import java.util.HashMap;

import persistencia.PerfilDAO;
import persistencia.UsuarioDAO;
import modelo.Perfil;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class BarraControlador implements TemplateViewRoute {
	@Override
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		if(usuario == null) {
			res.redirect("/");
			return null;
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PerfilDAO perfilDAO = new PerfilDAO();
		
		String matricula = usuario.getMatricula();
		//Usuario user = usuarioDAO.load(matricula);
		System.out.println("teste");
		System.out.println(usuario.getMatricula());
		Perfil perfil = perfilDAO.load(usuario);
		
		System.out.println(perfil.getNome());
		
		HashMap dados = new HashMap();
		//dados.put("usuario", user);
		dados.put("perfil", perfil);
		return new ModelAndView(dados, "barraUser.html");
	}
}
