package controlador;

import persistencia.ExercicioDAO;
import modelo.Exercicio;
import modelo.Usuario;
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
		String disciplina = exercicio.getDisciplina();
		int id = exercicio.getCode();
		String id_novo = (id+1)+"";
		
		if(resposta_usuario.equals(exercicio.getAlternativaCorreta())) {
			Exercicio proximo = dao.busca(id++, disciplina);
			req.session().attribute("exercicio", proximo);
			if(!dao.exercicioFeito(user, id)){
				dao.addAcerto(user, exercicio);
			}
		} else { 
			if(!dao.exercicioFeito(user, id)){
				dao.addErro(user, exercicio);	
			}
			
		}
		res.redirect("/exercicio/" + disciplina + "/" + id_novo);
		return new ModelAndView("", "");
	}

}
