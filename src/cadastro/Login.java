package cadastro;

import spark.*;

public class Login {
	public final Route novoLogin = new NovoLogin();
	
	public class NovoLogin implements Route {
		public Object handle(Request req, Response res) throws Exception {
			String matricula = req.queryParams("matricula");
			String senha = req.queryParams("password");
			Usuario usuario_logado = new Usuario();
			if(usuario_logado.procuraCSV(matricula, senha) == false) {
				System.out.println("erro aqui");
				res.redirect("/erro_login.html"); return null;
			} 
			req.session().attribute("usuario_logado", usuario_logado);
			res.redirect("/home.html"); return null;
		}
	}

}	
