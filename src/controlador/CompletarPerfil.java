package controlador;

import java.io.IOException;

import modelo.Perfil;
import modelo.Usuario;
import persistencia.PerfilDAO;
import spark.*;


public class CompletarPerfil implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		Perfil p = new Perfil();
		usuario.setPerfil(p);
		p.setUsuario(usuario);
		p.setNome(req.queryParams("name"));
		p.setSobrenome(req.queryParams("sobrenome"));
		p.setCurso(req.queryParams("curso"));
		p.setTurma(req.queryParams("ano"));
		p.setBio(req.queryParams("bio"));
		PerfilDAO dao = new PerfilDAO();
		try {
			dao.save(p);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (usuario.getMatricula().equals("11030235") || usuario.getMatricula().equals("11030234") || usuario.getMatricula().equals("11030231") ) res.redirect("/admin");
		res.redirect("/home"); return null;
	}
	
	
}
