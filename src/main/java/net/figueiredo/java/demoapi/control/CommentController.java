package net.figueiredo.java.demoapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.figueiredo.java.demoapi.model.Comment;
import net.figueiredo.java.demoapi.repository.CommentRepository;

@RestController
@RequestMapping("/comentarios")
public class CommentController {

	@Autowired
	private CommentRepository repository;

	@GetMapping
	public List<Comment> getAll() {

		// O método "findAll()" do JPA retorna todos os registros em uma lista.
		return repository.findAll();
	}

	@GetMapping(path = "/{articleId}")
	public List<Comment> getOne(@PathVariable Long articleId) {
		return repository.todosOsCometariosDesteArtigo(articleId);
	}

	@PostMapping
	public Comment postNewComment(@RequestBody Comment comment) {
		return repository.save(comment);
	}
}