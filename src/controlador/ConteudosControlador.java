package controlador;

import java.util.HashMap;

import modelo.Materia;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ConteudosControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Materia materia;
		MateriaDAO dao = new MateriaDAO();
		String disciplina = req.params("disciplina");
		materia = dao.busca(Integer.parseInt(req.params("id")), disciplina);			
		HashMap dados = new HashMap();
		dados.put("conteudo", materia);
		req.session().attribute("conteudo", materia);
		
		
		return new ModelAndView(dados, "conteudos.html");
	}
}