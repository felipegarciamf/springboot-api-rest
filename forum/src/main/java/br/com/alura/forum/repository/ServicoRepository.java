package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

	List<Servico> findByNomeServico(String nomeServico);

}
