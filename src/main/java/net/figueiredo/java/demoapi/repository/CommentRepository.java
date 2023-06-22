package net.figueiredo.java.demoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.figueiredo.java.demoapi.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	
	@Query(value="SELECT * FROM comments WHERE cmt_article = :artId ORDER BY cmt_date DESC", nativeQuery = true)
	List<Comment> todosOsCometariosDesteArtigo(@Param("artId") Long artId);
	
}
