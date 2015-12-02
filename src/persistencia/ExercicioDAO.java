package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import modelo.Exercicio;
import modelo.Usuario;

public class ExercicioDAO {
	Exercicio exercicio = new Exercicio();
	private int code = 1;

	public void generateCode() {
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

	public void save(Exercicio ex) {
		generateCode();
		ex.setCode(code);
		File rota = new File("banco/exercicios");
		if (!rota.exists())
			rota.mkdir();

		File nextRota = new File("banco/exercicios/" + ex.getDisciplina());
		if (!nextRota.exists())
			nextRota.mkdir();

		File exercicio = new File("banco/exercicios/" + ex.getDisciplina()
				+ "/" + ex.getCode() + ".csv");
		if (exercicio.exists())
			return;

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
			writer.write(";");
			writer.write(ex.getConteudo());

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Exercicio busca(int i, String disciplina) {
		File arquivo = new File("banco/exercicios/" + disciplina + "/" + i
				+ ".csv");

		if (!arquivo.exists()) {
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				exercicio.setDisciplina(disciplina);
				exercicio.setCode(i);
				exercicio.setOrdem(columns[0]);
				exercicio.setAlternativa1(columns[1]);
				exercicio.setAlternativa2(columns[2]);
				exercicio.setAlternativa3(columns[3]);
				exercicio.setAlternativa4(columns[4]);
				exercicio.setAlternativa5(columns[5]);
				switch (Integer.parseInt(columns[6])) {
				case 1:
					exercicio.setAlternativaCorreta(columns[1]);
					break;
				case 2:
					exercicio.setAlternativaCorreta(columns[2]);
					break;
				case 3:
					exercicio.setAlternativaCorreta(columns[3]);
					break;
				case 4:
					exercicio.setAlternativaCorreta(columns[4]);
					break;
				case 5:
					exercicio.setAlternativaCorreta(columns[5]);
					break;
				}
				exercicio.setBimestre(columns[7]);
				exercicio.setConteudo(disciplina);
			}

			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return exercicio;
	}

	public ArrayList<Exercicio> findAllPorBimestre(String disciplina,
			int bimestre) {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		File arquivo = new File("banco/exercicios/" + disciplina);
		File[] exs = arquivo.listFiles();
		for (File ex : exs) { // for each
			try {

				Scanner scan = new Scanner(ex);

				String linha = scan.nextLine();
				scan.close();
				Exercicio e = new Exercicio();
				String[] columns = linha.split(";");
				String s = ex.getName();
				s = s.replace(".csv", "");
				e.setCode(Integer.parseInt(s));
				e.setOrdem(columns[0]);
				e.setAlternativa1(columns[1]);
				e.setAlternativa2(columns[2]);
				e.setAlternativa3(columns[3]);
				e.setAlternativa4(columns[4]);
				e.setAlternativa5(columns[5]);
				switch (Integer.parseInt(columns[6])) {
				case 1:
					e.setAlternativaCorreta(columns[1]);
					break;
				case 2:
					e.setAlternativaCorreta(columns[2]);
					break;
				case 3:
					e.setAlternativaCorreta(columns[3]);
					break;
				case 4:
					e.setAlternativaCorreta(columns[4]);
					break;
				case 5:
					e.setAlternativaCorreta(columns[5]);
					break;
				}
				e.setBimestre(columns[7]);
				e.setConteudo(disciplina);
				exercicios.add(e);
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}

		if (bimestre == 0) {
			Collections.shuffle(exercicios);
			currentRandom(exercicios);
			return exercicios;
		}
		ArrayList<Exercicio> filtrados = new ArrayList<Exercicio>();
		for (int i = 0; i < exercicios.size(); i++) {
			if (exercicios.get(i).getBimestre().equals(bimestre + ""))
				filtrados.add(exercicios.get(i));
		}
		Collections.shuffle(filtrados);
		currentRandom(filtrados);
		return filtrados;

	}

	public void currentRandom(ArrayList<Exercicio> e) {
		File dir = new File("banco/currentRandom/");
		if (!dir.exists())
			dir.mkdir();
		File file = new File("banco/currentRandom/list.csv");
		try {
			FileWriter writer = new FileWriter(file);
			for (int i = 0; i < e.size(); i++) {
				writer.write(e.get(i).getCode());
				writer.write(";");
			}
			writer.flush();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void addAcerto(Usuario user, Exercicio exercicio) {
		File file = new File("banco/desempenhos");
		if (!file.exists())	file.mkdir();
		
		File dir = new File("banco/desempenhos/" + user.getMatricula());
		if (!dir.exists())  dir.mkdir();

		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+ "/acertos");
		if (!dir2.exists())	dir2.mkdir();

		File dir3 = new File("banco/desempenhos/" + user.getMatricula()	+ "/acertos/" + exercicio.getCode() + ".csv");
		FileWriter writer;
			if(!dir3.exists()){
				try {
					writer = new FileWriter(dir3);
					writer.write(exercicio.getCode());
					writer.write(";");
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}

	public void addErro(Usuario user, Exercicio exercicio) {
		File file = new File("banco/desempenhos");
		if (!file.exists())	file.mkdir();
		
		File dir = new File("banco/desempenhos/" + user.getMatricula());
		if (!dir.exists())  dir.mkdir();

		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+ "/erros");
		if (!dir2.exists())	dir2.mkdir();

		File dir3 = new File("banco/desempenhos/" + user.getMatricula()	+ "/erros/" + exercicio.getCode() + ".csv");
		FileWriter writer;
		if(!dir3.exists()){
			try {
				writer = new FileWriter(dir3);
				writer.write(exercicio.getCode());
				writer.write(";");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public int getAcertos(Usuario user) {
		File file = new File("banco/desempenhos");
		if (!file.exists())	file.mkdir();
		
		File dir = new File("banco/desempenhos/" + user.getMatricula());
		if (!dir.exists())  dir.mkdir();

		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+ "/acertos");
		if (!dir2.exists())	dir2.mkdir();
		
		File[] files = dir2.listFiles();
		
		return files.length;
	}
	public int getErros(Usuario user) {
		File file = new File("banco/desempenhos");
		if (!file.exists())	file.mkdir();
		
		File dir = new File("banco/desempenhos/" + user.getMatricula());
		if (!dir.exists())  dir.mkdir();

		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+ "/erros");
		if (!dir2.exists())	dir2.mkdir();
		
		File[] files = dir2.listFiles();
		
		return files.length;
	}
	
	public boolean exercicioFeito(Usuario user, int code){
		
		File dir = new File("banco/desempenhos/" + user.getMatricula()+ "/acertos/" + code + ".csv");
		File dir2 = new File("banco/desempenhos/" + user.getMatricula()+ "/erros/" + code + ".csv");
		
		if(dir.exists() || dir2.exists()){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}