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
		File perfis = new File("Perfis/"+usuario.getMatricula()+".csv");
		File cadastros = new File("Cadastros/"+usuario.getMatricula()+".csv");
		
		if(perfis.exists() && cadastros.exists()){
			perfis.delete();
			cadastros.delete();
		}
		res.redirect("/index.html");
		return null;
	}
}
