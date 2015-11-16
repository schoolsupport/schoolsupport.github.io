package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Exercicio;
import persistencia.ExercicioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ProximoAleatorio implements TemplateViewRoute {
	
	public ModelAndView handle(Request req, Response res) {
		Exercicio exercicio = req.session().attribute("exercicio");
		String resposta_usuario = req.queryParams("alternativa");
		if(resposta_usuario.equals(exercicio.getAlternativaCorreta())) {
			int acertos = Integer.parseInt(req.session().attribute("acertos")) + 1;
			req.session().attribute("acertos", acertos);
		}
		
		ArrayList<Exercicio> exercicios = req.session().attribute("exercicios");
		Exercicio e = new Exercicio();
		int id = Integer.parseInt(req.params("id")) + 1;
		
		if (id > exercicios.size()-1) res.redirect("/endRandomExercises");
		e = exercicios.get(id);
		
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		dados.put("id", id);
		
		req.session().attribute("exercicio", e);
		
		return new ModelAndView(dados, "exercicio_aleatorio.html");
		
		
		
	    
		
		
	}

}
