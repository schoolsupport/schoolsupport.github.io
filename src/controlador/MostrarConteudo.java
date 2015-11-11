package controlador;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import modelo.Materia;
import spark.*;

public class MostrarConteudo implements TemplateViewRoute {
	public ModelAndView handle(Request req, Response res) {
		Materia c = new Materia();
		HashMap dados = new HashMap();
		
		try {
		File dir = new File("Materias/F�sica 2");
		File[] arqs = dir.listFiles();
		for(File arq : arqs){ //For each
		Scanner scan = new Scanner(arq);
		String linha = scan.nextLine();
		String[] colunas = linha.split(";");
		
		
		c.setTitulo(colunas[0]);
		c.setConteudo(colunas[1]);
		scan.close();
		
		dados.put("conteudo", c);
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView(dados, "conteudo_teste.html");
	}

}
