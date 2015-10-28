package controlador;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class UsuariosCadastrados implements TemplateViewRoute{
	@Override
	public ModelAndView handle(Request req, Response res) {	
        File[] usuarios = new File("banco/cadastros").listFiles();
        int[] matriculas = new int[usuarios.length];
		for(int i = 0; i < usuarios.length; i++ ){
			matriculas[i] = Integer.parseInt((usuarios[i].getName()).substring(0, 8));
		}
		HashMap mapa = new HashMap();
			mapa.put("matriculas", matriculas);
		return new ModelAndView(mapa, "usuariosCadastrados.html");
	}
}
