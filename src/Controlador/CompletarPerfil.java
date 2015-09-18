package Controlador;

import java.io.IOException;
import cadastro.*;
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
		
		try {
			p.toCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.redirect("/home.html"); return null;
	}
}
