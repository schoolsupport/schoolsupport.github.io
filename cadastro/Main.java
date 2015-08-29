package cadastro;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		Usuario u = new Usuario();
		u.setMatricula("25");
		u.setUsername("patsouzaguiar");
		boolean a = u.setEmail("patsouzaguiar@gmail.com");
		u.setSenha("1234");
		
		u.toCSV();
		
		Perfil p = new Perfil();
		
		p.setNome("Patrícia");
		p.setSobrenome("Aguiar");
		p.setCurso("Informática para Internet");
		p.setTurma("2C");
		p.setUsuario(u);
		
		p.toCSV();
		
		
		Usuario u2 = new Usuario();
		u2.setMatricula("32");
		u2.setUsername("lauraadalmolin");
		boolean b = u2.setEmail("laura.aguiar.dalmolin@gmail.com");
		u2.setSenha("321654");
		
		u2.toCSV();
		
		// Ele sempre testa o email procurando algum igual na lista de emails
		// Se encontrar ele retorna falso e não adiciona o email
		// Caso exista algum parâmetro de cadastro null, o cadastro não é efetuado.
		// Ou seja, não é criada uma pasta com a matrícula do usuário e seus dados.
		Usuario u3 = new Usuario();
		u3.setMatricula("42");
		u3.setUsername("patsouzaguiar2");
		boolean c = u.setEmail("patsouzaguiar@gmail.com");
		u3.setSenha("1234");
		System.out.println(c);
		u3.toCSV();
	
		

	
		
	}

}
