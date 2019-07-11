package br.com.utiauto.controller.dto;

import br.com.utiauto.modelo.Usuario;

public class DetalhesDoUsuarioDto {
	
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String email;
	private Long celular;
	private Long cnh;
	

	public DetalhesDoUsuarioDto(Usuario usuario) {
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.celular = usuario.getCelular();
		this.cnh = usuario.getCnh();
	}
	
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public Long getCelular() {
		return celular;
	}
	public Long getCnh() {
		return cnh;
	}
	
	

}
