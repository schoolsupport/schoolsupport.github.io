package controlador;

import java.util.HashMap;

import persistencia.ExercicioDAO;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class DesempenhoControlador implements TemplateViewRoute {
	@Override
	public ModelAndView handle(Request req, Response res) {
		Usuario u = req.session().attribute("usuario_logado");
		ExercicioDAO dao = new ExercicioDAO();
		int acertos = dao.getAcertos(u);
		int erros = dao.getErros(u);
		System.out.println("Acertos:" + acertos);
		System.out.println("Erros:" + erros);
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "desempenho.html");
	}
	

}
