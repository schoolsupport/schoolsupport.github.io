package cadastro;

import java.io.*;

import controlador.*;
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
		
		RedirecionarCompletar redirecionarCompletar = new RedirecionarCompletar();
		Spark.get("/completar_perfil", redirecionarCompletar, engine);
		
		PerfilControlador perfilControlador = new PerfilControlador();
		Spark.get("/home.html", perfilControlador, engine);
		
		AdminControlador admincontrolador = new AdminControlador();
		Spark.get("/admin.html", admincontrolador, engine);
				
		CompletarPerfil completarPerfil = new CompletarPerfil();
		Spark.post("/completar", completarPerfil, engine);
		
		ApagarPerfil apagarPerfil = new ApagarPerfil();
		Spark.get("/excluir", apagarPerfil, engine);
		
		Login login = new Login();
		Spark.post("/login", login, engine);
		
		CadastrarConteudo cadastrarConteudo = new CadastrarConteudo();
		Spark.post("/cadastrarconteudo", cadastrarConteudo, engine);
		
		MostrarConteudo mostrarConteudo = new MostrarConteudo();
		Spark.get("/mostrarconteudo", mostrarConteudo, engine);
		
		UsuariosCadastrados usuariosCadastrados = new UsuariosCadastrados();
		Spark.get("/usuarioscadastrados.html", usuariosCadastrados, engine);
				
	}
}
