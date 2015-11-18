package controlador;

import persistencia.ExercicioDAO;
import modelo.Exercicio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class VerificaRespostas implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Exercicio exercicio = req.session().attribute("exercicio");
		ExercicioDAO dao = new ExercicioDAO();
		String resposta_usuario = req.queryParams("alternativa");
		String disciplina = exercicio.getDisciplina();
		int id = exercicio.getCode();
		String id_novo = (id+1)+"";
		
		if(resposta_usuario.equals(exercicio.getAlternativaCorreta())) {
			Exercicio proximo = dao.busca(id++, disciplina);
			req.session().attribute("exercicio", proximo);
			res.redirect("/exercicio/" + disciplina + "/" + id_novo);
		
		} else res.redirect("/");
		
		return null;
	}

}
