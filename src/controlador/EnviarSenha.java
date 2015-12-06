package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EnviarSenha implements TemplateViewRoute{

	@Override
	public ModelAndView handle(Request req, Response res) {
		
		String matricula = req.queryParams("matricula");
		String email = "";
		String senha = "";
		File dir = new File("banco/cadastros/" + matricula + ".csv");
		if(!dir.exists()){
			res.redirect("/erro/matricula");
		}
		Scanner scan;
		try {
			scan = new Scanner(dir);
			String row = scan.nextLine();
			String[] columns = row.split(";");
			email = columns[2];	
			senha = columns[3];
			sendMail(email, senha);
			//falta so enviar email
			//criar pagina de erro caso matricula nao exista
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		return new ModelAndView("","index.html");
	}
	public void sendMail(String mail, String senha){
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSslSmtpPort("465");
		email.setStartTLSRequired(false);
		email.setSSLOnConnect(false);
		email.setSSL(true);  
        email.setTLS(true);  
		email.setAuthentication("ss.duvidas.pcd@gmail.com",  "informatica123");
		try {
		    email.setFrom("ss.duvidas.pcd@gmail.com");
		    email.setDebug(true); 
		    email.setSubject("Recuperação de senha");
		    email.setMsg("Sua senha eh: " + senha);
		    email.addTo(mail);
		    
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
		
	}

}
