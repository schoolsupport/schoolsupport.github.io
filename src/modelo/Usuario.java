package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import persistencia.UsuarioDAO;

public class Usuario {
	
	private String senha;
	private String matricula;
	private String email;
	private String username;
	private Perfil perfil;
	
	public Usuario() {
		
	}	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public boolean setMatricula(String matricula) {
		this.matricula = matricula;
		return true;
	}
	public String getEmail() {
		return email;
	}
	public boolean setEmail(String email) {
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.validateEmail(email)) {
			this.email = email;
			return true;
		}
		return false;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Perfil getPerfil() {
		return perfil;
	}
}
