package cadastro;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
	
		
		Usuario u = new Usuario();
		//p.setId(1810497);
		//p.setNome("Marcio");
		u.setMatricula("25");
		u.setUsername("patsouzaguiar");
		u.setEmail("patsouzaguiar@gmail.com");
		u.setSenha("1234");
		
		u.toCSV();
		
		Perfil p = new Perfil();
		
		p.setNome("Patrícia");
		p.setSobrenome("Aguiar");
		p.setCurso("Informática para Internet");
		p.setTurma("2C");
		p.setUsuario(u);
		
		p.toCSV();
		
	
		
	}

}
