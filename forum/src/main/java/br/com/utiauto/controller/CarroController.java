package br.com.utiauto.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.utiauto.controller.dto.CarroDto;
import br.com.utiauto.controller.form.CarroForm;
import br.com.utiauto.modelo.Carro;
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
	public ResponseEntity<CarroDto> cadastrar(@RequestBody @Valid CarroForm form, UriComponentsBuilder uriBuilder) {
		Carro carro = form.converter();
		carroRepository.save(carro);
		URI uri = uriBuilder.path("/carro/{id}").buildAndExpand(carro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CarroDto(carro));
	}

	/**
	 * @return the carroRepository
	 */
	public CarroRepository getCarroRepository() {
		return carroRepository;
	}

	/**
	 * @param carroRepository the carroRepository to set
	 */
	public void setCarroRepository(CarroRepository carroRepository) {
		this.carroRepository = carroRepository;
	}
	
}
