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
		this.conteudo = toHTML(conteudo);
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}
	public static String toHTML(String s) {
		s = s.trim();
		char[] vetor = s.toCharArray();
		
		if (s.contains("<")) {
			int primeiro = s.indexOf("<", 0);
			int ultimo = s.lastIndexOf(">");
			if (s.charAt(primeiro + 1) != ' ' && s.charAt(ultimo - 1) != ' ') {
				s = s.replace(">", "</a>");
				String meio = s.substring(primeiro + 1, ultimo);
				String finaleira = s.substring(s.lastIndexOf("<"), s.length());
				String comeco = s.substring(0, s.lastIndexOf("<"));
				comeco = comeco.replace("<", "<a href=\"" + meio + "\"" + ">");
				s = comeco + finaleira;
					
				return s;
			}
		}
		if(s.contains("**")) {
			s = s.replace("**.", "</strong>.");
			s = s.replace("** ", "</strong> ");
			s = s.replace(" **", " <strong>");
			s = s.replace("**", "<strong>");	
			return s;
		}
		if(s.contains("*n")) {
			s = s.replace("*n", "<br>");
			s = s.replace("*n ", "<br> ");
			s = s.replace(" *n", " <br>");
					
			return s;
		}
		if (s.contains("*")) {
			if (s.charAt(s.indexOf('*', 0) + 1) != ' ' && s.charAt(s.lastIndexOf('*') - 1) != ' ') {
				s = s.replace(" *", " <em>");				
				s = s.replace("* ", "</em> ");
				
				return s;
			}
		}
		if(vetor[0] != '#') {
			return new String(vetor).trim();
		}
		if(vetor[0] == '#' && vetor[1] == ' ') {
			vetor[0] = ' ';
			String nova = new String(vetor).trim();
			return "<h1>" + nova + "</h1>";
		}
		if(vetor[0] == '#' && vetor[1] == '#' && vetor[2] == ' ') {
			vetor[0] = ' ';
			vetor[1] = ' ';
			String nova = new String(vetor).trim();
			return "<h2>" + nova + "</h2>";
		}
		if(vetor[0] == '#' && vetor[1] == '#' && vetor[2] == '#' && vetor[3] == ' ') {
			vetor[0] = ' ';
			vetor[1] = ' ';
			vetor[2] = ' ';
			String nova = new String(vetor).trim();
			return "<h3>" + nova + "</h3>";
		}
		if(vetor[0] == '#' && vetor[1] != ' ') {
			return s;
		}
		if(vetor[0] == '#' && vetor[1] == '#' && vetor[2] == '#' && vetor[3] == '#') {
			return s;
		}
						
		return "";
	}
	
}
