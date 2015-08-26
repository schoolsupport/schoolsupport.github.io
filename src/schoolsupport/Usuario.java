package schoolsupport;

import java.util.ArrayList;

public class Usuario {
	
	int ntweets = 0;
	private String email;
	private String senha;
	private String user;
	public String nome;
	public String telefone;
	public String cidade;
	public String bio;
	private ArrayList<Usuario> cadastro = new ArrayList<Usuario>();
	private Boolean login_feito = false, cadastro_comp = false, user_cad = false;
	private String senha_sistema, user_sistema;
	
	public int getNTweets() {
		return this.ntweets;
	}
	public String getSUser() {
		return user;
	}	
	public Usuario(String user) {
		this.user = user;
	}
	public Usuario(String email, String user, String senha) {
		this.email = email;
		this.user = user;
		this.senha = senha;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	//public void addUser() {
	//	users.add(this);
	//	s_users.add(this.getUser());
	//}
	public String CriarCadastro(String email, String nome_user, String senha) {
		Usuario t = new Usuario(nome_user);
		t.setUser(nome_user);		
		t.setSenha(senha);
		t.setEmail(email);
		
		senha_sistema = t.getSenha();
		user_sistema = t.getUser();
		cadastro_comp = true;
		
		t.setCadastrado();
		
		return "\nCadastro realizado com sucesso!";
	}
	public void setCadastrado() {
		this.user_cad = true;	
	}
	public Boolean getIfCadastrado() {
		return this.user_cad;
	}
	public String getCadastros() {
		return cadastro.toString().replace("[", "").replace("]", "").replace(",", "");
	}
	public String Login(String nome_user, String senha) {
		
			if(nome_user.equals(user_sistema)) {
				if(senha_sistema.equals(senha)) {
					login_feito = true;
			} } else {
				login_feito = false;
			}
			
		if (login_feito == false) {
			return "Usuario e senha não conferem!";
		} else {
			return "\nLogin feito com sucesso!";
		}
	}
	
	public String toCSV() {
		StringBuilder builder = new StringBuilder();
		builder.append(email);
		builder.append("; ");
		builder.append(senha);
		builder.append("; ");
		builder.append(user);
		
		return builder.toString();
	}
}
