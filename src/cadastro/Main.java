package cadastro;

import java.io.*;
import spark.*;

public class Main {
	public static void main(String[] args) throws IOException {
	
		Spark.staticFileLocation("/pub");
		
		Cadastro cadastro = new Cadastro();
		
		Route rota= cadastro.novoCadastro;
		
		Spark.post("/cadastro", rota);		
	
		
	}
}
