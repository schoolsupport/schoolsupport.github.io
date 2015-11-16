package controlador;

import modelo.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EmailControlador implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		
		Usuario user = req.session().attribute("usuario_logado");
		String conteudo = req.queryParams("conteudo");
		String duvida = req.queryParams("duvida");
		String email = "vinicius.crizel845@gmail.com";
		SendMail sm = new SendMail();
		sm.sendMail(email,email,conteudo,duvida); 
		
		return null;
	}
	
}
