package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Exercicio;
import modelo.Materia;
import persistencia.ExercicioDAO;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ExerciciosControlador implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response resp) {
		MateriaDAO daoM = new MateriaDAO();
		ExercicioDAO daoE = new ExercicioDAO();
		String disciplina = req.params("disciplina");
		ArrayList<Exercicio> exercicios = daoE.findAllPorBimestre(disciplina, 1);
		int id = Integer.parseInt(req.params("id"));
		Materia m = daoM.busca(id, disciplina);
		String conteudo = m.getTitulo();
		ArrayList<Exercicio> exercicios_filtrados = new ArrayList<Exercicio>();
		for (int i = 0; i < exercicios.size(); i++) {
			if (exercicios.get(i).getConteudo().equals(conteudo)) exercicios_filtrados.add(exercicios.get(i));
		}
		req.session().attribute("exercicios", exercicios_filtrados);
		id = 0;
		req.session().attribute("id", id);
		Exercicio e = exercicios_filtrados.get(0);
		HashMap dados = new HashMap();
		dados.put("exercicio", e);
		req.session().attribute("exercicio", e);
		BarraControlador.handle(req, resp, dados);
		return new ModelAndView(dados, "exercicio_conteudo.html");
	}
}