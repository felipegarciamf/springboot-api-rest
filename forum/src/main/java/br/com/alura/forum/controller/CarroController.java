package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.CarroDto;
import br.com.alura.forum.modelo.Carro;
import br.com.alura.forum.repository.CarroRepository;

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
