package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import modelo.Erro;

public class ErroDAO {
	private Erro erro = new Erro();
	
	public Erro load(String tipo){
		File arquivo = new File("banco/erros/" + tipo + ".csv");
		if ( ! arquivo.exists()) { 
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				erro.setTitulo(columns[0]);
				erro.setTexto(columns[1]);
			}
			scan.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return erro;
	}
}
