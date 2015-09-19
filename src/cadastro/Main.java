package cadastro;

import java.io.*;

import Controlador.*;
import spark.*;
import spark.template.mustache.MustacheTemplateEngine;

public class Main {
	public static void main(String[] args) throws IOException {
	
		Spark.staticFileLocation("/pub");
		MustacheTemplateEngine engine = new MustacheTemplateEngine("pub");
		
		NovoCadastro novoCadastro = new NovoCadastro();
		Spark.get("/", novoCadastro, engine);	
		
		SalvaCadastro salvaCadastro = new SalvaCadastro();
		Spark.post("/cadastro", salvaCadastro, engine);
	
		PerfilControlador perfilControlador = new PerfilControlador();
		Spark.get("/home.html", perfilControlador, engine);
		
		RedirecionarCompletar redirecionarCompletar = new RedirecionarCompletar();
		Spark.get("/completar_perfil", redirecionarCompletar, engine);
		
		CompletarPerfil completarPerfil = new CompletarPerfil();
		Spark.post("/completar", completarPerfil, engine);
		
		ApagarPerfil apagarPerfil = new ApagarPerfil();
		Spark.get("/excluir", apagarPerfil, engine);
		
		Login login = new Login();
		Spark.post("/login", login, engine);
	}
}
