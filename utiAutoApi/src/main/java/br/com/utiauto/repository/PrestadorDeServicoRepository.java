package br.com.utiauto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.utiauto.modelo.Usuario;

public interface PrestadorDeServicoRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByTipoUsuario_Descricao(String descricao);

	
	@Query("SELECT t FROM Usuario t WHERE t.tipoUsuario <> 1")
	List<Usuario> findByTipoUsuarioPrestadorDeServico();
	
}
