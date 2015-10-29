package controlador;

import modelo.Exercicio;
import persistencia.ExercicioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CadastrarExercicio implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response resp) {
		Exercicio ex = new Exercicio();
		ex.setDisciplina(req.queryParams("disciplina"));
		ex.setOrdem(req.queryParams("ordem"));
		ex.setAlternativa1(req.queryParams("alternativa1"));
		ex.setAlternativa2(req.queryParams("alternativa2"));
		ex.setAlternativa3(req.queryParams("alternativa3"));
		ex.setAlternativa4(req.queryParams("alternativa4"));
		ex.setAlternativa5(req.queryParams("alternativa5"));
		ex.setAlternativaCorreta(req.queryParams("alternativa_correta"));
		ExercicioDAO dao = new ExercicioDAO();
		dao.save(ex);
		resp.redirect("/admin.html");
		return null;
	}

}
