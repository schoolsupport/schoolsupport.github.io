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
		
		HomeControlador homeControlador = new HomeControlador();
		Spark.get("/home.html", homeControlador, engine);
		Spark.get("/home", homeControlador, engine);
		
		AdminControlador admincontrolador = new AdminControlador();
		Spark.get("/admin", admincontrolador, engine);

		Fisica2Controlador fisica2 = new Fisica2Controlador();
		Spark.get("/fisica2", fisica2, engine);
		
		DesempenhoControlador desempenhoControlador = new DesempenhoControlador();
		Spark.get("/desempenho", desempenhoControlador, engine);
				
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
		Spark.get("/usuariosCadastrados", usuariosCadastrados, engine);
	
		ApresentaCadastrarE apresentaCadastrarE = new ApresentaCadastrarE(); 
		Spark.get("/cadastraExercicio", apresentaCadastrarE, engine);
		
		CadastrarExercicio cadastrarExercicio = new CadastrarExercicio();
		Spark.post("/cadastrarExercicio", cadastrarExercicio, engine);
		
		Logout logout = new Logout();
		Spark.get("/logout", logout, engine);
		
		ExerciciosControlador exerciciosControlador = new ExerciciosControlador();
		Spark.get("/exercicio/:disciplina/:id", exerciciosControlador, engine);
				
		VerificaRespostas verificaRespostas = new VerificaRespostas();
		Spark.post("/comp_ex", verificaRespostas, engine);
		
		ConteudosControlador conteudosControlador = new ConteudosControlador();
		Spark.get("/conteudo/:disciplina/:id", conteudosControlador, engine);
		
		RedirecionaConteudos redirecionaConteudos = new RedirecionaConteudos(); 
		Spark.get("/conteudos", redirecionaConteudos, engine);
		
		RedirecionaExercicios redirecionaExercicios = new RedirecionaExercicios();
		Spark.get("/exercicios", redirecionaExercicios, engine);
		
		ExerciciosAleatorios exerciciosAleatorios = new ExerciciosAleatorios();
		Spark.get("/exercicioaleatorio/:disciplina/:bimestre", exerciciosAleatorios, engine);
		
		ProximoAleatorio proximoAleatorio = new ProximoAleatorio();
		Spark.post("/nextRandom/:id", proximoAleatorio, engine);
		
		EndRandomExercises endRandomExercises = new EndRandomExercises();
		Spark.get("/endRandomExercises", endRandomExercises, engine);
		
		
		// Comentado pois est� sendo testado ainda
		//EmailControlador emailControlador = new EmailControlador()
		//Spark.post("/sendmail", emailControlador, engine);
		
	

	}
}
