package com.ll.basic2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String sbb(){
        return "안녕하세요 sbb에 오신것을 환영합니다.";
    }

    @GetMapping("/")
    public  String mainpage(){
        return "redirect:/question/list";
    }
    // 다른 주소값 없이 /를 입력하면 퀘스쳔리스트로 이동하게 끔 루트를 지정(root url)

}
