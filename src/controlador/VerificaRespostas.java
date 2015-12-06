package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Exercicio;
import modelo.Usuario;
import persistencia.ExercicioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class VerificaRespostas implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		
		Exercicio exercicio = req.session().attribute("exercicio");
		ExercicioDAO dao = new ExercicioDAO();
		Usuario user = req.session().attribute("usuario_logado");
		String resposta_usuario = req.queryParams("alternativa");
		;
		int id = req.session().attribute("id");
		id = (id+1);
		req.session().attribute("id", id);
		if(resposta_usuario.equals(exercicio.getAlternativaCorreta())) {
			
			if(!dao.exercicioFeito(user, exercicio.getCode())){
				dao.addAcerto(user, exercicio);
			}
			} else { 
			if(!dao.exercicioFeito(user, exercicio.getCode())){
				dao.addErro(user, exercicio);	
			}
			
		}
		
		ArrayList<Exercicio> exercicios = req.session().attribute("exercicios");
		if (id == exercicios.size()) res.redirect("/desempenho");
		Exercicio e = exercicios.get(id);
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		req.session().attribute("exercicio", e);
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "exercicio_conteudo.html");
	
	}

}
