package controlador;

import java.io.File;
import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class UsuariosCadastrados implements TemplateViewRoute{
	@Override
	public ModelAndView handle(Request req, Response res) {
		File[] usuarios;
        File arquivos = new File("Cadastros");
        usuarios = arquivos.listFiles();
		HashMap mapa = new HashMap();
		mapa.put("usuarios", usuarios);
		return new ModelAndView(mapa, "usuariosCadastrados.html");
	}
}
