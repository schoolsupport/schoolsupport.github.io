package cadastro;

import spark.*;

public class Cadastro {
	public final Route novoCadastro = new NovoCadastro();
	public final TemplateViewRoute getCadastro = new GetCadastro();
	
	public class NovoCadastro implements Route {
		public Object handle(Request req, Response res) throws Exception {
			
			Usuario usuario_logado = new Usuario();
			usuario_logado.setUsername(req.queryParams("user"));
			boolean setE = usuario_logado.setEmail(req.queryParams("email")); 
			if (setE == false) {
				res.redirect("/erro_email.html"); return null;
			}
			usuario_logado.setSenha(req.queryParams("password"));
			boolean setM = usuario_logado.setMatricula(req.queryParams("matricula"));
			if (setM == false) {
				res.redirect("/erro_matricula.html"); return null;
			}
			usuario_logado.toCSV();
			
			req.session().attribute("usuario_logado", usuario_logado);
			res.redirect("/home.html"); return null;
		}
	}
	public class GetCadastro implements TemplateViewRoute {
		public ModelAndView handle(Request req, Response res) {
			Usuario usuario_logado = req.session().attribute("usuario_logado");
			return new ModelAndView(usuario_logado, "home.html");
		}
	}
}
