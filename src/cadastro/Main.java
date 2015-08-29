package cadastro;

import java.io.*;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {
	public static void main(String[] args) throws IOException {
	
		Spark.staticFileLocation("/pub");
		
		Cadastro cadastro = new Cadastro();
		
		Route rota= cadastro.novoCadastro;
		
		Spark.post("/cadastro", rota);		
	
		//MustacheTemplateEngine engine = new MustacheTemplateEngine("pub");
		
		//TemplateViewRoute perfil = cadastro.getCadastro;
		
		//Spark.get("/home.html", perfil, engine);
	}
}
