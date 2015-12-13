package controlador;

import modelo.Usuario;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EmailControlador implements TemplateViewRoute{
	public ModelAndView handle(Request req, Response res) {
		Usuario user = req.session().attribute("usuario_logado");
		String conteudo = req.queryParams("conteudo");
		String duvida = req.queryParams("duvida");
		
		SimpleEmail email = new SimpleEmail();
	    email.setHostName("smtp.googlemail.com");  
	    email.setSmtpPort(465);  
	    email.setAuthenticator(new DefaultAuthenticator("ss.duvidas.pcd@gmail.com", "informatica123"));  
	    email.setSSLOnConnect(true);
		try {
		    email.setFrom("schoolsupport@no-spam.com");

		   	email.setDebug(true); 
		    email.setSubject( conteudo + " - " + user.getUsername() + " - " + user.getMatricula() );
		    email.setMsg(user.getPerfil().getNome() + "\n" + duvida + "\n" + user.getPerfil().getCurso());
		    email.addTo("ss.duvidas.pcd@gmail.com");
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
		res.redirect("/fisica2");
		return new ModelAndView("", "");		

	}
}
