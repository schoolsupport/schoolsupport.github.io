package controlador;

import java.util.HashMap;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class RedirecionaExercicios implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "pagina_exercicios.html");
	}

}
