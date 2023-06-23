package net.figueiredo.java.demoapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.figueiredo.java.demoapi.model.Article;
import net.figueiredo.java.demoapi.repository.ArticleRepository;

@CrossOrigin
@RestController
@RequestMapping("/artigos")
public class ArticleController {

	@Autowired
	private ArticleRepository repository;

	@GetMapping
	public List<Article> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return repository.findAll();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public String getOne(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (repository.existsById(id)) {

			// ObjectMapper tenta converter um objeto para JSON.
			ObjectMapper mapper = new ObjectMapper();

			// Obtém o registro pelo Id e armazena no objeto "treco".
			Article artigo = repository.findById(id).get();

			// Retorna "treco" convertido para JSON (String → JSON).
			return mapper.writeValueAsString(artigo);
		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";

	}

	@PostMapping
	public Article post(@RequestBody Article artigo) {

		// O método "save()" de JPA cria um novo registro
		// e armazena o objeto nele.
		return repository.save(artigo);
	}

	@PatchMapping(path = "/{id}", produces = "application/json")
	public String updateViews(@PathVariable Long id) throws JsonProcessingException {

		// Se o registro com o Id existe.
		if (repository.existsById(id)) {

			// Obtém o registro do banco e armazena em "original".
			Article original = repository.findById(id).get();

			Article artigo = original;

			artigo.setArt_views(original.getArt_views() + 1);

			repository.save(artigo);

			return "{\"status\": \"views_updated\"}";

		}

		// Se o registro não existe, retorna o JSON.
		return "{ \"status\" : \"not found\" }";

	}
}