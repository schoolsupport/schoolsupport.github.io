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

	@Override
	public ModelAndView handle(Request req, Response res) {
		
		Usuario user = req.session().attribute("usuario_logado");
		String conteudo = req.queryParams("conteudo");
		String duvida = req.queryParams("duvida");
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName( "smtp.gmail.com" );
		email.setSslSmtpPort( "465" );
		email.setStartTLSRequired(true);
		email.setSSLOnConnect(true);
		email.setAuthentication("bolsistasinformatica@gmail.com",  "informatica123");
		try {
		    email.setFrom( "bolsistasinformatica@gmail.com");
		     
		    email.setDebug(true); 
		     
		    email.setSubject( conteudo );
		    email.setMsg( duvida );
		    email.addTo( "andrew.apa@hotmail.com" );//por favor trocar antes de testar!!!!
		     
		    email.send();
		     
		} catch (EmailException e) {
			System.out.println("deu erro");
		    e.printStackTrace();
		} 
		System.out.println("aehuahuaeha");
		return null;
	}
	
}
