package com.sdd.sbb4;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;


import org.junit.jupiter.api.DisplayName;
import com.sdd.sbb4.question.Question;
import com.sdd.sbb4.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sbb4ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Test
	@DisplayName("단건조회")
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요" , q.getSubject());


		}
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요");
		assertEquals(1, q.getId());

	}

	@Test
	@DisplayName("데이터 수정하기")
	void test007 () {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정 제목");
		this.questionRepository.save(q);
	}

}
