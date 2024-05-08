package org.zerock.jdbcex.domain;

import lombok.*;

import java.time.LocalDate;

@Builder //new 필요 없게
@Getter @ToString
@AllArgsConstructor //생성자 추가(모두)
@NoArgsConstructor  //기본 생성자 추가()
public class TodoVO {//entity와 1대1
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
