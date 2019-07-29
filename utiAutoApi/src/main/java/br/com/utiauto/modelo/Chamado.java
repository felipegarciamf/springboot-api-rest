package br.com.utiauto.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Chamado {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String descricao;
	
	private String cep;
	
	private String mensagem;
	
	private long valor;

	private LocalDateTime dataCriacao = LocalDateTime.now();
	


	@Enumerated(EnumType.STRING)
	private StatusChamado status = StatusChamado.NAO_RESPONDIDO;
	
	@OneToMany(mappedBy="chamado")
	private List<Mensagem> mensagens = new ArrayList<>();

	@ManyToOne
	private Usuario cliente;

	
	public Chamado() {
		
	}
	
	public Chamado(String descricao, String cep, String mensagem, Usuario cliente, long valor) {
		this.descricao = descricao;
		this.cep = cep;
		this.mensagem = mensagem;
		this.cliente = cliente;
		this.valor = valor;
	}

	public StatusChamado getStatus() {
		return status;
	}


	public void setStatus(StatusChamado status) {
		this.status = status;
	}





	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public List<Mensagem> getMensagens() {
		return mensagens;
	}


	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
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
	
	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}
	
	

	
}
