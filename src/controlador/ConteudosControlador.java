package controlador;

import java.util.HashMap;

import modelo.Materia;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ConteudosControlador implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		Materia materia;
		MateriaDAO dao = new MateriaDAO();
		materia = dao.busca(Integer.parseInt(req.params("id")));			
		HashMap dados = new HashMap();
		dados.put("conteudo", materia);
		req.session().attribute("conteudo", materia);
		
		
		return new ModelAndView(dados, "conteudos.html");
	}
}