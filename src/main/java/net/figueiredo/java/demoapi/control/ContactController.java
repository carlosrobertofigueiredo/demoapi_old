package net.figueiredo.java.demoapi.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.figueiredo.java.demoapi.model.Contact;
import net.figueiredo.java.demoapi.repository.ContactRepository;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactRepository repository;

	@PostMapping
	public Contact postNewContact(@RequestBody Contact contact) {
		return repository.save(contact);
	}

}
