package br.com.utiauto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.utiauto.controller.dto.LoginDto;
import br.com.utiauto.controller.dto.ServicoDto;
import br.com.utiauto.controller.dto.UsuarioDto;
import br.com.utiauto.modelo.Usuario;
import br.com.utiauto.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> login(String email, String senha){
		Optional<Usuario> optional = usuarioRepository.findByEmailSenha(email, senha);
		if (optional.isPresent()) {
			Usuario usuario = usuarioRepository.findByEmail(email);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();	
	}

}
