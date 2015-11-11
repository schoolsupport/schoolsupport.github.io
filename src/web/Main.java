package web;

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

		Spark.get("/home", perfilControlador, engine);
		
		Fisica2Controlador fisica2 = new Fisica2Controlador();
		Spark.get("/fisica2", fisica2, engine);
		Spark.get("/fisica2.html", fisica2, engine);
				
		CompletarPerfil completarPerfil = new CompletarPerfil();
		Spark.post("/completar", completarPerfil, engine);
		
		ApagarPerfil apagarPerfil = new ApagarPerfil();
		Spark.get("/excluir", apagarPerfil, engine);
		
		LoginControlador login = new LoginControlador();
		Spark.post("/login", login, engine);
		
		CadastrarConteudo cadastrarConteudo = new CadastrarConteudo();
		Spark.post("/cadastrarConteudo", cadastrarConteudo, engine);
		
		MostrarConteudo mostrarConteudo = new MostrarConteudo();
		Spark.get("/mostrarConteudo", mostrarConteudo, engine);
		
		UsuariosCadastrados usuariosCadastrados = new UsuariosCadastrados();
		Spark.get("/usuariosCadastrados.html", usuariosCadastrados, engine);
		
		CadastrarExercicio cadastrarExercicio = new CadastrarExercicio();
		Spark.post("/cadastrarExercicio", cadastrarExercicio, engine);
		
		Logout logout = new Logout();
		Spark.get("/logout", logout, engine);
		
		ExerciciosControlador exerciciosControlador = new ExerciciosControlador();
		Spark.get("/exercicio", exerciciosControlador, engine);
				
		VerificaRespostas verificaRespostas = new VerificaRespostas();
		Spark.post("/comp_ex", verificaRespostas, engine);
		
		ConteudosControlador conteudosControlador = new ConteudosControlador();
		Spark.get("/conteudo", conteudosControlador, engine);
	}
}
