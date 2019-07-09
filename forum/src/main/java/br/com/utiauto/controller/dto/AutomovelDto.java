package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.Automovel;

public class AutomovelDto {

	private Long id;
	private String modelo;
	private int ano;
	private String marca;
	private Long renavam;
	private String cor;
	private String placa;
	
	
	public AutomovelDto(Automovel carro) {
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
	
	public static List<AutomovelDto> converter(List<Automovel> carro) {
		return carro.stream().map(AutomovelDto::new).collect(Collectors.toList());
	}
	
}
