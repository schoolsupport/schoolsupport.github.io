package Controlador;

import cadastro.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import java.io.*;

public class ApagarPerfil implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		
		Usuario usuario = req.session().attribute("usuario_logado");
		
		File perfis = new File("Perfis/"+usuario.getMatricula());
		if(perfis.exists()){
			perfis.delete();
		}
		
		
		return null;
	}

}
