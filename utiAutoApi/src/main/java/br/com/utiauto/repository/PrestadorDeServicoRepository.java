package br.com.utiauto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.Usuario;

public interface PrestadorDeServicoRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByTipoUsuario_Descricao(String descricao);
	
}
