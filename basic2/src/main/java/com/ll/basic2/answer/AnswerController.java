package com.ll.basic2.answer;


import com.ll.basic2.question.Question;
import com.ll.basic2.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;

    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    // 템플릿에서 포스트로 요청을 받기 때문에 포스트맵핑 어노테이션 사용
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        // 템플릿에서 입력받은 컨텐츠값을 추가하기 위해 리퀘스트파람-스트링타입 컨텐츠로 매개변수를 받음

        Question question= this.questionService.getQuestion(id);
        this.answerService.create(question,content);

        return String.format("redirect:/question/detail/%s", id);
        // 작성한 질문을 저장후 다시 해당 디테일 페이지로 리다이렉트.
    }
}
