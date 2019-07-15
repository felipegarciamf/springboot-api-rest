package br.com.utiauto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.utiauto.modelo.Curso;
import br.com.utiauto.modelo.Topico;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.CursoRepository;
import br.com.utiauto.repository.UsuarioRepository;

public class UsuarioForm {
	

	private String nome;
	

	private String sobrenome;

	private String cpf;
	

	private String rg;
	

	private String dataNascimento;
	

	private String email;
	

	private String senha;
	

	private String telefone; 

	private String celular;

	private String cnh;
	
	
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public Usuario converter() {
		return new Usuario(nome, sobrenome, cpf, rg, dataNascimento, email, senha, telefone, celular, cnh);
	}
 
	
	
}
