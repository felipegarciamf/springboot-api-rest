package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.Servico;

public class ServicoDto {
	
	private Long id;
	
	private String nomeServico;
	
	private String iconeServico;
	
	public ServicoDto(Servico servico) {
		this.id = servico.getId();
		this.nomeServico = servico.getNomeServico();
		this.iconeServico = servico.getIconeServico();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public static List<ServicoDto> converter(List<Servico> servicos) {
		return servicos.stream().map(ServicoDto::new).collect(Collectors.toList());
	}

	public String getIconeServico() {
		return iconeServico;
	}

	public void setIconeServico(String iconeServico) {
		this.iconeServico = iconeServico;
	}

	

}
