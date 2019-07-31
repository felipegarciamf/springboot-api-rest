package br.com.utiauto.controller.dto;

import br.com.utiauto.modelo.Servico;

public class DetalhesDoServicoDto {
	
	private Long id;
	
	private String nomeServico;
	
	private String iconeServico;
	
	public DetalhesDoServicoDto(Servico servico) {
		this.id = servico.getId();
		this.nomeServico = servico.getNomeServico();
		this.iconeServico = servico.getIconeServico();
	}

	public Long getId() {
		return id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public String getIconeServico() {
		return iconeServico;
	}

}
