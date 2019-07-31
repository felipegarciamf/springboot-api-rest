package br.com.utiauto.controller.dto;

import java.time.LocalDateTime;

import br.com.utiauto.modelo.Mensagem;

public class MensagemDto {
	
	
	private Long id;
	
	private String mensagem;
	
	private LocalDateTime dataCriacao;
	
	private String cliente;


	public MensagemDto(Mensagem mensagem) {
		this.id = mensagem.getId();
		this.mensagem = mensagem.getMensagem();
		this.dataCriacao = mensagem.getDataCriacao();
		this.cliente = mensagem.getCliente().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getCliente() {
		return cliente;
	}
	

}
