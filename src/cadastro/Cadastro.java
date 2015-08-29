package cadastro;

import spark.*;

public class Cadastro {
	public final Route novoCadastro = new NovoCadastro();
	public final TemplateViewRoute getCadastro = new GetCadastro();
	
	public class NovoCadastro implements Route {
		public Object handle(Request req, Response res) throws Exception {
			String user = req.queryParams("user");
			String email = req.queryParams("email");
			String senha = req.queryParams("password");
			String matricula = req.queryParams("password");
			
			Usuario usuario_logado = new Usuario(user, matricula, email, senha);
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
