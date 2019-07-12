package br.com.utiauto.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Automovel {
	
	
	public Automovel() {
	}
	
	public Automovel(String modelo, int ano, String marca, Long renavam, String cor, String placa) {
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.renavam = renavam;
		this.cor = cor;
		this.placa = placa;
	}



	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String modelo;
	private int ano;
	private String marca;
	private Long renavam;
	private String cor;
	private String placa;
	
	@OneToOne
	private Usuario usuario;
	
	
	
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public Long getRenavam() {
		return renavam;
	}



	public void setRenavam(Long renavam) {
		this.renavam = renavam;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	
	
}
