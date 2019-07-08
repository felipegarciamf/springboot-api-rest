package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.ServicoDto;
import br.com.alura.forum.controller.form.ServicoForm;
import br.com.alura.forum.modelo.Servico;
import br.com.alura.forum.repository.ServicoRepository;

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
	public ResponseEntity<ServicoDto> cadastrar(@RequestBody ServicoForm form, UriComponentsBuilder uriBuilder) {
		Servico servico = form.converter();
		servicoRepository.save(servico);
		URI uri = uriBuilder.path("/servicos/{id}").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoDto(servico));
	}
	
	
}
