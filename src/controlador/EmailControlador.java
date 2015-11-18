package controlador;

import modelo.Usuario;
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
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("25");
		email.setStartTLSRequired(false);
		email.setSSLOnConnect(false);
		email.setSSL(true);  
        email.setTLS(true);  
		email.setAuthentication("bolsistasinformatica@gmail.com",  "informatica123");
		try {
		    email.setFrom("bolsistasinformatica@gmail.com");
		     
		    email.setDebug(true); 
		     
		    email.setSubject( conteudo + " - " + user.getUsername() + " - " + user.getMatricula() );
		    email.setMsg( duvida + "\n" + user.getEmail());
		    email.addTo("vinicius.crizel845@gmail.com");
		     
		    email.send();
		    
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
		res.redirect("/fisica2");
		return null;
	}

}
