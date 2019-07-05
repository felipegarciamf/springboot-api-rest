package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Servico;

public class ServicoForm {
	
	private String nomeServico;

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Servico converter() {
		return new Servico(nomeServico);
	}

}
