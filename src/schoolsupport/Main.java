package schoolsupport;

import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {
	public static void main(String[] args) {
				
		Spark.staticFileLocation("/pub");
		
		Cadastro cadastro = new Cadastro();
		
		Route rota= cadastro.novoCadastro;
		
		Spark.post("/cadastro", rota);
	}
}
