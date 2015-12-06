 package modelo;

public class Materia {
	
	private String disciplina;
	private String titulo;
	private String conteudo;
	private int code;
	private String bimestre;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getConteudo() {


		return conteudo;

	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getBimestre() {
		return bimestre;
	}

	@Override
	public String toString() {
		return "Materia [disciplina=" + disciplina + ", titulo=" + titulo + ", conteudo=" + conteudo + ", code=" + code
				+ ", bimestre=" + bimestre + "]";
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}
}
