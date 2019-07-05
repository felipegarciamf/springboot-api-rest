package br.com.alura.forum.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Servico;

public class ServicoDto {
	
	private Long id;
	
	private String nomeServico;
	
	public ServicoDto(Servico servico) {
		this.id = servico.getId();
		this.nomeServico = servico.getNomeServico();
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

	

}
