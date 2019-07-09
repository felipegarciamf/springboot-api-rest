package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	

}
