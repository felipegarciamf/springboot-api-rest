package br.com.utiauto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.utiauto.controller.dto.ChamadoDto;
import br.com.utiauto.controller.dto.DetalhesDoChamadoDto;
import br.com.utiauto.controller.form.ChamadoForm;
import br.com.utiauto.modelo.Chamado;
import br.com.utiauto.repository.ChamadoRepository;

@RestController
@RequestMapping("/chamado")
public class ChamadoController {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@CrossOrigin
	@GetMapping
	@Cacheable(value = "listaDeChamados")
	public List<ChamadoDto> lista( 
			String nome) {	
	
		List<Chamado> chamado = null;
		if(nome == null) {
			chamado = chamadoRepository.findAll(); 
		} 
		return ChamadoDto.converter(chamado);
	}
	
	@CrossOrigin
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeChamados", allEntries = true)
	public ResponseEntity<ChamadoDto> casdastrar(@RequestBody @Valid ChamadoForm form, UriComponentsBuilder uriBuilder) {
		Chamado chamado = form.converter();
		chamadoRepository.save(chamado);
		URI uri = uriBuilder.path("/chamado/{id}").buildAndExpand(chamado.getId()).toUri();
		return ResponseEntity.created(uri).body(new ChamadoDto(chamado));
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoChamadoDto> detalhar(@PathVariable Long id) {
		Optional<Chamado> chamado = chamadoRepository.findById(id);
		if (chamado.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoChamadoDto(chamado.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	
	
	
	
	

}
