package net.figueiredo.java.demoapi.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.figueiredo.java.demoapi.model.Usuario;
import net.figueiredo.java.demoapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Usuario getOne(@PathVariable Long id) {
		if(usuarioRepository.existsById(id)) {
			return usuarioRepository.findById(id).get();
		}
		return null;
	
	}
	@PostMapping
	public Usuario post(@RequestBody Usuario usuario) {
	       return usuarioRepository.save(usuario);
}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public String delete(@PathVariable Long id) {
		if(usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
			return"{ \"status\" : \"deleted\" }";
			}
		return"{ \"status\" : \"error\" }";
		
		}
	@PatchMapping(path = "/{id}")
	public Usuario patch(@PathVariable Long id, @RequestBody Usuario usuario) {
		return null;
	}
	
}
