package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class SalvaCadastro implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {

		Usuario usuario_logado = new Usuario();
		usuario_logado.setUsername(req.queryParams("user"));
		boolean setE = usuario_logado.setEmail(req.queryParams("email"));
		if (setE == false) {
			res.redirect("/erro_email.html");
			return null;
		}
		usuario_logado.setSenha(req.queryParams("password"));

		String matricula = req.queryParams("matricula");
		boolean TemChar = false;
		char[] chars = matricula.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] < 48 || chars[i] > 57) {
				TemChar = true;
				res.redirect("/erro_matricula2.html");
				return null;
			}
		}
		File file = new File("banco/cadastros/" + matricula + ".csv");
		if (file.exists()) {
			res.redirect("/erro_matricula.html");
			return null;
		} else {
			usuario_logado.setMatricula(req.queryParams("matricula"));
		}

		UsuarioDAO dao = new UsuarioDAO();	
		
		// && !findUser(usuario_logado.getUsername())
		
		
		try {
				if (!TemChar) 
					dao.save(usuario_logado);
		} catch (IOException e) {
			res.redirect("/index.html");
			e.printStackTrace();
		}

		req.session().attribute("usuario_logado", usuario_logado);

		res.redirect("/home");
		return null;
	}

	public static boolean findUser(String user) throws FileNotFoundException  {

		File file = new File("banco/cadastros/");
		File[] arqs = file.listFiles();

		Scanner scan;
		for (File arq : arqs) { // for each
			scan = new Scanner(arq);
			String linha = scan.nextLine();
			scan.close();
			String[] colunas = linha.split(";");
			System.out.println(colunas[1]);
			if (colunas[1].equals(user)) {
				return true;
			}
		}
		return false;
	}

}
