package mysite.sbb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mysite.sbb.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@Query(value = "select * from Answer a where a.content like %:content%", nativeQuery = true)
	List<Answer> findByAnswerAllSearch(@Param("content") String content);
}
