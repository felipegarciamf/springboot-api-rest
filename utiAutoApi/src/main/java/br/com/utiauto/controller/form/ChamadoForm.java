package br.com.utiauto.controller.form;

import br.com.utiauto.modelo.Chamado;
import br.com.utiauto.modelo.Usuario;

public class ChamadoForm {
	
	private String descricao;
	private String cep;
	private String mensagem;
	private Usuario cliente;
	private long valor;

	

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Chamado converter() {
		return new Chamado(descricao, cep, mensagem, cliente, valor);
	}


	

}
