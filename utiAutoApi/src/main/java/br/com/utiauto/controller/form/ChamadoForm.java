package br.com.utiauto.controller.form;

import br.com.utiauto.modelo.Chamado;

public class ChamadoForm {
	
	private String descricao;
	private String cep;
	private String mensagem;

	

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

	public Chamado converter() {
		// TODO Auto-generated method stub
		return new Chamado(descricao, cep, mensagem);
	}
	

}
