package cadastro;

import spark.*;

public class Cadastro {
	public final Route novoCadastro = new NovoCadastro();
	
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
}
