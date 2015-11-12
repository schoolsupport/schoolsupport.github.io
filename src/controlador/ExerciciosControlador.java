package controlador;

import java.util.HashMap;

import modelo.Exercicio;
import persistencia.ExercicioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExerciciosControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response resp) {
		Exercicio e = new Exercicio();
		ExercicioDAO dao = new ExercicioDAO();
		String disciplina = req.params("disciplina");
		e = dao.busca(Integer.parseInt(req.params("id")), disciplina);
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		req.session().attribute("exercicio", e);
		return new ModelAndView(dados, "exercicio_conteudo.html");
	}

}
