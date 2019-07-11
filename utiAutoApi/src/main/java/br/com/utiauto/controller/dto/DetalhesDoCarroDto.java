package br.com.utiauto.controller.dto;

import br.com.utiauto.modelo.Automovel;

public class DetalhesDoCarroDto {
	
	private Long id;
	private String modelo;
	private int ano;
	private String marca;
	private Long renavam;
	private String cor;
	private String placa;
	
	
	public DetalhesDoCarroDto(Automovel carro) {
		this.id = carro.getId();
		this.modelo = carro.getModelo();
		this.ano = carro.getAno();
		this.marca = carro.getMarca();
		this.renavam = carro.getRenavam();
		this.cor = carro.getCor();
		this.placa = carro.getPlaca();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getModelo() {
		return modelo;
	}
	public int getAno() {
		return ano;
	}
	public String getMarca() {
		return marca;
	}
	public Long getRenavam() {
		return renavam;
	}
	public String getCor() {
		return cor;
	}
	public String getPlaca() {
		return placa;
	}

}
