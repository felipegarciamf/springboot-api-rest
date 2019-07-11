package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long> {

}
