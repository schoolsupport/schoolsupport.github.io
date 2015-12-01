package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Materia;
import persistencia.MateriaDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class ListaConteudosNome implements TemplateViewRoute {

	@Override
	public ModelAndView handle(Request req, Response res) {
		MateriaDAO dao = new MateriaDAO();
		ArrayList<Materia> ms = dao.findAll("fisica2");
		HashMap mapa = new HashMap();
		mapa.put ("materias", ms);
		BarraControlador.handle(req, res, mapa);
		return new ModelAndView(mapa, "/listaconteudosnome.html");
		
		
	}

}
