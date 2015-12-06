package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class EnviarSenha implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		String matricula = req.queryParams("matricula");
		String email = "";
		String senha = "";
		File dir = new File("banco/cadastros/" + matricula + ".csv");
		if (!dir.exists()) {
			res.redirect("/erro/nao_encontrada");
		}
		Scanner scan;
		try {
			scan = new Scanner(dir);
			String row = scan.nextLine();
			String[] columns = row.split(";");
			email = columns[2];
			senha = columns[3];
			sendMail(email, senha);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		res.redirect("/");
		return new ModelAndView("", "");
	}

	public void sendMail(String mail, String senha) {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(
				"ss.duvidas.pcd@gmail.com", "informatica123"));
		email.setSSLOnConnect(true);
		try {
		    email.setFrom("schoolsupport@no-spam.com");
		    email.setDebug(true); 
		    email.setSubject("Recuperação de senha");
		    email.setMsg("Sua senha eh: " + senha);
		    email.addTo(mail);

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}