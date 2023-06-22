package net.figueiredo.java.demoapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.figueiredo.java.demoapi.model.Comments;
import net.figueiredo.java.demoapi.repository.CommentsRepository;

@RestController
@RequestMapping("/comentarios")
public class CommentsController {

	@Autowired
	private CommentsRepository repository;

	@GetMapping
	public List<Comments> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return repository.findAll();
	}

	@GetMapping(path = "/{articleId}")
	public List<Comments> getOne(@PathVariable Long articleId) {

		// Se o registro com o Id existe.
		//if (repository.existsByCmt_article(articleId)) {

			
			// Obtém o registro pelo Id e armazena no objeto "treco".
			return repository.findByCmt_article(articleId);

			
		//}

		// Se o registro não existe, retorna o JSON.
		//return null;

	}

	@PostMapping
	public Comments post(@RequestBody Comments comentario) {

		// O método "save()" de JPA cria um novo registro
		// e armazena o objeto nele.
		return repository.save(comentario);
	}

}