package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Exercicio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EndRandomExercises implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response res) {
		HashMap dados = new HashMap();
		ArrayList<Exercicio> exercicios = req.session().attribute("exercicios");
		int total = exercicios.size();
		int acertos = req.session().attribute("acertos");
		dados.put("acertos", acertos);
		dados.put("total", total);
		double percentual = (double)((acertos/total)*100);
		dados.put("percentual", percentual);
		BarraControlador.handle(req, res, dados);
		return new ModelAndView (dados, "resultado_aleatorios.html");
	}

		
}
