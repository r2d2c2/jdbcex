package org.zerock.jdbcex.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Builder
@Data//해쉬,get,set,tostring,equals //총 5개
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
