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
		int total = (acertos + erros); 
		double p_acer = (double)(acertos/(double)total)*100;
		double p_err = (double)(erros/(double)total)*100;

		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		dados.put("acertos", acertos);
		dados.put("erros", erros);
		dados.put("total", total);
		dados.put("p_acer", p_acer);
		dados.put("p_err", p_err);
		return new ModelAndView(dados, "desempenho.html");
	}
}
