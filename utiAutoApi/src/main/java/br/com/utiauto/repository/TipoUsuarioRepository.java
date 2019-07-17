package br.com.utiauto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.utiauto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

	TipoUsuario findByDescricao(String descricao);

}
