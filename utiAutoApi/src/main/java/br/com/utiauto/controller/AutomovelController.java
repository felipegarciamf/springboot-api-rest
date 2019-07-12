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

import br.com.utiauto.controller.dto.AutomovelDto;
import br.com.utiauto.controller.dto.DetalhesDoCarroDto;
import br.com.utiauto.controller.dto.UsuarioDto;
import br.com.utiauto.controller.form.AtualizacaoAutomovelForm;
import br.com.utiauto.controller.form.AutomovelForm;
import br.com.utiauto.modelo.Automovel;
import br.com.utiauto.modelo.Topico;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.AutomovelRepository;

@RestController
@RequestMapping("/automovel")
public class AutomovelController {
	
	@Autowired
	private AutomovelRepository carroRepository;
	
	
	@CrossOrigin
	@GetMapping
	public List<AutomovelDto> carro(Long id) {
		List<Automovel> carro;
		carro = carroRepository.findAll();
		return AutomovelDto.converter(carro);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutomovelDto> cadastrar(@RequestBody @Valid AutomovelForm form, UriComponentsBuilder uriBuilder) {
		Automovel carro = form.converter();
		carroRepository.save(carro);
		URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutomovelDto(carro));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoCarroDto> detalhar(@PathVariable Long id) {
		Optional<Automovel> carro = carroRepository.findById(id);
		if (carro.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoCarroDto(carro.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AutomovelDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAutomovelForm form){
		
		Optional<Automovel> optional = carroRepository.findById(id);
		if (optional.isPresent()) {
			Automovel carro = form.atualizar(id, carroRepository);
			return ResponseEntity.ok(new AutomovelDto(carro));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Automovel> optional = carroRepository.findById(id);
		if (optional.isPresent()) {
			carroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	

	}
	
	
}
