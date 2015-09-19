package cadastro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Perfil {
	
	private Usuario usuario;
	private String nome;
	private String sobrenome;
	private String turma;
	private String curso;
	private String bio;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private boolean completo = false; 
	private String comp = "Completar Perfil";
		
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
		this.setCompleto(true);
		this.setComp("Seu Perfil");
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
		
		File dir = new File("Perfis");
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
		builder.append(";");
		builder.append(bio);
		
		
		File file = new File("Perfis/" + usuario.getMatricula() + ".csv");
		
		FileWriter writer = new FileWriter(file);
		
		writer.write(builder.toString());
		
		writer.flush();
		writer.close();
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public boolean isCompleto() {
		return completo;
	}
	public void setCompleto(boolean completo) {
		this.completo = completo;
	}	
}
