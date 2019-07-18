package br.com.utiauto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.utiauto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	
	List<Usuario> findByNome(@Param("nome") String nome);

	@Query("SELECT t FROM Usuario t WHERE t.email = :email AND t.senha = :senha")
	Optional<Usuario> findByEmailSenha(@Param("email") String email, @Param("senha") String senha);

	Optional<Usuario> findByEmail(String email);


}
