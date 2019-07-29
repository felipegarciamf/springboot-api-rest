package br.com.utiauto.controller.dto;

import org.springframework.data.domain.Page;

import br.com.utiauto.modelo.Chamado;

public class ChamadoDto {

	
	private String descricao;
	private String cep;
	

	public ChamadoDto(Chamado chamado) {
		this.descricao = chamado.getDescricao();
		this.cep = chamado.getCep();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCep() {
		return cep;
	}

	public static Page<ChamadoDto> converter(Page<Chamado> chamado) {
		return chamado.map(ChamadoDto::new);
	}

	
	
}
