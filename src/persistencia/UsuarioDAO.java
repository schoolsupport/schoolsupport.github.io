package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Usuario;

public class UsuarioDAO {

	private Usuario usuario = new Usuario();

	private void addEmailToList() throws IOException {
		File emails = new File("banco/emails.csv");
		if (!emails.exists()) {
			FileWriter e = new FileWriter("banco/emails.csv");
			e.flush();
			e.close();
		}
		Scanner scan = new Scanner(emails);
		ArrayList<String> lista = new ArrayList<String>();

		if (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] columns = line.split(";");
			for (int i = 0; i < columns.length; i++) {
				lista.add(columns[i]);
			}
			scan.close();
			emails.delete();
			FileWriter emails2 = new FileWriter("banco/emails.csv");
			StringBuilder builder2 = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
				builder2.append(lista.get(i));

				builder2.append(";");
			}
			builder2.append(usuario.getEmail());
			builder2.append(";");
			emails2.write(builder2.toString());
			emails2.flush();
			emails2.close();
		} else {
			FileWriter ems = new FileWriter("banco/emails.csv");
			ems.append(usuario.getEmail());
			ems.append(";");
			ems.flush();
			ems.close();
		}
	}

	private void addMatriculaToList() throws IOException {
		File mats = new File("banco/matriculas.csv");
		if (!mats.exists()) {
			FileWriter e = new FileWriter("banco/matriculas.csv");
			e.flush();
			e.close();
		}
		Scanner scan = new Scanner(mats);
		ArrayList<String> lista = new ArrayList<String>();
		if (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] columns = line.split(";");
			for (int i = 0; i < columns.length; i++) {
				lista.add(columns[i]);
			}
			scan.close();
			mats.delete();
			FileWriter mats2 = new FileWriter("banco/mats.csv");

			StringBuilder builder2 = new StringBuilder();
			for (int i = 0; i < lista.size(); i++) {
				builder2.append(lista.get(i));

				builder2.append(";");
			}
			builder2.append(usuario.getMatricula());
			builder2.append(";");
			mats2.write(builder2.toString());
			mats2.flush();
			mats2.close();
		} else {
			FileWriter ems = new FileWriter("banco/matriculas.csv");
			ems.append(usuario.getMatricula());
			ems.append(";");
			ems.flush();
			ems.close();
		}
	}
	public Usuario load(String matricula) {
		File arquivo = new File("banco/cadastros/" + matricula + ".csv");
		if (!arquivo.exists()) {
			return null;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
				String[] columns = row.split(";");
				usuario.setMatricula(columns[0]);
				usuario.setUsername(columns[1]);
				usuario.setEmail(columns[2]);
				usuario.setSenha(columns[3]);
			}
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void save(Usuario u) throws IOException {
		if (u.getMatricula() != null && u.getUsername() != null
				&& u.getEmail() != null && u.getSenha() != null) {
			usuario = u;
			File dir = new File("banco/cadastros");
			if (!dir.exists()) {
				dir.mkdir(); // make directory;
			}
			StringBuilder builder = new StringBuilder();
			builder.append(u.getMatricula());
			builder.append(";");
			builder.append(u.getUsername());
			builder.append(";");
			builder.append(u.getEmail());
			builder.append(";");
			builder.append(u.getSenha());

			File file = new File("banco/cadastros/" + u.getMatricula() + ".csv");
			if (file.exists())
				return;
			FileWriter writer = new FileWriter(file);
			writer.write(builder.toString());
			writer.flush();
			writer.close();

			addEmailToList();
			addMatriculaToList();

			File dir2 = new File("banco/desempenhos/" + u.getMatricula());
			if (!dir2.exists()) {
				dir2.mkdir(); // make directory;
			}

		}
	}

	public boolean procuraCSV(String matricula, String senha2) {

		File arquivo = new File("banco/cadastros/" + matricula + ".csv");
		if (!arquivo.exists()) {
			return false;
		}
		try {
			Scanner scan = new Scanner(arquivo);
			while (scan.hasNextLine()) {
				String row = scan.nextLine();
				fromCSV(row);
			}
			scan.close();
			verificaSenha(senha2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void fromCSV(String row) {
		String[] columns = row.split(";");
		usuario.setMatricula(columns[0]);
		usuario.setUsername(columns[1]);
		usuario.setEmail(columns[2]);
		usuario.setSenha(columns[3]);
	}

	public boolean verificaSenha(String senha2) {
		if (senha2 == usuario.getSenha()) {
			return true;
		}
		return false;
	}
	public ArrayList<Usuario> findAll() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			File dir = new File("banco/cadastros/");
			File[] arqs = dir.listFiles();
			for (File arq : arqs) { // for each
				Scanner scan = new Scanner(arq);
				String linha = scan.nextLine();
				scan.close();
				String[] colunas = linha.split(";");

				Usuario u = new Usuario();
				u.setMatricula((colunas[0]));
				u.setUsername(colunas[1]);
				u.setEmail(colunas[2]);
				u.setSenha(colunas[3]);
				lista.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public boolean validateEmail(String email) {
		File emails = new File("banco/emails.csv");
		Scanner scan;
		try {
			scan = new Scanner(emails);
		} catch (FileNotFoundException e) {
			return true;
		}
		ArrayList<String> lista = new ArrayList<String>();

		if (scan.hasNextLine()) {
			String line = scan.nextLine();
			scan.close();
			String[] columns = line.split(";");
			for (int i = 0; i < columns.length; i++) {
				lista.add(columns[i]);
			}
			for (int i = 0; i < lista.size(); i++) {
				lista.get(i);
				if (lista.get(i).equals(email))
					return false;
			}
		}
		return true;
	}
}
