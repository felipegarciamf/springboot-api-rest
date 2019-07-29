package br.com.utiauto.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import br.com.utiauto.modelo.Chamado;
import br.com.utiauto.modelo.StatusChamado;

public class DetalhesDoChamadoDto {
	
	private Long id;
	private String descricao;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String cliente;
	private StatusChamado status;
	private List<MensagemDto> respostas;
	
	
	public DetalhesDoChamadoDto(Chamado chamado) {
		this.id = chamado.getId();
		this.descricao = chamado.getDescricao();
		this.mensagem = chamado.getMensagem();
		this.dataCriacao = chamado.getDataCriacao();
		this.cliente = chamado.getCliente().getNome();
		this.status = chamado.getStatus();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(chamado.getMensagens().stream().map(MensagemDto::new).collect(Collectors.toList()));
		
	}
	
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
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
	public StatusChamado getStatus() {
		return status;
	}
	public List<MensagemDto> getRespostas() {
		return respostas;
	}
	
	
	
	
}
