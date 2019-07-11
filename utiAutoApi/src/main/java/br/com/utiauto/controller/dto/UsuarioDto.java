package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.Usuario;

public class UsuarioDto {
	
	
	private String nome;
	private String sobrenome;
	private long cpf;
	private long rg;
	private String dataNascimento;
	private String email;
	private long telefone; 
	private long celular;
	private long cnh;
	
	public UsuarioDto(Usuario usuario) {
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.rg = usuario.getRg();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.celular = usuario.getCelular();
		this.cnh = usuario.getCnh();
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





	public long getCpf() {
		return cpf;
	}





	public void setCpf(long cpf) {
		this.cpf = cpf;
	}





	public long getRg() {
		return rg;
	}





	public void setRg(long rg) {
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





	public long getTelefone() {
		return telefone;
	}





	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}





	public long getCelular() {
		return celular;
	}





	public void setCelular(long celular) {
		this.celular = celular;
	}





	public long getCnh() {
		return cnh;
	}





	public void setCnh(long cnh) {
		this.cnh = cnh;
	}





	public static List<UsuarioDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}
