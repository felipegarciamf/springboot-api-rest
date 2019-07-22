package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
