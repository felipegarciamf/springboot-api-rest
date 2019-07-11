package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.Usuario;

public class LoginDto {

	private String email;
	private String senha;
	
	public LoginDto(Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public static List<LoginDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(LoginDto::new).collect(Collectors.toList());
	}
	
	
	
	
}
