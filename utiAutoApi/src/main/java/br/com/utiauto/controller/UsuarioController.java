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

import br.com.utiauto.controller.dto.DetalhesDoUsuarioDto;
import br.com.utiauto.controller.dto.ServicoDto;
import br.com.utiauto.controller.dto.UsuarioDto;
import br.com.utiauto.controller.form.AtualizacaoUsuarioForm;
import br.com.utiauto.controller.form.UsuarioForm;
import br.com.utiauto.modelo.Servico;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@CrossOrigin
	@GetMapping
	public List<UsuarioDto> lista(String nome) {	
		List<Usuario> usuario;
		if(nome == null) {
			usuario = usuarioRepository.findAll(); 
		} else {
			usuario = usuarioRepository.findByNome(nome);
		}
		return UsuarioDto.converter(usuario);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> casdastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoUsuarioDto> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario= usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoUsuarioDto(usuario.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm form){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();	
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
	

	
	
}
