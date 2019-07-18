package br.com.utiauto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	List<Perfil> findByNome(String descricao);
	
}
