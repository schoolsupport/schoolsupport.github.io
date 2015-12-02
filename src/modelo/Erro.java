package modelo;

public class Erro {
	
	private String titulo;
	private String texto;
	
	public String toString() {
		return "Erro [titulo=" + titulo + ", texto=" + texto + "]";
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
