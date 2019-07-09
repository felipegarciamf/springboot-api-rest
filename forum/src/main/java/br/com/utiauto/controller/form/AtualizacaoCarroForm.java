package br.com.utiauto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.utiauto.modelo.Carro;
import br.com.utiauto.modelo.Topico;
import br.com.utiauto.repository.CarroRepository;

public class AtualizacaoCarroForm {
	
	
	@NotNull @NotEmpty @Length(min = 1)
	private String modelo;
	
	@NotNull @NotEmpty @Length(max = 4, min = 4)
	private int ano;
	
	@NotNull @NotEmpty
	private String marca;
	
	@NotNull @NotEmpty @Length(max = 10, min = 10)
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
	
	public Carro atualizar(Long id, CarroRepository carroRepository) {
		Carro carro = carroRepository.getOne(id);
		carro.setAno(this.ano);
		carro.setCor(this.cor);
		carro.setMarca(this.marca);
		carro.setModelo(this.modelo);
		carro.setPlaca(this.placa);
		carro.setRenavam(this.renavam);
		return carro;
	}
	
	
	

}
