package br.com.utiauto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.utiauto.modelo.Servico;

public class ServicoForm {
	
	@NotNull @NotEmpty @Length(min = 2)
	private String nomeServico;

	@NotNull @NotEmpty
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
