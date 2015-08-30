package cadastro;

import java.io.*;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {
	public static void main(String[] args) throws IOException {
	
		Spark.staticFileLocation("/pub");
		
		Cadastro cadastro = new Cadastro();
		
		Route rota_cad = cadastro.novoCadastro;
		
		Spark.post("/cadastro", rota_cad);	
		
		Login login = new Login();
		
		Route rota_log = login.novoLogin;
		
		Spark.post("/login", rota_log);		
	
		//MustacheTemplateEngine engine = new MustacheTemplateEngine("pub");
		
		//TemplateViewRoute perfil = cadastro.getCadastro;
		
		//Spark.get("/home.html", perfil, engine);
	}
}
