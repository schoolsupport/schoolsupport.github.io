package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Materia;
import modelo.Usuario;

public class MateriaDAO {

	Materia cadeira = new Materia();
	private int code = 1;

	public void generateCode() {
		File f = new File("banco/materias/" + cadeira.getDisciplina()
				+ "/code.csv");
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
			FileWriter writer = new FileWriter("banco/materias/"
					+ cadeira.getDisciplina() + "/code.csv");
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

		File conteudo = new File("banco/materias/" + cont.getDisciplina() + "/"
				+ cont.getCode() + ".csv");
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
			writer.write(cont.getCode() + "");

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Materia busca(int code, String disciplina) {

		File arquivo = new File("banco/materias/" + disciplina + "/" + code
				+ ".csv");

		if (!arquivo.exists()) {
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while (scan.hasNextLine()) {
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
	
	public ArrayList<Materia> findAll(String disciplina) {

		ArrayList<Materia> lista = new ArrayList<Materia>();
		try {
			File dir = new File("banco/materias/" + disciplina + "/");
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				if (!arq.getName().equals("code.csv")) {
				Materia m = new Materia();
				Scanner scan = new Scanner(arq);
				String linha = "";
				while (scan.hasNextLine())  { linha += scan.nextLine(); }
				scan.close();
				String[] columns = linha.split(";");
				m.setTitulo(columns[0]);
				m.setConteudo(columns[1]);
				m.setDisciplina(columns[2]);
				m.setBimestre(columns[3]);
				m.setCode(Integer.parseInt(columns[4]));
				
				lista.add(m);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}