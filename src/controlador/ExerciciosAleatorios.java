package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Exercicio;
import persistencia.ExercicioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExerciciosAleatorios implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response res) {
		ExercicioDAO dao = new ExercicioDAO();
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		String disciplina = req.params("disciplina");
		int bimestre = Integer.parseInt(req.params("bimestre"));
		exercicios = dao.findAllPorBimestre(disciplina, bimestre);
		Exercicio e = new Exercicio();
		e = exercicios.get(0);
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		dados.put("id", 0);
		int acertos = 0;
		req.session().attribute("acertos", acertos);
		req.session().attribute("exercicio", e);
		req.session().attribute("exercicios", exercicios);
		
		return new ModelAndView(dados, "exercicio_aleatorio.html");
		
	}

}
