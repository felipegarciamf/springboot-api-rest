package br.com.utiauto.controller.dto;

public class TokenDto {
	

	private String token;
	private String tipo;

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	

}
