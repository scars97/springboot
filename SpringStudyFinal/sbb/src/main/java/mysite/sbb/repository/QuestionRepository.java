package mysite.sbb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mysite.sbb.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	Question findBysubject(String subjcet);
}
