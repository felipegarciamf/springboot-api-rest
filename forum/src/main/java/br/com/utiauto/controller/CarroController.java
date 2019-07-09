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

import br.com.utiauto.controller.dto.CarroDto;
import br.com.utiauto.controller.dto.DetalhesDoCarroDto;
import br.com.utiauto.controller.form.AtualizacaoCarroForm;
import br.com.utiauto.controller.form.CarroForm;
import br.com.utiauto.modelo.Carro;
import br.com.utiauto.modelo.Topico;
import br.com.utiauto.repository.CarroRepository;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroRepository carroRepository;
	
	
	@CrossOrigin
	@GetMapping
	public List<CarroDto> carro(Long id) {
		List<Carro> carro;
		carro = carroRepository.findAll();
		return CarroDto.converter(carro);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {
		Carro carro = form.converter();
		carroRepository.save(carro);
		URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoCarroDto> detalhar(@PathVariable Long id) {
		Optional<Carro> carro = carroRepository.findById(id);
		if (carro.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoCarroDto(carro.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CarroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCarroForm form){
		
		Optional<Carro> optional = carroRepository.findById(id);
		if (optional.isPresent()) {
			Carro carro = form.atualizar(id, carroRepository);
			return ResponseEntity.ok(new CarroDto(carro));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Carro> optional = carroRepository.findById(id);
		if (optional.isPresent()) {
			carroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	

	}
	
	
}
