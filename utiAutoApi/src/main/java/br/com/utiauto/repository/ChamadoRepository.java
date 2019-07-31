package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>  {


}
