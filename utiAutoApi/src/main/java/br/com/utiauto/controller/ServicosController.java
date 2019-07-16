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

import br.com.utiauto.controller.dto.DetalhesDoServicoDto;
import br.com.utiauto.controller.dto.ServicoDto;
import br.com.utiauto.controller.form.AtualizacaoServicoForm;
import br.com.utiauto.controller.form.ServicoForm;
import br.com.utiauto.modelo.Servico;
import br.com.utiauto.repository.ServicoRepository;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

	@Autowired
	private ServicoRepository servicoRepository;
	
	@CrossOrigin
	@GetMapping
	public List<ServicoDto> list(String nomeServico){
		List<Servico> servico;
		if(nomeServico == null) {
			servico = servicoRepository.findAll();
		} else {
			servico = servicoRepository.findByNomeServico(nomeServico);
		}
		return ServicoDto.converter(servico);
	}
	
	@PostMapping
	public ResponseEntity<ServicoDto> cadastrar(@RequestBody @Valid ServicoForm form, UriComponentsBuilder uriBuilder) {
		Servico servico = form.converter();
		servicoRepository.save(servico);
		URI uri = uriBuilder.path("/servicos/{id}").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoDto(servico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoServicoDto> detalhar(@PathVariable Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		if (servico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoServicoDto(servico.get()));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoServicoForm form){
		Optional<Servico> optional = servicoRepository.findById(id);
		if (optional.isPresent()) {
			Servico servico = form.atualizar(id, servicoRepository);
			return ResponseEntity.ok(new ServicoDto(servico));
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Servico> optional = servicoRepository.findById(id);
		if (optional.isPresent()) {
			servicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
	
	
}
