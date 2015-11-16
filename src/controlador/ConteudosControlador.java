package controlador;

import java.util.HashMap;

import modelo.Materia;
import modelo.Usuario;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ConteudosControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Usuario usuario = req.session().attribute("usuario_logado");
		MateriaDAO dao = new MateriaDAO();
		String disciplina = req.params("disciplina");
		Materia materia = dao.busca(Integer.parseInt(req.params("id")), disciplina);			
		HashMap dados = new HashMap();
		BarraControlador.handle(req, res, dados);
		dados.put("conteudo", materia);
		req.session().attribute("conteudo", materia);
		BarraControlador.handle(req, res, dados);
		return new ModelAndView(dados, "conteudos.html");
	}
}