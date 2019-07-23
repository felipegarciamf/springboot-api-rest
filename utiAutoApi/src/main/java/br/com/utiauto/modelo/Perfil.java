package br.com.utiauto.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String nome;
	
	@OneToMany
	private List<Servico> servico;
	
	
	
	
	
	
	/**
	 * @return the servico
	 */
	public List<Servico> getServico() {
		return servico;
	}

	/**
	 * @param servico the servico to set
	 */
	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nome;
	}
	
}
