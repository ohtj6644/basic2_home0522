package com.ll.basic2.question;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    // 컨트롤러에서 레포지토리 가 아닌 서비스를 거쳐가게 끔 수정
    @GetMapping("/list")
    public  String list(Model model){
        List<Question> questionList = this.questionService.getList();
        // 레포지토리의 질문 목록 값을 서비스의 겟리스트로 불러운 후 리스트에 저장
        model.addAttribute("questionList", questionList);
        // 모델객체에 퀘스쳔이름이라는 값을 저장.
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        //겟맵핑의 id 값과 패치베리어블의 id 값이 같아야함.
        Question question= this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        // 퀘스쳔 서비스에 겟 퀘스쳔으로 해당 매개변수값을 아이디로 사용하는 질문을 받아옴.
        // 받아온 질문을 모델객체에 저장
        return "question_detail";
    }
}
