package net.figueiredo.java.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.figueiredo.java.demoapi.model.Article;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	

}
