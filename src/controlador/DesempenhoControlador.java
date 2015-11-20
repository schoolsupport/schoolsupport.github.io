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
		int total = acertos + erros;
		int porc_acertos = acertos/total;
		int porc_erros = erros/total;
		System.out.println(total);
		System.out.print(2/3);
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		dados.put("acertos", acertos);
		dados.put("erros", erros);
		dados.put("porc_acertos", porc_acertos);
		dados.put("porc_errs", porc_erros);
		return new ModelAndView(dados, "desempenho.html");
	}
	

}
