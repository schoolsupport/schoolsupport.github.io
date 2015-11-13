package controlador;

import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class DesempenhoControlador implements TemplateViewRoute {
	@Override
	public ModelAndView handle(Request req, Response res) {
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "desempenho.html");
	}
	

}
