package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Servico;

public class ServicoForm {
	
	private String nomeServico;


	private String iconeServico;

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	public String getIconeServico() {
		return iconeServico;
	}

	public void setIconeServico(String iconeServico) {
		this.iconeServico = iconeServico;
	}

	public Servico converter() {
		return new Servico(nomeServico, iconeServico);
	}

}
