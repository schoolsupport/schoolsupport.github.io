package controlador;


import modelo.Exercicio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class VerificaRespostas implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Exercicio exercicio = req.session().attribute("exercicio");
		String resposta_usuario = req.queryParams("alternativa");
		if(resposta_usuario.equals(exercicio.getAlternativaCorreta())) res.redirect("blank.html");
		
	    else res.redirect("/");
		
		return null;
	}

}
