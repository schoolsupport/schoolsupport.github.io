package controlador;

import java.util.HashMap;

import modelo.Exercicio;
import persistencia.ExercicioDAO;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExerciciosControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response resp) {
		Exercicio e = new Exercicio();
		ExercicioDAO dao = new ExercicioDAO();
		e = dao.busca(2);
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		req.session().attribute("exercicio", e);
		return new ModelAndView(dados, "exercicios.html");
	}

}
