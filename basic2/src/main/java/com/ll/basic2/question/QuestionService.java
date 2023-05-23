package com.ll.basic2.question;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question= this.questionRepository.findById(id);
        // 매개변수로 받은  id 값으로 퀘스쳔 레포지토리에서 해당번호의 질문을 받아옴.
        if(question.isPresent()){
            // 받아온 질문의 값이 존재하는지 확인
            return question.get();
            // 존재하면 해당 질문의 값을 리턴
        }else{
            throw new DataNotFoundException("question net found");
            // 존재하지않으면 데이터 낫 파운드 익셉션을 발생.
        }
    }

}
