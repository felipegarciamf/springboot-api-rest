package br.com.utiauto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.utiauto.modelo.Automovel;
import br.com.utiauto.modelo.Servico;

public class AutomovelForm {
	
	@NotNull @NotEmpty @Length(min = 1)
	private String modelo;
	
	@NotNull
	private int ano;
	
	@NotNull @NotEmpty
	private String marca;
	
	@NotNull 
	private Long renavam;
	
	@NotNull @NotEmpty
	private String cor;
	
	@NotNull @NotEmpty @Length(max = 7, min = 7)
	private String placa;
	
	
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
	public Automovel converter() {
		return new Automovel(modelo, ano, marca, renavam, cor, placa);
	}

}
