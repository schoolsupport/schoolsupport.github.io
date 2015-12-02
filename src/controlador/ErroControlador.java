package controlador;

import java.util.HashMap;

import persistencia.ErroDAO;
import modelo.Erro;
import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ErroControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		String tipo = req.params("tipo");
		ErroDAO dao = new ErroDAO();
		Erro e = dao.load(tipo);
		
		HashMap dados = new HashMap();
		dados.put("erro", e);
		return new ModelAndView(dados, "erro.html");
	}
}
