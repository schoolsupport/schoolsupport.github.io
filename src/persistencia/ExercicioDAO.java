package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import modelo.Exercicio;

public class ExercicioDAO {
	Exercicio exercicio = new Exercicio();
	private int code = 1;
	
	public void generateCode () {
		File f = new File("banco/exercicios/code.csv");
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
			FileWriter writer = new FileWriter("banco/exercicios/code.csv");
			writer.write(this.code + ";");
			writer.flush(); 
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
	public void save (Exercicio ex) {
		generateCode();
		ex.setCode(code);
		File rota = new File ("banco/exercicios");
		if (! rota.exists()) rota.mkdir();
		
		File nextRota = new File("banco/exercicios/" + ex.getDisciplina());
		if (! nextRota.exists()) nextRota.mkdir();
				
		File exercicio = new File("banco/exercicios/" + ex.getDisciplina() + "/" + ex.getCode() + ".csv");
		if(exercicio.exists()) return;
				
		FileWriter writer;
		try {
			writer = new FileWriter(exercicio);
			writer.write(ex.getOrdem());
			writer.write(";");
			writer.write(ex.getAlternativa1());
			writer.write(";");
			writer.write(ex.getAlternativa2());
			writer.write(";");
			writer.write(ex.getAlternativa3());
			writer.write(";");
			writer.write(ex.getAlternativa4());
			writer.write(";");
			writer.write(ex.getAlternativa5());
			writer.write(";");
			writer.write(ex.getAlternativaCorreta());
			writer.write(";");
			writer.write(ex.getBimestre());
					
			writer.flush();
			writer.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	public Exercicio busca(int i, String disciplina) {
		File arquivo = new File("banco/exercicios/" + disciplina + "/" + code + ".csv");

		if ( ! arquivo.exists()) { 
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while(scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				exercicio.setCode(i);
				exercicio.setOrdem(columns[0]);
				exercicio.setAlternativa1(columns[1]);
				exercicio.setAlternativa2(columns[2]);
				exercicio.setAlternativa3(columns[3]);
				exercicio.setAlternativa4(columns[4]);
				exercicio.setAlternativa5(columns[5]);
				switch(Integer.parseInt(columns[6])) {
					case 1: exercicio.setAlternativaCorreta(columns[1]); break;
					case 2: exercicio.setAlternativaCorreta(columns[2]); break;
					case 3: exercicio.setAlternativaCorreta(columns[3]); break;
					case 4: exercicio.setAlternativaCorreta(columns[4]); break;
					case 5: exercicio.setAlternativaCorreta(columns[5]); break;
				}
				exercicio.setBimestre(columns[7]);
			}
				
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return exercicio;
	}	
}