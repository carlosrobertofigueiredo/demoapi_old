package net.figueiredo.java.demoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.figueiredo.java.demoapi.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	
// boolean existsByCmt_article(Long articleId);
List<Comments> findByCmt_article(Long articleId);	
	
}
