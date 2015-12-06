package controlador;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class UsuariosCadastrados implements TemplateViewRoute{
	@Override
	public ModelAndView handle(Request req, Response res) {	
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = dao.findAll();
		HashMap mapa = new HashMap();
		mapa.put("matriculas", usuarios);
		BarraControlador.handle(req, res, mapa);
		return new ModelAndView(mapa, "usuariosCadastrados.html");
	}
}