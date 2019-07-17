package br.com.utiauto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.utiauto.controller.dto.PrestadorDeServicoDto;
import br.com.utiauto.controller.form.AtualizacaoPrestadorDeServicoForm;
import br.com.utiauto.controller.form.PrestadorDeServicoForm;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.PrestadorDeServicoRepository;
import br.com.utiauto.repository.TipoUsuarioRepository;


@RestController
@RequestMapping("/prestadorservico")
public class PrestadorDeServicoController {


	@Autowired
	private PrestadorDeServicoRepository prestadorDeServicoRepository;
	
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@CrossOrigin
	@GetMapping
	public List<PrestadorDeServicoDto> lista(String descricao) {	
		List<Usuario> usuario;
		
		if(descricao == null) {
			usuario = prestadorDeServicoRepository.findByTipoUsuarioPrestadorDeServico(); 
		} else {
			usuario = prestadorDeServicoRepository.findByTipoUsuario_Descricao(descricao); 
		}
		return PrestadorDeServicoDto.converter(usuario);
	}
	
	
	@CrossOrigin
	@PostMapping
	@Transactional
	public ResponseEntity<PrestadorDeServicoDto> cadastrar(@RequestBody @Valid PrestadorDeServicoForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter(tipoUsuarioRepository);
		prestadorDeServicoRepository.save(usuario);
		URI uri = uriBuilder.path("/prestadorservico/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new PrestadorDeServicoDto(usuario));
	}
	
	
	@CrossOrigin
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PrestadorDeServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPrestadorDeServicoForm form){
		Optional<Usuario> optional = prestadorDeServicoRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, prestadorDeServicoRepository);
			return ResponseEntity.ok(new PrestadorDeServicoDto(usuario));
		}
		return ResponseEntity.notFound().build();	
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PrestadorDeServicoDto> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario = prestadorDeServicoRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new PrestadorDeServicoDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Usuario> optional = prestadorDeServicoRepository.findById(id);
		if (optional.isPresent()) {
			prestadorDeServicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
	

}
