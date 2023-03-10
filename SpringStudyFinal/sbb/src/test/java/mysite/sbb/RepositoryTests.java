package mysite.sbb;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import mysite.sbb.entity.Answer;
import mysite.sbb.entity.Question;
import mysite.sbb.repository.AnswerRepository;
import mysite.sbb.repository.QuestionRepository;

@SpringBootTest

class RepositoryTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	@Transactional
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2); // 두번째 질문 저장
	}

	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb에 대해서 알고 싶습니다.", q.getContent());
	}
	
	@Test
	void findId() {
		Optional<Question> oq = this.questionRepository.findById(7);
	
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?",q.getSubject());
		}
	}

	@Test
	void findSubject() {
		Question q = questionRepository.findBysubject("sbb가 무엇인가요?");
		
		assertEquals(7, q.getId());
	}
	
	@Test
	void 질문_삭제() {
		assertEquals(2,questionRepository.count());
		Optional<Question> oq = questionRepository.findById(7);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		questionRepository.delete(q);
		assertEquals(1,questionRepository.count());
	}
	
	@Test
	@Transactional
	void 댓글() {
		Optional<Question> oq = questionRepository.findById(7);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q); // 어떤 질문의 답변인지 알기위함.
		a.setCreateDate(LocalDateTime.now());
		answerRepository.save(a);
	}
	
	@Test
	void 댓글_전체_조회() {
		List<Answer> aList = answerRepository.findByAnswerAllSearch("자동");
		System.out.println(aList.size());
	}
}
