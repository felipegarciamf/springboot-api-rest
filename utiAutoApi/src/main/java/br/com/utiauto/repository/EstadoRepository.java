package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
