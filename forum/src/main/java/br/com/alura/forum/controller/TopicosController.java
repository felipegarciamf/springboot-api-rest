package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository TopicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {	
		List<Topico> topicos;
		if(nomeCurso == null) {
			topicos = TopicoRepository.findAll(); 
		} else {
			topicos = TopicoRepository.findByCurso_Nome(nomeCurso);
		}
		
		return TopicoDto.converter(topicos);
	}

}
