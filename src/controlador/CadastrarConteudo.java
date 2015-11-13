package controlador;

import modelo.Materia;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class CadastrarConteudo implements TemplateViewRoute{
	public ModelAndView handle(Request req, Response res) {
		
		MateriaDAO dao = new MateriaDAO();
		Materia m = new Materia();
		m.setDisciplina(req.queryParams("disciplina"));
		m.setTitulo(req.queryParams("titulo"));
		m.setConteudo(req.queryParams("conteudo"));
		m.setBimestre(req.queryParams("bimestre"));
		dao.save(m);
		res.redirect("/admin");
		return null;
	}
}
