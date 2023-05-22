package com.ll.basic2.question;


import com.ll.basic2.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;


    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer>  answerList;

    // 퀘스쳔 하나에 앤서는 여러개 임으로 리스트로 불러운다 .
    //질문을 삭제하면 그에 달린 답변도 모두 삭제하기 위해 cascade=CascadeType.REMOVE 를 사용
}

