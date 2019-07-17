package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.TipoUsuario;
import br.com.utiauto.modelo.Usuario;

public class PrestadorDeServicoDto {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String email;
	private String telefone; 
	private String celular;
	private String cnh;
	private TipoUsuario tipoUsuario;
	
	public PrestadorDeServicoDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.rg = usuario.getRg();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.celular = usuario.getCelular();
		this.cnh = usuario.getCnh();
		this.tipoUsuario = usuario.getTipoUsuario();
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
	
	
	public Long getId() {
		return id;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public static List<PrestadorDeServicoDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(PrestadorDeServicoDto::new).collect(Collectors.toList());
	}

}
