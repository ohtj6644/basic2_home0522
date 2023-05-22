package com.ll.basic2;

import com.ll.basic2.answer.Answer;
import com.ll.basic2.answer.AnswerRepository;
import com.ll.basic2.question.Question;
import com.ll.basic2.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
class Basic2ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void contextLoads() {
		Optional<Question> oq= this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		this.answerRepository.save(a);

	}

}
