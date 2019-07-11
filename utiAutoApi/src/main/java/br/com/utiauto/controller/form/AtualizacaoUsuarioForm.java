package br.com.utiauto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.utiauto.modelo.Servico;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.ServicoRepository;
import br.com.utiauto.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String sobrenome;
	@NotNull @NotEmpty @Length(max = 11, min = 11)
	private long cpf;
	@NotNull @NotEmpty @Length(max = 1, min = 9)
	private long rg;
	@NotNull @NotEmpty @Length(max = 10, min = 10)
	private String dataNascimento;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String senha;
	@NotNull @NotEmpty
	private long telefone; 
	@NotNull @NotEmpty
	private long celular;
	@NotNull @NotEmpty
	private long cnh;
	
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setNome(this.nome);
		usuario.setSobrenome(this.sobrenome);
		usuario.setDataNascimento(this.dataNascimento);
		usuario.setCelular(this.celular);
		usuario.setTelefone(this.telefone);
		usuario.setEmail(this.email);
		usuario.setCpf(this.cpf);
		usuario.setRg(this.rg);
		usuario.setSenha(this.senha);
		usuario.setCnh(this.cnh);
		return usuario;
	}
	
	

}
