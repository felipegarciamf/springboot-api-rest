package br.com.utiauto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.utiauto.modelo.Chamado;
import br.com.utiauto.modelo.Usuario;

public class ChamadoDto {

	private long id;
	private String descricao;
	private String cep;
	private String cliente;
	private long valor;
	

	public ChamadoDto(Chamado chamado) {
		this.id = chamado.getId();
		this.descricao = chamado.getDescricao();
		this.cep = chamado.getCep();
		this.cliente = chamado.getCliente().getNome();
		this.valor = chamado.getValor();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCep() {
		return cep;
	}

	public long getId() {
		return id;
	}
	
	public String getCliente() {
		return cliente;
	}

	
	public long getValor() {
		return valor;
	}

	public static List<ChamadoDto> converter(List<Chamado> chamado) {
		return chamado.stream().map(ChamadoDto::new).collect(Collectors.toList());
	}
	
	
}
