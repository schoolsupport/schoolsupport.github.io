package modelo;

public class Exercicio {
	
	
	private String ordem;
	private String alternativa1;
	private String alternativa2;
	private String alternativa3;
	private String alternativa4;
	private String alternativa5;
	private String alternativa_correta;
	private String bimestre;
	private String disciplina;
	private int code;
	
	public String getAlternativa_correta() {
		return alternativa_correta;
	}
	public void setAlternativa_correta(String alternativa_correta) {
		this.alternativa_correta = alternativa_correta;
	}
	public String getBimestre() {
		return bimestre;
	}
	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getOrdem() {
		return ordem;
	}
	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}
	public String getAlternativa1() {
		return alternativa1;
	}
	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}
	public String getAlternativa2() {
		return alternativa2;
	}
	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
	}
	public String getAlternativa3() {
		return alternativa3;
	}
	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}
	public String getAlternativa4() {
		return alternativa4;
	}
	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}
	public String getAlternativa5() {
		return alternativa5;
	}
	public void setAlternativa5(String alternativa5) {
		this.alternativa5 = alternativa5;
	}
	public String getAlternativaCorreta() {
		return alternativa_correta;
	}
	public void setAlternativaCorreta(String alternativa_correta) {
		this.alternativa_correta = alternativa_correta;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	@Override
	public String toString() {
		return "Exercicio [ordem=" + ordem + ", alternativa1=" + alternativa1 + ", alternativa2=" + alternativa2
				+ ", alternativa3=" + alternativa3 + ", alternativa4=" + alternativa4 + ", alternativa5=" + alternativa5
				+ ", alternativa_correta=" + alternativa_correta + ", code=" + code + ", disciplina=" + disciplina
				+ "]";
	}
	
	
}
