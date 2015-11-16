package modelo;

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
		
	
	
	@Override
	public String toString() {
		return "Perfil [usuario=" + usuario + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", turma=" + turma + ", curso=" + curso
				+ ", bio=" + bio + ", disciplinas=" + disciplinas
				+ ", completo=" + completo + ", comp=" + comp + "]";
	}
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
