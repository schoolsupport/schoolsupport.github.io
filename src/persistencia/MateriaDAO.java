package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modelo.Materia;

public class MateriaDAO {
	
	Materia cadeira = new Materia();
	private int code = 1;

	public void generateCode() {
		File f = new File("banco/materias/"+ cadeira.getDisciplina() + "/code.csv");
		if (f.exists()) {
			try {
				Scanner scan = new Scanner(f);
				String linha = scan.nextLine();
				String[] colunas = linha.split(";");
				code = Integer.parseInt(colunas[colunas.length - 1]) + 1;
				scan.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter writer = new FileWriter("banco/materias/" + cadeira.getDisciplina() + "/code.csv");
			writer.write(this.code + ";");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save(Materia cont) {
		cadeira = cont;
		
		File rota = new File("banco/materias/");
		if (!rota.exists())
			rota.mkdir();

		File nextRota = new File("banco/materias/" + cont.getDisciplina());
		if (!nextRota.exists())
			nextRota.mkdir();
		generateCode();		
		cont.setCode(code);
		
		File conteudo = new File("banco/materias/" + cont.getDisciplina()+ "/" + cont.getCode() + ".csv");
		if (conteudo.exists())
			return;
		
		FileWriter writer;
		try {
			writer = new FileWriter(conteudo);
			
			
			writer.write(cont.getTitulo());
			writer.write(";");
			writer.write(cont.getConteudo());
			writer.write(";");
			writer.write(cont.getDisciplina());
			writer.write(";");			
			writer.write(cont.getBimestre());
			writer.write(";");
			writer.write(cont.getCode() +"");
			
			

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	
	public Materia busca(int code, String disciplina) {
		
		File arquivo = new File("banco/materias/" + disciplina + "/" + code + ".csv");

		if ( ! arquivo.exists()) { 
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				
				cadeira.setTitulo(columns[0]);
				cadeira.setConteudo(columns[1]);
				cadeira.setDisciplina(columns[3]);
				cadeira.setBimestre(columns[3]);
				cadeira.setCode(Integer.parseInt(columns[4]));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return cadeira;
	}

}