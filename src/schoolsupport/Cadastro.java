package schoolsupport;

import spark.*;
import java.io.*;
import java.util.*;

public class Cadastro {
	public final Route novoCadastro = new NovoCadastro();
	private ArrayList<Usuario> usuario_cadastrado = new ArrayList<Usuario>(); // = new Usuario(user2s[0]);
	
	public class NovoCadastro implements Route {
		public Object handle(Request req, Response res) throws Exception {
			System.out.println(req.queryParams("user"));
			String user = req.queryParams("user");
			String email = req.queryParams("email");
			String senha = req.queryParams("pass1");
			File alunos = new File("usuarios.csv");	
			FileWriter writer = new FileWriter(alunos, true);
			
			Usuario usuario_logado = new Usuario(email, user, senha);
			usuario_cadastrado.add(usuario_logado);
			
			writer.append(usuario_logado.toCSV() + "\n");
			writer.flush();
			writer.close();
			
			req.session().attribute("usuario_logado", usuario_logado);
			res.redirect("/home.html"); return null;
		}
	}
}
