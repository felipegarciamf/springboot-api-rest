package br.com.utiauto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.utiauto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);

	/** Query com JPQL
	@Query("SELECT t FROM topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	*/
	@Query("SELECT t FROM Usuario t WHERE t.email = :email AND t.senha = :senha")
	Optional<Usuario> findByEmailSenha(@Param("email") String email, @Param("senha") String senha);

	Usuario findByEmail(String email);

}
