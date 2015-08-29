package Cadastro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Perfil {
	
	private Usuario usuario = new Usuario();
	private String nome;
	private String sobrenome;
	private String turma;
	private String curso;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void AddDisciplina(Disciplina d) {
		this.disciplinas.add(d);
	}
	
	public void toCSV() throws IOException {
		
		File dir = new File(usuario.getMatricula());
		if ( ! dir.exists()) { 
			dir.mkdir(); // make directory;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(nome);
		builder.append(";");
		builder.append(sobrenome);
		builder.append(";");
		builder.append(turma);
		builder.append(";");
		builder.append(curso);
		
		
		File file = new File(usuario.getMatricula() + "/" + "dados_perfil" + ".csv");
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(builder.toString());
		
		writer.flush();
		writer.close();
		
		
	}
	
}
