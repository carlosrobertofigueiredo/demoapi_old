package net.figueiredo.java.demoapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.figueiredo.java.demoapi.model.Article;
import net.figueiredo.java.demoapi.model.Usuario;
import net.figueiredo.java.demoapi.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public List<Usuario> getAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) {

		if (repository.existsById(id)) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				Usuario employe = repository.findById(id).get();
				return mapper.writeValueAsString(employe);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return "{ \"status\" : \"not found\" }";

	}
	
	@PostMapping
	public Usuario post(@RequestBody Usuario usuario) {

		// O método "save()" de JPA cria um novo registro
		// e armazena o objeto nele.
		return repository.save(usuario);
	}

}